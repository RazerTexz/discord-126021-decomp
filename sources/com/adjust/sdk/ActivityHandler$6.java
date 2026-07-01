package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$6 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ boolean val$offline;

    public ActivityHandler$6(ActivityHandler activityHandler, boolean z2) {
        this.this$0 = activityHandler;
        this.val$offline = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$1200(this.this$0, this.val$offline);
    }
}
