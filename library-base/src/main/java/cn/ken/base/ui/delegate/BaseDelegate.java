package cn.ken.base.ui.delegate;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseDelegate extends AppDelegate {

    protected LinearLayout rootView;
    protected Unbinder unbinder;

    public ViewGroup onCreateView() {
        rootView = new LinearLayout(getActivity());
        rootView.setOrientation(LinearLayout.VERTICAL);
        rootView.addView(getMainView(), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        return rootView;
    }

    @Override
    public void initWidget() {
        unbinder = ButterKnife.bind(this, rootView);
    }

    public void onInVisibleWidget() {

    }

    public void onVisibleWidget() {

    }

    @Override
    public void onDestroyWidget() {
        if (unbinder != null) unbinder.unbind();
        unbinder = null;
    }

    public LinearLayout getRootView() {
        return rootView;
    }

    public void setRootView(LinearLayout rootView) {
        this.rootView = rootView;
    }

}
