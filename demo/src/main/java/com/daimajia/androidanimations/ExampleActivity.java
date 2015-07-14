package com.daimajia.androidanimations;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class ExampleActivity extends Activity {

    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example);

        layout = findViewById(R.id.edit_area2);

        final TextView t = (TextView) findViewById(R.id.notice);
        t.setText("Please input your Email and Password");

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .playOn(findViewById(R.id.edit_area));

                t.setText("Wrong password!");
            }
        });

        final TextView t2 = (TextView) findViewById(R.id.notice2);
        t2.setText("Please input your Email and Password");

        findViewById(R.id.submit2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                YoYo.with(Techniques.Shake).playOn(findViewById(R.id.edit_area2));
//                findViewById(R.id.edit_area).setVisibility(View.GONE);
//                t2.setText("Wrong password!");

                float curTranslationX = layout.getTranslationX();
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(layout, "translationX", curTranslationX,0);
                objectAnimator.setDuration(1000);
                objectAnimator.start();
            }
        });


        findViewById(R.id.translate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                YoYo.with(Techniques.RollOut).playOn(findViewById(R.id.edit_area2));
//                findViewById(R.id.edit_area).setVisibility(View.VISIBLE);
                float curTranslationX = layout.getTranslationX();
                int left = layout.getLeft();
                int right = layout.getRight();
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(layout, "translationX", 500f, left-right);
                objectAnimator.setDuration(1000);
                objectAnimator.start();
            }
        });
    }
}
