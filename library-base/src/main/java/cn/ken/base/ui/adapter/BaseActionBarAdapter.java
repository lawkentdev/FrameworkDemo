package cn.ken.base.ui.adapter;

import android.view.ViewGroup;

public interface BaseActionBarAdapter {

    void injectView(ViewGroup viewGroup);

    void hideStatusBar();

    void showStatusBar();

    void release();

    void setOnClickLeftListener(OnClickLeftListener listener);

    void setOnClickRightListener(OnClickRightListener listener);

    interface OnClickLeftListener {
        void onClick();
    }

    interface OnClickRightListener {
        void onClick();
    }

}
