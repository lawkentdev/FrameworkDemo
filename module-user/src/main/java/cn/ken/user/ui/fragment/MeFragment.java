package cn.ken.user.ui.fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.ken.base.router.RouterFragmentPath;
import cn.ken.base.ui.fragment.BaseFragment;
import cn.ken.user.delegate.MeFragmentDelegate;

@Route(path = RouterFragmentPath.User.PAGER_ME)
public class MeFragment extends BaseFragment<MeFragmentDelegate> {

    @Override
    protected Class<MeFragmentDelegate> getDelegateClass() {
        return MeFragmentDelegate.class;
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }
}
