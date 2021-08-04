package com.example.meeriaddemo.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.meeriaddemo.R;
import com.example.meeriaddemo.animutils.AnimationsContainer;


/**
 * TITLE
 * Created by shixiaoming on 16/12/27.
 */

public class TestActivity2 extends AppCompatActivity {
    private ImageView imageView;
    private Button playBtn;
    private AnimationDrawable animationDrawable;
    private int mode;
    private boolean start = false;
    AnimationsContainer.FramesSequenceAnimation animation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mode = getIntent().getIntExtra("mode", 1);
        setContentView(R.layout.test_activity1);

        imageView = (ImageView) findViewById(R.id.imgview);
        playBtn = (Button) findViewById(R.id.play_btn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (animation == null)
                    animation = AnimationsContainer.getInstance(R.array.loading_audio1, 30).createProgressDialogAnim(imageView);

                if (!switchBtn()) {
                    animation.start();
                } else {
                    animation.stop();
                }
            }
        });
    }


    //控制开关
    private boolean switchBtn() {
        boolean returnV = start;
        start = !start;

        playBtn.setText(start == false ? "START" : "STOP");
        return returnV;
    }
}
