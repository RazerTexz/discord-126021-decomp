package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class AttributionHandler$5 implements Runnable {
    public final /* synthetic */ AttributionHandler this$0;
    public final /* synthetic */ AttributionResponseData val$attributionResponseData;

    public AttributionHandler$5(AttributionHandler attributionHandler, AttributionResponseData attributionResponseData) {
        this.this$0 = attributionHandler;
        this.val$attributionResponseData = attributionResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.access$300(this.this$0).get();
        if (iActivityHandler == null) {
            return;
        }
        AttributionHandler.access$600(this.this$0, iActivityHandler, this.val$attributionResponseData);
    }
}
