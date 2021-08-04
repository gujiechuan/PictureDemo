package com.example.meeriaddemo.Stack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.meeriaddemo.R;

import java.util.List;

public class PileAvertView extends LinearLayout {


    PileLayout pileView;
TextView text_view;
    private Context context = null;
    public static final int VISIBLE_COUNT = 3;//默认显示个数

    public PileAvertView(Context context) {
        this(context, null);
        this.context = context;
    }

    public PileAvertView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_group_pile_avert, this);
        pileView=view.findViewById(R.id.pile_view);
        text_view=view.findViewById(R.id.text_view);
    }

    public void setAvertImages(List<String> imageList) {
        setAvertImages(imageList,VISIBLE_COUNT);
    }

    //如果imageList>visiableCount,显示List最上面的几个
    public void setAvertImages(List<String> imageList, int visibleCount) {
        List<String> visibleList = null;
        if (imageList.size() > visibleCount) {
            visibleList = imageList.subList(imageList.size() - 1 - visibleCount, imageList.size() - 1);
        }
        pileView.removeAllViews();
        for (int i = 0; i < visibleList.size(); i++) {
            StackCircleImageView image= (StackCircleImageView) LayoutInflater.from(context).inflate(R.layout.item_praise, pileView, false);
            Glide.with(context).load(visibleList.get(i)).into(image);
            pileView.addView(image);
        }
        text_view.setText(imageList.size()+"+");
    }

}