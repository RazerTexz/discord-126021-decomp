package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class SdkClickHandler$4 implements Runnable {
    public final /* synthetic */ SdkClickHandler this$0;
    public final /* synthetic */ ActivityPackage val$sdkClickPackage;

    public SdkClickHandler$4(SdkClickHandler sdkClickHandler, ActivityPackage activityPackage) {
        this.this$0 = sdkClickHandler;
        this.val$sdkClickPackage = activityPackage;
    }

    @Override // java.lang.Runnable
    public void run() {
        SdkClickHandler.access$500(this.this$0, this.val$sdkClickPackage);
        SdkClickHandler.access$200(this.this$0);
    }
}
