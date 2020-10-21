package com.hasan.svga_loader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;

public class SVGAPlayerActivity extends AppCompatActivity {

    SVGAImageView mGiftAnimSIV;
    SVGAParser mSVGAParse;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_v_g_a_player);
        mSVGAParse = new SVGAParser(this);
        mGiftAnimSIV = findViewById(R.id.SVGAImageView);

        data = getIntent().getStringExtra("data");

        playGiftAnimation();

        mGiftAnimSIV.setCallback(new SVGACallback() {
            @Override
            public void onPause() {

            }

            @Override
            public void onFinished() {
                mGiftAnimSIV.setVisibility(View.GONE);
                Toast.makeText(SVGAPlayerActivity.this, "finish", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onRepeat() {

            }

            @Override
            public void onStep(int frame, double percentage) {

            }
        });


    }

    private void playGiftAnimation() {
        try {
            mSVGAParse.parse(new URL("https://apprise.website/hive-api/public/images/svga/" + data + ".svga"), new SVGAParser.ParseCompletion() {
                @Override
                public void onComplete(SVGAVideoEntity mSVGAVideoEntity) {
                    mGiftAnimSIV.setVisibility(View.VISIBLE);

                    SVGADynamicEntity dynamicEntity = new SVGADynamicEntity();
                    SVGADrawable drawable = new SVGADrawable(mSVGAVideoEntity, dynamicEntity);
                    mGiftAnimSIV.setImageDrawable(drawable);
                    mGiftAnimSIV.startAnimation();
                }

                @Override
                public void onError() {
                    Toast.makeText(SVGAPlayerActivity.this, "prompt_gift_parse_fail", Toast.LENGTH_SHORT).show();

                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}