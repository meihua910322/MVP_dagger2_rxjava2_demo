package cn.meihua.mvp_dagger2_rxjava2_demo.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import cn.meihua.mvp_dagger2_rxjava2_demo.R;

/**
 * 状态栏
 * 注意：android:fitsSystemWindows 默认未设置默认为false
 * 注意2：android:fitsSystemWindows  多个fragment只有第一个设置有效
 *
 * @author muaj
 * @date 2018/1/9
 */

public class StatusBarUtils {

    public static final int DEFAULT_STATUS_BAR_ALPHA = 30;
    private static final int FAKE_STATUS_BAR_VIEW_ID = R.id.statusbarutil_fake_status_bar_view;

    /**========================================== 透明状态栏 ================================*/

    /**
     * 设置状态栏全透明
     *
     * @param activity 需要设置的activity
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }



    /**======================================== 半透明状态栏 ================================*/

    /**
     * 使状态栏半透明
     * <p>
     * 适用于图片作为背景的界面,此时需要图片填充到状态栏
     *
     * @param activity       需要设置的activity
     * @param statusBarAlpha 状态栏透明度
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setTranslucent(Activity activity, @IntRange(from = 0, to = 255) int statusBarAlpha) {
        setTransparent(activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(Color.argb(statusBarAlpha, 0, 0, 0));
        } else {
            ViewGroup contentView = activity.findViewById(android.R.id.content);
            View fakeTranslucentView = contentView.findViewById(FAKE_STATUS_BAR_VIEW_ID);
            if (fakeTranslucentView != null) {
                if (fakeTranslucentView.getVisibility() == View.GONE) {
                    fakeTranslucentView.setVisibility(View.VISIBLE);
                }
                fakeTranslucentView.setBackgroundColor(Color.argb(statusBarAlpha, 0, 0, 0));
            } else {
                fakeTranslucentView = createStatusBarView(activity);
                fakeTranslucentView.setBackgroundColor(Color.argb(statusBarAlpha, 0, 0, 0));
                contentView.addView(fakeTranslucentView);
            }
        }
    }

    public static void setTranslucent(Activity activity) {
        setTranslucent(activity, DEFAULT_STATUS_BAR_ALPHA);
    }

    /**=============================================== 纯色状态栏 ===================================*/

    /**
     * 设置状态栏颜色
     *
     * @param activity       需要设置的activity
     * @param color          状态栏颜色值
     * @param statusBarAlpha 状态栏透明度
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setColor(Activity activity, @ColorInt int color, @IntRange(from = 0, to = 255) int statusBarAlpha) {
//        setTransparent(activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(calculateStatusColor(color, statusBarAlpha));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            View fakeStatusBarView = decorView.findViewById(FAKE_STATUS_BAR_VIEW_ID);
            if (fakeStatusBarView != null) {
                if (fakeStatusBarView.getVisibility() == View.GONE) {
                    fakeStatusBarView.setVisibility(View.VISIBLE);
                }
                fakeStatusBarView.setBackgroundColor(calculateStatusColor(color, statusBarAlpha));
            } else {
                fakeStatusBarView = createStatusBarView(activity);
                fakeStatusBarView.setBackgroundColor(calculateStatusColor(color, statusBarAlpha));
                decorView.addView(fakeStatusBarView);
            }
        }
    }


    public static void setColor(Activity activity, @ColorInt int color) {
        setColor(activity, color, 0);
    }

    /**
     * 生成一个和状态栏大小相同的矩形条
     *
     * @param activity 需要设置的activity
     * @return 状态栏矩形条
     */
    private static View createStatusBarView(Activity activity) {
        View statusBarView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setId(FAKE_STATUS_BAR_VIEW_ID);
        return statusBarView;
    }

    /**===============================================  设置状态栏图标 浅色/深色========================================*/

    /**
     * 设置状态栏图标浅色/深色
     * 这个Flag只有在使用了FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS 并且没有使用 FLAG_TRANSLUCENT_STATUS的时候才有效
     * 也就是只有在状态栏全透明的时候才有效。
     *
     * @param bDark
     */
    public static void setStatusBarDark(Activity activity, boolean bDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (AppUtils.isMIUI()) {
                setMiuiStatusBarDarkMode(activity, bDark);
            } else if (AppUtils.isFlyme()) {
                setMeizuStatusBarDarkIcon(activity, bDark);
            } else {
                View decorView = activity.getWindow().getDecorView();
                if (decorView != null) {
                    int vis = decorView.getSystemUiVisibility();
                    if (bDark) {
                        // View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR这个字段就是把状态栏标记为浅色
                        // 然后状态栏的字体颜色自动转换为深色 只能在Android6.0及以后的版本中实现。
                        //这里暗藏一个坑：MIUI6+自己实现了浅色状态栏，6.0的这个设置在小米手机上无效
                        vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                    } else {
                        vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                    }
                    decorView.setSystemUiVisibility(vis);
                }
            }
        }
    }

    //设置成白色的背景，字体颜色为黑色。MIUI
    public static boolean setMiuiStatusBarDarkMode(Activity activity, boolean darkmode) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //设置成白色的背景，字体颜色为黑色。 Flyme
    public static boolean setMeizuStatusBarDarkIcon(Activity activity, boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**===============================================  其他 ========================================*/
    /**
     * 获取状态栏高度
     *
     * @param context context
     * @return 状态栏高度
     */
    private static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }


    /**
     * 计算状态栏颜色
     *
     * @param color color值
     * @param alpha alpha值
     * @return 最终的状态栏颜色
     */
    private static int calculateStatusColor(@ColorInt int color, int alpha) {
        if (alpha == 0) {
            return color;
        }
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }


    /**
     * 设置根布局的 FitsSystemWindows
     */
    public static void setRootFitsSystemWindows(Activity activity, Boolean isFitsSystemWindows) {
        ViewGroup parent = activity.findViewById(android.R.id.content);
        for (int i = 0, count = parent.getChildCount(); i < count; i++) {
            View childView = parent.getChildAt(i);
            if (childView instanceof ViewGroup) {
                childView.setFitsSystemWindows(isFitsSystemWindows);
                //((ViewGroup) childView).setClipToPadding(isFitsSystemWindows);
            }
        }
    }


    /**
     * 隐藏伪状态栏 View
     *
     * @param activity 调用的 Activity
     */
    public static void hideFakeStatusBarView(Activity activity) {
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        View fakeStatusBarView = decorView.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (fakeStatusBarView != null) {
            fakeStatusBarView.setVisibility(View.GONE);
        }
    }

    /**
     * 显示伪状态栏 View
     *
     * @param activity 调用的 Activity
     */
    public static void showFakeStatusBarView(Activity activity) {
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        View fakeStatusBarView = decorView.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (fakeStatusBarView != null) {
            fakeStatusBarView.setVisibility(View.VISIBLE);
        }
    }
}
