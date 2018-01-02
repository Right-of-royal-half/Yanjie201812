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

public class MyAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<MyBean.DataBean.DefaultGoodsListBean> list;

    public MyAdpter(Context context, List<MyBean.DataBean.DefaultGoodsListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType%2==0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new MyViewHolder(view);
        }
        else if(viewType%2==1){
            View view1 = LayoutInflater.from(context).inflate(R.layout.item3, parent, false);
            return new MyViewHolder2(view1);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position%2==0) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.sdv.setImageURI(list.get(position).getGoods_img());
            myViewHolder.tv.setText(list.get(position).getGoods_name());
        }
        else if (position%2==1){
            MyViewHolder2 myViewHolder= (MyViewHolder2) holder;
            myViewHolder.sdv2.setImageURI(list.get(position).getGoods_img());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return 2;
        }else if (position%2==1){
            return 3;
        }
        return super.getItemViewType(position);
    }
    class  MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv = itemView.findViewById(R.id.tv);

        }
    }
    class  MyViewHolder2 extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv2;
        public MyViewHolder2(View itemView) {
            super(itemView);
            sdv2 = itemView.findViewById(R.id.sdv2);

        }
    }
}
