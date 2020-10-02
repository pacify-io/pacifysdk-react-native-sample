package com.pacifysdk_rn;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.masslight.lib.pacifysdk.sdk.PacifySdk;

public class Counter extends ReactContextBaseJavaModule implements PacifySdk.PacifyDelegate {
    private static ReactApplicationContext reactContext;

    private int count = -1;

    Counter(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "Counter";
    }


    @ReactMethod
    public void hello() {

    }

    @ReactMethod
    public void increment(Callback cb) {
        count = count + 1;
        cb.invoke(count);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @ReactMethod
    public void callPacify() {
        Activity activity = getCurrentActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, PacifySDKActivity.class);
            activity.startActivity(intent);
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable exception) {

    }
}
