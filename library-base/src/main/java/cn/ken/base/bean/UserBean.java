package cn.ken.base.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class UserBean implements Parcelable {
    private long id;
    private String name;
    private String account;
    private String token;

    public UserBean() {
    }

    protected UserBean(Parcel in) {
        id = in.readLong();
        name = in.readString();
        account = in.readString();
        token = in.readString();
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel in) {
            return new UserBean(in);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(account);
        dest.writeString(token);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static Creator<UserBean> getCREATOR() {
        return CREATOR;
    }
}
