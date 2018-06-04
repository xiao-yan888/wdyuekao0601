package com.example.administrator.wdyuekao0601.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.wdyuekao0601.R;
import com.example.administrator.wdyuekao0601.bean.RequestData;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<RequestData.ResultBean.DataBean> data;
    private final LayoutInflater inflater;

    public RvAdapter(Context context, List<RequestData.ResultBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

   public interface OnItemClickListener{
        void OnItemClick(RequestData.ResultBean.DataBean dataBean);
   }
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, null);
        RvViewHolder rvViewHolder = new RvViewHolder(view);
        return rvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final RequestData.ResultBean.DataBean dataBean = data.get(position);
        RvViewHolder rvViewHolder = (RvViewHolder) holder;
        rvViewHolder.sdv.setImageURI(dataBean.getAlbums().get(0));
        rvViewHolder.tv_con.setText(dataBean.getTags());
        rvViewHolder.tv_name.setText(dataBean.getTitle());
        rvViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null) {
                    onItemClickListener.OnItemClick(dataBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class RvViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv_name;
        private final TextView tv_con;
        private final LinearLayout ll;

        public RvViewHolder(View itemView) {
            super(itemView);
            tv_con = itemView.findViewById(R.id.tv_con);
            tv_name = itemView.findViewById(R.id.tv_name);
            sdv = itemView.findViewById(R.id.sdv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
