package cn.ken.base.contract;

/**
 * 登录完成后，组件间通信的契约类
 */

public class _Login {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
