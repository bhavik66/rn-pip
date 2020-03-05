package com.piptest2;

import android.app.PictureInPictureParams;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Rational;
import android.view.Display;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class PIPVideo extends ReactActivity implements OnPreparedListener {

    private VideoView videoView;
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pip_video);
    }

    @Override
    protected void onStart() {
        super.onStart();
        enterPIP();
        setupVideoView();
        Log.e("PIPVIDEO:", "START");
//        moveTaskToBack (true);
    }


    private void setupVideoView() {
        // Make sure to use the correct VideoView import
        videoView = (VideoView) findViewById(R.id.video_view);
        videoView.setOnPreparedListener(this);

//        String videoUrl = getIntent().getStringExtra("videoUrl");
//        long currentTime = (long) Double.parseDouble(getIntent().getStringExtra("currentTime"));

        //For now we just picked an arbitrary item to play
        videoView.setVideoURI(Uri.parse("https://m.simsim.in/data/videos/KW7404_0103.mp4"));
        videoView.setControls(null);
//        videoView.seekTo(currentTime * 1000);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void enterPIP() {
        Display d = getWindowManager().getDefaultDisplay();
        Point p = new Point();
        d.getSize(p);
        int width = p.x;
        int height = p.y;
        Rational ratio = new Rational(width, height);
        PictureInPictureParams.Builder pip_Builder = new PictureInPictureParams.Builder();
        pip_Builder.setAspectRatio(ratio).build();
        enterPictureInPictureMode(pip_Builder.build());
    }

    @Override
    public void onPrepared() {
        videoView.start();
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        boolean keep = intent.getExtras().getBoolean("keep");
        if (!keep) {
            this.finish();
        }
    }

//    @Override
//    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
//        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
//        Log.e("PIPVIDEO:", "CHANGE MODE " + isInPictureInPictureMode);
//        isPip = isInPictureInPictureMode;
//    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("PIPVIDEO:", "STOP");
        count = 0;
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("PIPVIDEO", "RESUME");
//        count++;
//        if (count % 2 == 0) {
//            WritableMap map = Arguments.createMap();
//            try {
//                getReactInstanceManager().getCurrentReactContext()
//                        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
//                        .emit("customEventName", map);
//            } catch (Exception e) {
//                Log.e("ReactNative", "Caught Exception: " + e.getMessage());
//            }
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e("PIPVIDEO", "BACK");
    }
}
