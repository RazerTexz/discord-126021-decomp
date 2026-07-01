package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class SdkClickHandler$1 implements Runnable {
    public final /* synthetic */ SdkClickHandler this$0;
    public final /* synthetic */ ActivityPackage val$sdkClick;

    public SdkClickHandler$1(SdkClickHandler sdkClickHandler, ActivityPackage activityPackage) {
        this.this$0 = sdkClickHandler;
        this.val$sdkClick = activityPackage;
    }

    @Override // java.lang.Runnable
    public void run() {
        SdkClickHandler.access$000(this.this$0).add(this.val$sdkClick);
        SdkClickHandler.access$100(this.this$0).debug("Added sdk_click %d", Integer.valueOf(SdkClickHandler.access$000(this.this$0).size()));
        SdkClickHandler.access$100(this.this$0).verbose("%s", this.val$sdkClick.getExtendedString());
        SdkClickHandler.access$200(this.this$0);
    }
}
