package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityHandler {
    void addSessionCallbackParameter(String str, String str2);

    void addSessionPartnerParameter(String str, String str2);

    void disableThirdPartySharing();

    void finishedTrackingActivity(ResponseData responseData);

    void gdprForgetMe();

    ActivityState getActivityState();

    String getAdid();

    AdjustConfig getAdjustConfig();

    AdjustAttribution getAttribution();

    String getBasePath();

    Context getContext();

    DeviceInfo getDeviceInfo();

    String getGdprPath();

    SessionParameters getSessionParameters();

    String getSubscriptionPath();

    void gotOptOutResponse();

    void init(AdjustConfig adjustConfig);

    boolean isEnabled();

    void launchAttributionResponseTasks(AttributionResponseData attributionResponseData);

    void launchEventResponseTasks(EventResponseData eventResponseData);

    void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData);

    void launchSessionResponseTasks(SessionResponseData sessionResponseData);

    void onPause();

    void onResume();

    void readOpenUrl(Uri uri, long j);

    void removeSessionCallbackParameter(String str);

    void removeSessionPartnerParameter(String str);

    void resetSessionCallbackParameters();

    void resetSessionPartnerParameters();

    void sendFirstPackages();

    void sendInstallReferrer(String str, long j, long j2, String str2);

    void sendReftagReferrer();

    void setAskingAttribution(boolean z2);

    void setEnabled(boolean z2);

    void setOfflineMode(boolean z2);

    void setPushToken(String str, boolean z2);

    void teardown();

    void trackAdRevenue(String str, JSONObject jSONObject);

    void trackEvent(AdjustEvent adjustEvent);

    void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription);

    boolean updateAttributionI(AdjustAttribution adjustAttribution);
}
