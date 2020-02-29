package cn.ken.res.widget.tablayout;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * author：  HyZhan
 * create：  2019/1/10 15:44
 */
public class CommonEntry implements CustomTabEntity {

    private String title;
    private int unSelectIcon;
    private int selectIcon;

    public CommonEntry(String title, int unSelectIcon, int selectIcon) {
        this.title = title;
        this.unSelectIcon = unSelectIcon;
        this.selectIcon = selectIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectIcon;
    }
}
