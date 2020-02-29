package cn.ken.main.ui.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import cn.ken.base.router.RouterActivityPath;
import cn.ken.base.router.RouterFragmentPath;
import cn.ken.base.ui.activity.BaseActivity;
import cn.ken.base.ui.adapter.FragmentViewPagerAdapter;
import cn.ken.main.R;
import cn.ken.main.delegate.MainActivityDelegate;
import cn.ken.res.widget.tablayout.CommonEntry;
import cn.ken.res.widget.tablayout.SimpleOnTabSelectListener;

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity<MainActivityDelegate> {
    private FragmentViewPagerAdapter fragmentAdapter;

    @Override
    protected Class<MainActivityDelegate> getDelegateClass() {
        return MainActivityDelegate.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
        initBottomTab();
    }

    private void initFragment() {
        fragmentAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        ArrayList<Fragment> mFragments = new ArrayList<>();
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME).navigation();
        Fragment meFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.User.PAGER_ME).navigation();
        mFragments.add(homeFragment);
        mFragments.add(meFragment);
        fragmentAdapter.setFragments(mFragments);
        viewDelegate.initViewPager(fragmentAdapter);
    }

    private void initBottomTab() {
        ArrayList<CustomTabEntity> tabEntities = new ArrayList<>();
        tabEntities.add(new CommonEntry("首页", R.mipmap.ic_home_normal, R.mipmap.ic_home_selected));
        tabEntities.add(new CommonEntry("我的", R.mipmap.ic_me_normal, R.mipmap.ic_me_selected));
        viewDelegate.initTabLayout(tabEntities, new SimpleOnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                super.onTabSelect(position);
                viewDelegate.setCurrentTab(position);
            }

            @Override
            public void onTabReselect(int position) {
                super.onTabReselect(position);

            }
        });

    }
}
