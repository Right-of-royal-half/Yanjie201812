package jingou.jo.com.yanjie201812.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import jingou.jo.com.yanjie201812.R;
import jingou.jo.com.yanjie201812.adpter.Adpter;
import jingou.jo.com.yanjie201812.adpter.MyAdpter;
import jingou.jo.com.yanjie201812.bean.MyBean;
import jingou.jo.com.yanjie201812.presenter.MianPresentr;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private Banner mBanner;
    private RecyclerView mRlv;
    private MianPresentr mianPresentr;
    private List<String> list = new ArrayList<>();
    private MyAdpter myAdpter;
    private RecyclerView mRlv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mianPresentr = new MianPresentr(this);
        mianPresentr.getWin();
        initView();
    }

    @Override
    public void show(MyBean myBean) {
        for (int i = 0; i < myBean.getData().getAd1().size(); i++) {

            String image = myBean.getData().getAd1().get(i).getImage();

            list.add(image);

        }
        mBanner.setImages(list);

        mBanner.setImageLoader(new GlideImageLoader());

        mBanner.setBannerAnimation(Transformer.DepthPage);

        mBanner.setDelayTime(2000);

//启动banner

        mBanner.start();
        second(myBean);
        Dtm(myBean);
    }

    private void second(MyBean myBean) {
        Adpter adpter = new Adpter(MainActivity.this, myBean.getData().getAd5());
        mRlv2.setAdapter(adpter);
    }

    private void Dtm(MyBean myBean) {
        myAdpter = new MyAdpter(MainActivity.this, myBean.getData().getDefaultGoodsList());
        mRlv.setAdapter(myAdpter);
    }

    private void initView() {
        mBanner = (Banner) findViewById(R.id.banner);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRlv2 = (RecyclerView) findViewById(R.id.rlv2);
        mRlv2.setLayoutManager(new GridLayoutManager(MainActivity.this,4));
    }
}
