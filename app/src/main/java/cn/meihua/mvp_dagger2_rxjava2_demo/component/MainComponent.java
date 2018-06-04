package cn.meihua.mvp_dagger2_rxjava2_demo.component;

import cn.meihua.mvp_dagger2_rxjava2_demo.ui.activity.MainActivity;
import dagger.Component;

/**
 * Created by meihua_pc on 2018/6/4.
 */

@Component(dependencies = AppComponent.class)
public interface MainComponent {
    MainActivity inject(MainActivity activity);
}
