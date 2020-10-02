package com.pacifysdk_rn;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeArray;
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

public class PacifySDKActivity extends ReactActivity implements PacifySdk.PacifyDelegate {

    private static final String TAG = PacifySDKActivity.class.getCanonicalName();

    /**
     * Just demonstrates use of {@link PacifySdk#isRunning()} method :-)
     */
    @Override
    protected void onStart() {
        super.onStart();
        if (PacifySdk.isRunning()) {
            Toast.makeText(this, "PacifySdk is still running", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "PacifySdk is not running", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacify_sdk_activity);
    }


    public void startPacifySDK(View view) {
        Log.i(TAG, "Start PacifySDK");
        Toast.makeText(PacifySDKActivity.this, "Start PacifySDK", Toast.LENGTH_SHORT).show();
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
                Color.ofResId(this, R.color.background_color),
                Color.ofResId(this, R.color.toolbar_tint_color),
                Color.ofResId(this, R.color.toolbar_title_color),
                Color.ofResId(this, R.color.button_background_color),
                Color.ofResId(this, R.color.button_title_color),
                Color.ofResId(this, R.color.text_color),
                ContextCompat.getDrawable(this, R.drawable.dummy_user)
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
            PacifySDKActivity.this,
            tokensInfo,
            coupon,
            pacifyUserData,
            pacifySettings,
            this
        );

    }

    @Override
    public void onComplete() {
        Log.i(TAG, "Library call execution successfully completed.");
    }

    @Override
    public void onError(Throwable exception) {
        Log.e(TAG, "Library call execution failed with error: ", exception);
        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
