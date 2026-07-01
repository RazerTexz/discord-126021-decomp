package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Adjust {
    private static AdjustInstance defaultInstance;

    private Adjust() {
    }

    public static void addSessionCallbackParameter(String str, String str2) {
        getDefaultInstance().addSessionCallbackParameter(str, str2);
    }

    public static void addSessionPartnerParameter(String str, String str2) {
        getDefaultInstance().addSessionPartnerParameter(str, str2);
    }

    @Deprecated
    public static void appWillOpenUrl(Uri uri) {
        getDefaultInstance().appWillOpenUrl(uri);
    }

    public static void disableThirdPartySharing(Context context) {
        getDefaultInstance().disableThirdPartySharing(context);
    }

    public static void gdprForgetMe(Context context) {
        getDefaultInstance().gdprForgetMe(context);
    }

    public static String getAdid() {
        return getDefaultInstance().getAdid();
    }

    public static String getAmazonAdId(Context context) {
        return Util.getFireAdvertisingId(context.getContentResolver());
    }

    public static AdjustAttribution getAttribution() {
        return getDefaultInstance().getAttribution();
    }

    public static synchronized AdjustInstance getDefaultInstance() {
        if (defaultInstance == null) {
            defaultInstance = new AdjustInstance();
        }
        return defaultInstance;
    }

    public static void getGoogleAdId(Context context, OnDeviceIdsRead onDeviceIdsRead) {
        Util.getGoogleAdId(context, onDeviceIdsRead);
    }

    public static String getSdkVersion() {
        return getDefaultInstance().getSdkVersion();
    }

    public static boolean isEnabled() {
        return getDefaultInstance().isEnabled();
    }

    public static void onCreate(AdjustConfig adjustConfig) {
        getDefaultInstance().onCreate(adjustConfig);
    }

    public static void onPause() {
        getDefaultInstance().onPause();
    }

    public static void onResume() {
        getDefaultInstance().onResume();
    }

    public static void removeSessionCallbackParameter(String str) {
        getDefaultInstance().removeSessionCallbackParameter(str);
    }

    public static void removeSessionPartnerParameter(String str) {
        getDefaultInstance().removeSessionPartnerParameter(str);
    }

    public static void resetSessionCallbackParameters() {
        getDefaultInstance().resetSessionCallbackParameters();
    }

    public static void resetSessionPartnerParameters() {
        getDefaultInstance().resetSessionPartnerParameters();
    }

    public static void sendFirstPackages() {
        getDefaultInstance().sendFirstPackages();
    }

    public static void setEnabled(boolean z2) {
        getDefaultInstance().setEnabled(z2);
    }

    public static void setOfflineMode(boolean z2) {
        getDefaultInstance().setOfflineMode(z2);
    }

    public static void setPushToken(String str) {
        getDefaultInstance().setPushToken(str);
    }

    public static void setReferrer(String str, Context context) {
        getDefaultInstance().sendReferrer(str, context);
    }

    public static void setTestOptions(AdjustTestOptions adjustTestOptions) {
        Boolean bool = adjustTestOptions.teardown;
        if (bool != null && bool.booleanValue()) {
            AdjustInstance adjustInstance = defaultInstance;
            if (adjustInstance != null) {
                adjustInstance.teardown();
            }
            defaultInstance = null;
            AdjustFactory.teardown(adjustTestOptions.context);
        }
        getDefaultInstance().setTestOptions(adjustTestOptions);
    }

    public static void trackAdRevenue(String str, JSONObject jSONObject) {
        getDefaultInstance().trackAdRevenue(str, jSONObject);
    }

    public static void trackEvent(AdjustEvent adjustEvent) {
        getDefaultInstance().trackEvent(adjustEvent);
    }

    public static void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        getDefaultInstance().trackPlayStoreSubscription(adjustPlayStoreSubscription);
    }

    public static void appWillOpenUrl(Uri uri, Context context) {
        getDefaultInstance().appWillOpenUrl(uri, context);
    }

    public static void setPushToken(String str, Context context) {
        getDefaultInstance().setPushToken(str, context);
    }
}
