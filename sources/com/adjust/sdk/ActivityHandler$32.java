package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$32 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;

    public ActivityHandler$32(ActivityHandler activityHandler) {
        this.this$0 = activityHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.backgroundTimerFired();
    }
}
