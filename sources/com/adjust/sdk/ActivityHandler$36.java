package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$36 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ EventResponseData val$eventResponseData;

    public ActivityHandler$36(ActivityHandler activityHandler, EventResponseData eventResponseData) {
        this.this$0 = activityHandler;
        this.val$eventResponseData = eventResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ActivityHandler.access$3000(this.this$0) == null || ActivityHandler.access$3000(this.this$0).onEventTrackingSucceededListener == null) {
            return;
        }
        ActivityHandler.access$3000(this.this$0).onEventTrackingSucceededListener.onFinishedEventTrackingSucceeded(this.val$eventResponseData.getSuccessResponseData());
    }
}
