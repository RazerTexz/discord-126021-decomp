package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$35 implements InstallReferrerReadListener {
    public final /* synthetic */ ActivityHandler this$0;

    public ActivityHandler$35(ActivityHandler activityHandler) {
        this.this$0 = activityHandler;
    }

    @Override // com.adjust.sdk.InstallReferrerReadListener
    public void onInstallReferrerRead(String str, long j, long j2) {
        this.this$0.sendInstallReferrer(str, j, j2, Constants.REFERRER_API_HUAWEI);
    }
}
