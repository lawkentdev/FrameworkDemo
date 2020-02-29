package cn.ken.home;

import android.app.Application;

import cn.ken.base.BaseModuleInit;
import cn.ken.base.util.KLog;

public class HomeModuleInit extends BaseModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("首页组件初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        KLog.e("首页组件初始化 -- onInitLow");
        return false;
    }
}
