package jingou.jo.com.yanjie201812.url;

import jingou.jo.com.yanjie201812.bean.MyBean;
import jingou.jo.com.yanjie201812.net.Api;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 杨杰 on 2018/1/2.
 */

public interface ServiceApi {
    @GET(Api.LOGIN)
    Observable<MyBean> mybean();
}
