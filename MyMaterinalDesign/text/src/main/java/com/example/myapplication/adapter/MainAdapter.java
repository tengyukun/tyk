package com.example.myapplication.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{


    Activity activity;

    public MainAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=View.inflate(activity,R.layout.item_card,null);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);

        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cv_main_content;

        public ViewHolder(View itemView) {
            super(itemView);
            cv_main_content= (CardView) itemView.findViewById(R.id.cv_main_content);
        }
    }
}
