package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$12 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ SdkClickResponseData val$sdkClickResponseData;

    public ActivityHandler$12(ActivityHandler activityHandler, SdkClickResponseData sdkClickResponseData) {
        this.this$0 = activityHandler;
        this.val$sdkClickResponseData = sdkClickResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$1800(this.this$0, this.val$sdkClickResponseData);
    }
}
