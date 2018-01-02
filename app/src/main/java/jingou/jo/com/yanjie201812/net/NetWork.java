package jingou.jo.com.yanjie201812.net;

/**
 * Created by 杨杰 on 2018/1/2.
 */

public interface NetWork<T>{
    public void onSuccess(T t);
    public void onFailed(Exception e);
}
