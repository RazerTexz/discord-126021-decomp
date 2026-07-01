package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$11 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ EventResponseData val$eventResponseData;

    public ActivityHandler$11(ActivityHandler activityHandler, EventResponseData eventResponseData) {
        this.this$0 = activityHandler;
        this.val$eventResponseData = eventResponseData;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$1700(this.this$0, this.val$eventResponseData);
    }
}
