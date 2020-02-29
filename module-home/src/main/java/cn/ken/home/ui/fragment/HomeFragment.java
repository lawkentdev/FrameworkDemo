package cn.ken.home.ui.fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.ken.base.router.RouterFragmentPath;
import cn.ken.base.ui.fragment.BaseFragment;
import cn.ken.home.delegate.HomeFragmentDelegate;

@Route(path = RouterFragmentPath.Home.PAGER_HOME)
public class HomeFragment extends BaseFragment<HomeFragmentDelegate> {

    @Override
    protected Class<HomeFragmentDelegate> getDelegateClass() {
        return HomeFragmentDelegate.class;
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }
}
