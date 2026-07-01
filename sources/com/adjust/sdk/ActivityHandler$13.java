package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$13 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ SessionResponseData val$sessionResponseData;

    public ActivityHandler$13(ActivityHandler activityHandler, SessionResponseData sessionResponseData) {
        this.this$0 = activityHandler;
        this.val$sessionResponseData = sessionResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$1900(this.this$0, this.val$sessionResponseData);
    }
}
