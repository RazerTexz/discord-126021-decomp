package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$14 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ AttributionResponseData val$attributionResponseData;

    public ActivityHandler$14(ActivityHandler activityHandler, AttributionResponseData attributionResponseData) {
        this.this$0 = activityHandler;
        this.val$attributionResponseData = attributionResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$2000(this.this$0, this.val$attributionResponseData);
    }
}
