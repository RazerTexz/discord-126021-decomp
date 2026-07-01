package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class AttributionHandler$3 implements Runnable {
    public final /* synthetic */ AttributionHandler this$0;
    public final /* synthetic */ SessionResponseData val$sessionResponseData;

    public AttributionHandler$3(AttributionHandler attributionHandler, SessionResponseData sessionResponseData) {
        this.this$0 = attributionHandler;
        this.val$sessionResponseData = sessionResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.access$300(this.this$0).get();
        if (iActivityHandler == null) {
            return;
        }
        AttributionHandler.access$400(this.this$0, iActivityHandler, this.val$sessionResponseData);
    }
}
