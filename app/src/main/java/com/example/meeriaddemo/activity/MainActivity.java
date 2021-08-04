package com.example.meeriaddemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.meeriaddemo.R;
import com.example.meeriaddemo.Stack.PileAvertView;
import com.example.meeriaddemo.Stack.StackCircleImageView;
import com.example.meeriaddemo.Stack.PileLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button normal, advance, progress;
    PileAvertView pile_layout;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        normal = (Button) findViewById(R.id.normal_anim);
        advance = (Button) findViewById(R.id.advance_anim);
        progress = (Button) findViewById(R.id.progressbar_anim);
        normal.setOnClickListener(this);
        advance.setOnClickListener(this);
        progress.setOnClickListener(this);
        pile_layout = findViewById(R.id.pile_layout);
        List<String> urls=new ArrayList<>();
        urls.add("https://t1.picb.cc/uploads/2019/09/26/gRKb5s.jpg");
        urls.add("https://t1.picb.cc/uploads/2018/10/27/Jb5sHW.jpg");
        urls.add("https://t1.picb.cc/uploads/2020/01/18/kA9ZT7.jpg");
        urls.add("https://t1.picb.cc/uploads/2021/04/27/Zssfdg.md.jpg");
        urls.add("https://t1.picb.cc/uploads/2021/04/27/ZssIuX.md.jpg");
        pile_layout.setAvertImages(urls,4);
    }




    @Override
    public void onClick(View view) {

        switch (view.getId()){
//            case R.id.normal_anim:
//                intent = new Intent(MainActivity.this, TestActivity1.class);
//                intent.putExtra("mode", 1);
//                break;
            case R.id.normal_anim:
                intent = new Intent(MainActivity.this, AndroidStepActivity.class);
                break;
            case R.id.advance_anim:
                intent = new Intent(MainActivity.this, TestActivity2.class);
                intent.putExtra("mode", 2);
                break;
            case R.id.progressbar_anim:
                intent = new Intent(MainActivity.this, TestProgressbarActivity.class);
                break;
        }
        startActivity(intent);
    }
}
