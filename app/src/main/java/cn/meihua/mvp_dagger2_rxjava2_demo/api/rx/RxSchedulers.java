package cn.meihua.mvp_dagger2_rxjava2_demo.api.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Rx线程管理
 * Created by muaj on 2017/9/28.
 */

public class RxSchedulers {
    @SuppressWarnings("unchecked")
    public static <T> ObservableTransformer<T, T> io_main() {

        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
