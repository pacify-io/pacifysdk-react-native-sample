package com.pacifysdk_rn;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import java.util.Map;
import java.util.HashMap;
import com.masslight.lib.pacifysdk.sdk.PacifySdk;
import com.masslight.lib.pacifysdk.sdk.entity.PacifyEnvironment;
import com.masslight.lib.pacifysdk.sdk.entity.PacifySdkSettings;
import com.masslight.lib.pacifysdk.sdk.entity.PacifySupportInfo;
import com.masslight.lib.pacifysdk.sdk.entity.PacifyUserData;
import com.masslight.lib.pacifysdk.sdk.entity.TokensInfo;
import com.masslight.pacify.framework.core.manager.LanguageManager;
import com.masslight.pacify.framework.core.model.Color;
import com.masslight.pacify.framework.core.model.Coupon;
import com.masslight.pacify.framework.core.model.Currency;
import com.masslight.pacify.framework.core.model.PacifyAppearance;
import com.masslight.pacify.framework.core.model.Token;
import com.pacifysdk_rn.R;

public class Counter extends ReactContextBaseJavaModule implements PacifySdk.PacifyDelegate {
    private static ReactApplicationContext reactContext;

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

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

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
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

        final PacifyUserData pacifyUserData = new PacifyUserData(
                "First Name",
                "Last Name", // optional, used for payment only
                "anemail@domain.com"
        );

        final TokensInfo tokensInfo = new TokensInfo(
                new Token("8271740bb0ded5e1ff42258c794920e7"),
                new Token("valid_98772")
        );

        final PacifySupportInfo pacifySupportInfo = new PacifySupportInfo("support@company.com", "1234567890");

        final PacifyAppearance pacifyAppearance = new PacifyAppearance(
                Color.ofRgb(249, 249, 249),
                Color.ofRgb(253, 217, 123),
                Color.ofRgb(123, 12, 3),
                Color.ofRgb(143, 98, 146),
                Color.ofRgb(255, 255, 255),
                Color.ofRgb(76, 0, 82),
                reactContext.getDrawable(R.drawable.dummy_user)
//                Color.ofHexString("#F9F9F9"),
//                Color.ofHexString("#FDD97B"),
//                Color.ofHexString("#CC000000"),
//                Color.ofHexString("#8F6292"),
//                Color.ofHexString("#FFFFFF"),
//                Color.ofHexString("#4C0052"),
//                Resources.getSystem().getDrawable(R.drawable.dummy_user)
        );
        final PacifySdkSettings pacifySettings = new PacifySdkSettings(
                pacifyAppearance,
                PacifyEnvironment.Testing,
                pacifySupportInfo,
                "SampleApp",
                LanguageManager.SDKSupportedLanguage.English,  // pass in appropriate language with every launch.
                Currency.USD // pass in appropriate currency with every launch.
        );

        Coupon coupon = Coupon.create("your coupon");
        PacifySdk.call(
                reactContext,
                tokensInfo,
                coupon,
                pacifyUserData,
                pacifySettings,
                this
        );

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable exception) {

    }
}
