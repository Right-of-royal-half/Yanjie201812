package jingou.jo.com.yanjie201812.Model;

import jingou.jo.com.yanjie201812.bean.MyBean;
import jingou.jo.com.yanjie201812.net.NetWork;
import jingou.jo.com.yanjie201812.url.RetrfitHelper;
import jingou.jo.com.yanjie201812.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2018/1/2.
 */

public class MianModel implements IMainModel {
    @Override
    public void shouye(final NetWork<MyBean> myBeanNetWork) {
        ServiceApi serviceApi = RetrfitHelper.getserviceapi();
        serviceApi.mybean()
                //切换被观察者发送的的线程
                .subscribeOn(Schedulers.io())

                .unsubscribeOn(Schedulers.io())
                //切换观察者接收的线程为主线程
                .observeOn(AndroidSchedulers.mainThread())
                //
                .subscribe(new Subscriber<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        myBeanNetWork.onSuccess(myBean);
                    }
                });
    }
}
