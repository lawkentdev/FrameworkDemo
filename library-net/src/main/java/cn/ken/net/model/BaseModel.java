package cn.ken.net.model;

import cn.ken.net.core.NetworkManager;

public abstract class BaseModel<T> {

    protected T model;

    public BaseModel() {
        model = NetworkManager.getRequest(getApi());
    }

    protected abstract <A extends Class> A getApi();

}
