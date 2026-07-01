package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class AttributionHandler$4 implements Runnable {
    public final /* synthetic */ AttributionHandler this$0;
    public final /* synthetic */ SdkClickResponseData val$sdkClickResponseData;

    public AttributionHandler$4(AttributionHandler attributionHandler, SdkClickResponseData sdkClickResponseData) {
        this.this$0 = attributionHandler;
        this.val$sdkClickResponseData = sdkClickResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.access$300(this.this$0).get();
        if (iActivityHandler == null) {
            return;
        }
        AttributionHandler.access$500(this.this$0, iActivityHandler, this.val$sdkClickResponseData);
    }
}
