package jingou.jo.com.yanjie201812.presenter;

import jingou.jo.com.yanjie201812.Model.IMainModel;
import jingou.jo.com.yanjie201812.Model.MianModel;
import jingou.jo.com.yanjie201812.View.IMainActivity;
import jingou.jo.com.yanjie201812.bean.MyBean;
import jingou.jo.com.yanjie201812.net.NetWork;

/**
 * Created by 杨杰 on 2018/1/2.
 */

public class MianPresentr {
    IMainModel iMainModel;
    final IMainActivity iMainActivity;

    public MianPresentr(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iMainModel=new MianModel();
    }
    public void getWin(){
        iMainModel.shouye(new NetWork<MyBean>() {
            @Override
            public void onSuccess(MyBean myBean) {
                iMainActivity.show(myBean);
            }

            @Override
            public void onFailed(Exception e) {

            }
        });
    }
}
