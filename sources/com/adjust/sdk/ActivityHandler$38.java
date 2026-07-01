package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$38 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ SessionResponseData val$sessionResponseData;

    public ActivityHandler$38(ActivityHandler activityHandler, SessionResponseData sessionResponseData) {
        this.this$0 = activityHandler;
        this.val$sessionResponseData = sessionResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ActivityHandler.access$3000(this.this$0) == null || ActivityHandler.access$3000(this.this$0).onSessionTrackingSucceededListener == null) {
            return;
        }
        ActivityHandler.access$3000(this.this$0).onSessionTrackingSucceededListener.onFinishedSessionTrackingSucceeded(this.val$sessionResponseData.getSuccessResponseData());
    }
}
