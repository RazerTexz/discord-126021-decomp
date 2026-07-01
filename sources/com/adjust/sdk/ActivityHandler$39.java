package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$39 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ SessionResponseData val$sessionResponseData;

    public ActivityHandler$39(ActivityHandler activityHandler, SessionResponseData sessionResponseData) {
        this.this$0 = activityHandler;
        this.val$sessionResponseData = sessionResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ActivityHandler.access$3000(this.this$0) == null || ActivityHandler.access$3000(this.this$0).onSessionTrackingFailedListener == null) {
            return;
        }
        ActivityHandler.access$3000(this.this$0).onSessionTrackingFailedListener.onFinishedSessionTrackingFailed(this.val$sessionResponseData.getFailureResponseData());
    }
}
