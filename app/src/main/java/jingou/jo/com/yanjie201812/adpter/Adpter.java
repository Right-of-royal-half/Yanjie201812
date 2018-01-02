package jingou.jo.com.yanjie201812.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import jingou.jo.com.yanjie201812.R;
import jingou.jo.com.yanjie201812.bean.MyBean;

/**
 * Created by 杨杰 on 2018/1/2.
 */

public class Adpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MyBean.DataBean.Ad5Bean> list;

    public Adpter(Context context, List<MyBean.DataBean.Ad5Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.sdv.setImageURI(list.get(position).getImage());
        myViewHolder.tv.setText(list.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv = itemView.findViewById(R.id.tv);

        }
    }

}
