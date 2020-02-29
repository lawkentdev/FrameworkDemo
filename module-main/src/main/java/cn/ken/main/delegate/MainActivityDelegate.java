package cn.ken.main.delegate;

import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import cn.ken.base.ui.adapter.FragmentViewPagerAdapter;
import cn.ken.base.ui.delegate.BaseDelegate;
import cn.ken.main.R;
import cn.ken.main.R2;

public class MainActivityDelegate extends BaseDelegate {
    @BindView(R2.id.vp_main)
    ViewPager viewPager;
    @BindView(R2.id.tab_main)
    CommonTabLayout tabLayout;

    @Override
    protected int getMainLayoutId() {
        return R.layout.main_activity;
    }

    public CommonTabLayout getTabLayout() {
        return tabLayout;
    }

    public void initTabLayout(ArrayList<CustomTabEntity> tabEntities, OnTabSelectListener onTabSelectListener) {
        tabLayout.setOnTabSelectListener(onTabSelectListener);
        tabLayout.setTabData(tabEntities);
        tabLayout.setCurrentTab(0);
    }

    public void initViewPager(FragmentViewPagerAdapter adapter) {
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    public void setCurrentTab(int index) {
        tabLayout.setCurrentTab(index);
        viewPager.setCurrentItem(index);
    }
}
