package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$5 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ boolean val$enabled;

    public ActivityHandler$5(ActivityHandler activityHandler, boolean z2) {
        this.this$0 = activityHandler;
        this.val$enabled = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$1100(this.this$0, this.val$enabled);
    }
}
