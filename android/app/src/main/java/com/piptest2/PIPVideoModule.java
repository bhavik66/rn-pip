package com.piptest2;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class PIPVideoModule extends ReactContextBaseJavaModule {

    public PIPVideoModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "PIPVideo";
    }

    @ReactMethod
    public void openPIP() {

        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, PIPVideo.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra("keep", true);
//        intent.putExtra("videoUrl", videoUrl);
//        intent.putExtra("currentTime", currentTime);
        context.startActivity(intent);

//        Intent intent1 = new Intent(context, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra("keep", true);
//        intent.putExtra("videoUrl", videoUrl);
//        intent.putExtra("currentTime", currentTime);
//        context.startActivity(intent);


//        if (enable) {
//            intent.putExtra("keep", true);
//            context.startActivity(intent);
//        }
//        else
//        {
//            intent.putExtra("keep", false);
//            context.startActivity(intent);
//        }
    }
}
