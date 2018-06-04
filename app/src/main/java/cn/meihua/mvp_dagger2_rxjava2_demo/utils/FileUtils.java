/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.meihua.mvp_dagger2_rxjava2_demo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import cn.meihua.mvp_dagger2_rxjava2_demo.common.Constant;
import okhttp3.Response;

/**
 * @author yuyh.
 * @date 16/4/9.
 */
public class FileUtils {

    private static final int BUFFER = 8192;


    /**
     * 创建临时文件
     *
     * @return
     */
    public static File createTempFile() {
        String src = Constant.PATH_DATA + "/" + System.currentTimeMillis();
        File file = new File(src);
        if (!file.exists())
            createFile(file);
        return file;
    }


    public static String getPathOPF(String unzipDir) {
        String mPathOPF = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(unzipDir
                    + "/META-INF/container.xml"), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("full-path")) {
                    int start = line.indexOf("full-path");
                    int start2 = line.indexOf('\"', start);
                    int stop2 = line.indexOf('\"', start2 + 1);
                    if (start2 > -1 && stop2 > start2) {
                        mPathOPF = line.substring(start2 + 1, stop2).trim();
                        break;
                    }
                }
            }
            br.close();

            if (!mPathOPF.contains("/")) {
                return null;
            }

            int last = mPathOPF.lastIndexOf('/');
            if (last > -1) {
                mPathOPF = mPathOPF.substring(0, last);
            }

            return mPathOPF;
        } catch (NullPointerException | IOException e) {
//            LogUtils.e(e.toString());
        }
        return mPathOPF;
    }

    public static boolean checkOPFInRootDirectory(String unzipDir) {
        String mPathOPF = "";
        boolean status = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(unzipDir
                    + "/META-INF/container.xml"), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("full-path")) {
                    int start = line.indexOf("full-path");
                    int start2 = line.indexOf('\"', start);
                    int stop2 = line.indexOf('\"', start2 + 1);
                    if (start2 > -1 && stop2 > start2) {
                        mPathOPF = line.substring(start2 + 1, stop2).trim();
                        break;
                    }
                }
            }
            br.close();

            status = !mPathOPF.contains("/");
        } catch (NullPointerException | IOException e) {
            LogUtils.e(e.toString());
        }
        return status;
    }

    /**
     * 解压文件
     *
     * @param inputZip
     * @param destinationDirectory
     * @throws IOException
     */
    public static void unzipFile(String inputZip, String destinationDirectory) throws IOException {

        int buffer = 2048;
        List<String> zipFiles = new ArrayList<>();
        File sourceZipFile = new File(inputZip);
        File unzipDirectory = new File(destinationDirectory);

        createDir(unzipDirectory.getAbsolutePath());

        ZipFile zipFile;
        zipFile = new ZipFile(sourceZipFile, ZipFile.OPEN_READ);
        Enumeration zipFileEntries = zipFile.entries();

        while (zipFileEntries.hasMoreElements()) {

            ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
            String currentEntry = entry.getName();
            File destFile = new File(unzipDirectory, currentEntry);

            if (currentEntry.endsWith(Constant.SUFFIX_ZIP)) {
                zipFiles.add(destFile.getAbsolutePath());
            }

            File destinationParent = destFile.getParentFile();
            createDir(destinationParent.getAbsolutePath());

            if (!entry.isDirectory()) {

                if (destFile != null && destFile.exists()) {
//                    LogUtils.i(destFile + "已存在");
                    continue;
                }

                BufferedInputStream is = new BufferedInputStream(zipFile.getInputStream(entry));
                int currentByte;
                // buffer for writing file
                byte[] data = new byte[buffer];

                FileOutputStream fos = new FileOutputStream(destFile);
                BufferedOutputStream dest = new BufferedOutputStream(fos, buffer);

                while ((currentByte = is.read(data, 0, buffer)) != -1) {
                    dest.write(data, 0, currentByte);
                }
                dest.flush();
                dest.close();
                is.close();
            }
        }
        zipFile.close();

        for (String zipName : zipFiles) {
            unzipFile(zipName, destinationDirectory + File.separatorChar
                    + zipName.substring(0, zipName.lastIndexOf(Constant.SUFFIX_ZIP)));
        }
    }

    /**
     * 读取Assets文件
     *
     * @param fileName
     * @return
     */
    public static byte[] readAssets(String fileName) {
        if (fileName == null || fileName.length() <= 0) {
            return null;
        }
        byte[] buffer = null;
        try {
            InputStream fin = AppUtils.getAppContext().getAssets().open("uploader" + fileName);
            int length = fin.available();
            buffer = new byte[length];
            fin.read(buffer);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return buffer;
        }
    }

    /**
     * 创建根缓存目录
     *
     * @return
     */
    public static String createRootPath(Context context) {
        String cacheRootPath = "";
        if (isSdCardAvailable()) {
            // /sdcard/Android/data/<application package>/cache
            cacheRootPath = context.getExternalCacheDir().getPath();
        } else {
            // /data/data/<application package>/cache
            cacheRootPath = context.getCacheDir().getPath();
        }
        return cacheRootPath;
    }

    public static boolean isSdCardAvailable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * 递归创建文件夹
     *
     * @param dirPath
     * @return 创建失败返回""
     */
    public static String createDir(String dirPath) {
        try {
            File file = new File(dirPath);
            if (file.getParentFile().exists()) {
//                LogUtils.i("----- 创建文件夹" + file.getAbsolutePath());
                file.mkdir();
                return file.getAbsolutePath();
            } else {
                createDir(file.getParentFile().getAbsolutePath());
//                LogUtils.i("----- 创建文件夹" + file.getAbsolutePath());
                file.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirPath;
    }

    /**
     * 递归创建文件夹
     *
     * @param file
     * @return 创建失败返回""
     */
    public static String createFile(File file) {
        try {
            if (file.getParentFile().exists()) {
//                LogUtils.i("----- 创建文件" + file.getAbsolutePath());
                file.createNewFile();
                return file.getAbsolutePath();
            } else {
                createDir(file.getParentFile().getAbsolutePath());
                file.createNewFile();
//                LogUtils.i("----- 创建文件" + file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将内容写入文件
     *
     * @param filePath eg:/mnt/sdcard/demo.txt
     * @param content  内容
     * @param isAppend 是否追加
     */
    public static void writeFile(String filePath, String content, boolean isAppend) {
//        LogUtils.i("save:" + filePath);
        try {
            FileOutputStream fout = new FileOutputStream(filePath, isAppend);
            byte[] bytes = content.getBytes();
            fout.write(bytes);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String filePathAndName, String fileContent) {
        try {
            OutputStream outstream = new FileOutputStream(filePathAndName);
            OutputStreamWriter out = new OutputStreamWriter(outstream);
            out.write(fileContent);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Raw下的文件内容
     *
     * @param context
     * @param resId
     * @return 文件内容
     */
    public static String getFileFromRaw(Context context, int resId) {
        if (context == null) {
            return null;
        }

        StringBuilder s = new StringBuilder();
        try {
            InputStreamReader in = new InputStreamReader(context.getResources().openRawResource(resId));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                s.append(line);
            }
            return s.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] getBytesFromFile(File f) {
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            for (int n; (n = stream.read(b)) != -1; ) {
                out.write(b, 0, n);
            }
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件拷贝
     *
     * @param src  源文件
     * @param desc 目的文件
     */
    public static void fileChannelCopy(File src, File desc) {
        //createFile(src);
        createFile(desc);
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            fi = new FileInputStream(src);
            fo = new FileOutputStream(desc);
            FileChannel in = fi.getChannel();//得到对应的文件通道
            FileChannel out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fo != null)
                    fo.close();
                if (fi != null)
                    fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 复制文件
    public static void copyFile(File sourceFile, File targetFile)
            throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            byte[] buffer = new byte[BUFFER];
            int length;
            while ((length = inBuff.read(buffer)) != -1) {
                outBuff.write(buffer, 0, length);
            }
            outBuff.flush();
        } finally {
            if (inBuff != null) {
                inBuff.close();
            }
            if (outBuff != null) {
                outBuff.close();
            }
        }
    }

    /**
     * 转换文件大小
     *
     * @param fileLen 单位B
     * @return
     */
    public static String formatFileSizeToString(long fileLen) {
        DecimalFormat df = new DecimalFormat("0.00");
        String fileSizeString = "";
        if (fileLen < 1024) {
            fileSizeString = df.format((double) fileLen) + "B";
        } else if (fileLen < 1048576) {
            fileSizeString = df.format((double) fileLen / 1024) + "K";
        } else if (fileLen < 1073741824) {
            fileSizeString = df.format((double) fileLen / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileLen / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 删除指定文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static boolean deleteFile(File file) throws IOException {
        return deleteFileOrDirectory(file);
    }

    /**
     * 删除指定文件，如果是文件夹，则递归删除
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static boolean deleteFileOrDirectory(File file) throws IOException {
        try {
            if (file != null && file.isFile()) {
                return file.delete();
            }
            if (file != null && file.isDirectory()) {
                File[] childFiles = file.listFiles();
                // 删除空文件夹
                if (childFiles == null || childFiles.length == 0) {
                    return file.delete();
                }
                // 递归删除文件夹下的子文件
                for (File childFile : childFiles) {
                    deleteFileOrDirectory(childFile);
                }
                return file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取文件夹大小
     *
     * @return
     * @throws Exception
     */
    public static long getFolderSize(String dir) throws Exception {
        File file = new File(dir);
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (File aFileList : fileList) {
                // 如果下面还有文件
                if (aFileList.isDirectory()) {
                    size = size + getFolderSize(aFileList.getAbsolutePath());
                } else {
                    size = size + aFileList.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    /***
     * 获取文件扩展名
     *
     * @param filename 文件名
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * 获取文件内容
     *
     * @param path
     * @return
     */
    public static String getFileOutputString(String path, String charset) {
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append("\n").append(line);
            }
            bufferedReader.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 递归获取所有文件
     *
     * @param root
     * @param ext  指定扩展名
     */
    private synchronized void getAllFiles(File root, String ext) {
        List<File> list = new ArrayList<>();
        File files[] = root.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    getAllFiles(f, ext);
                } else {
                    if (f.getName().endsWith(ext) && f.length() > 50)
                        list.add(f);
                }
            }
        }
    }

    public static String getCharset(String fileName) {
        BufferedInputStream bis = null;
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            bis = new BufferedInputStream(new FileInputStream(fileName));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1)
                return charset;
            if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE
                    && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF
                    && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8";
                checked = true;
            }
            bis.mark(0);
            if (!checked) {
                while ((read = bis.read()) != -1) {
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            // 双字节 (0xC0 - 0xDF)
                            // (0x80 - 0xBF),也可能在GB编码内
                        } else {
                            break;
                        }
                    } else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return charset;
    }

    public static String getCharset1(String fileName) throws IOException {
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();

        String code;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        return code;
    }

    public static void saveWifiTxt(String src, String desc) {
        byte[] LINE_END = "\n".getBytes();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(src), getCharset(src));
            BufferedReader br = new BufferedReader(isr);

            FileOutputStream fout = new FileOutputStream(desc, true);
            String temp;
            while ((temp = br.readLine()) != null) {
                byte[] bytes = temp.getBytes();
                fout.write(bytes);
                fout.write(LINE_END);
            }
            br.close();
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建图片File对象
     *
     * @return
     */
    public static File createImageFile() {
        File imageFile = null;
        String storagePath;
        File storageDir;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        try {
            storagePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + "camera";
            //storagePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + File.separator + "camerademo";
            //storagePath = App.getInstance().getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            //storagePath = App.getInstance().getExternalCacheDir().getAbsolutePath() + File.separator + "camerademo";
            //storagePath = App.getInstance().getFilesDir().getAbsolutePath() + File.separator + "images";
            storageDir = new File(storagePath);
            storageDir.mkdirs();
            imageFile = File.createTempFile(timeStamp, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFile;
    }


    /**
     * 头像图片保存路径
     *
     * @return
     */
    public static String getImageSavePath() {
        String storagePath = "";
        if (isSdCardAvailable()) {
            storagePath = AppUtils.getAppContext().getExternalCacheDir() + "/" + "photo";
        } else {
            storagePath = AppUtils.getAppContext().getCacheDir() + "/" + "photo";
        }
        File f = new File(storagePath);
        if (!f.exists()) {
            f.mkdir();
        }
        return storagePath;
    }

    /**
     * 上传文件夹
     *
     * @return
     */
    public static String getUploadPath() {
        String storagePath;

        if (isSdCardAvailable()) {
            //                storagePath = AppUtils.getAppContext().getFilesDir().getAbsolutePath()+"/"+"kyc_photo";
            storagePath = AppUtils.getAppContext().getExternalCacheDir() + "/" + "upload";
            //                storagePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/" + AppUtils.getAppContext().getPackageName()+"/"+"kyc_photo";
        } else {
            storagePath = AppUtils.getAppContext().getCacheDir() + "/" + "upload";
        }
        File f = new File(storagePath);
        if (!f.exists()) {
            f.mkdir();
        }

        return storagePath;
    }

    public static String getApkSavePath() {
        String storagePath;
        if (isSdCardAvailable()) {
//                            storagePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/" + AppUtils.getAppContext().getPackageName()+"/"+"apk/";
            //                storagePath = AppUtils.getAppContext().getFilesDir().getAbsolutePath()+"/"+"apk/";
            storagePath = AppUtils.getAppContext().getExternalCacheDir() + "/" + "apk";
        } else {
            storagePath = AppUtils.getAppContext().getCacheDir() + "/" + "apk";
        }
        File f = new File(storagePath);
        if (!f.exists()) {
            f.mkdir();
        }
        return storagePath;
    }

    public static String getLoadingPicPath() {
        String storagePath;
        if (isSdCardAvailable()) {
            //                storagePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/" + AppUtils.getAppContext().getPackageName()+"/"+"apk/";
            //                storagePath = AppUtils.getAppContext().getFilesDir().getAbsolutePath()+"/"+"apk/";
            storagePath = AppUtils.getAppContext().getExternalCacheDir() + "/" + "loading_pic";
        } else {
            storagePath = AppUtils.getAppContext().getCacheDir() + "/" + "loading_pic";
        }
        File f = new File(storagePath);
        if (!f.exists()) {
            f.mkdir();
        }
        return storagePath;
    }

    /**
     * 获取启动页图片地址
     *
     * @return
     */
    public static String getLoadingPicName() {
        return getLoadingPicPath() + "/" + Constant.LOADING_PIC_PATH;
    }

    /**
     * 保存loading图片
     *
     * @param response
     */
    public static void saveLoadingPic(Response response) {
        InputStream inputStream = null;
        FileOutputStream out = null;
        try {
            inputStream = response.body().byteStream();
            //将输入流数据转化为Bitmap位图数据
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            File file = new File(getLoadingPicName());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            //创建文件输出流对象用来向文件中写入数据
            out = new FileOutputStream(file);
            //将bitmap存储为jpg格式的图片
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            //刷新文件流
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 保存KYC Bitmap到sdcard
     *
     * @param b
     */
    public static void saveImageBitmap(String kycName, Bitmap b) {
        BufferedOutputStream bos = null;
        try {
            String path = getImageSavePath();
            String jpegName = path + "/" + kycName + ".jpg";
            FileOutputStream fout = new FileOutputStream(jpegName);
            bos = new BufferedOutputStream(fout);
            b.compress(Bitmap.CompressFormat.JPEG, 100, bos);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.flush();
                bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 根据URL直接读文件内容，前提是这个文件当中的内容是文本，函数的返回值就是文件当中的内容
     */
    public static String readTxtFile(String urlStr, String encoding) {
        StringBuffer sb = new StringBuffer();
        String line = null;
        BufferedReader buffer = null;
        try {
            // 创建一个URL对象
            URL url = new URL(urlStr);
            // 创建一个Http连接
            HttpURLConnection urlConn = (HttpURLConnection) url
                    .openConnection();
            // 使用IO流读取数据
            buffer = new BufferedReader(new InputStreamReader(urlConn
                    .getInputStream(), encoding));
            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}