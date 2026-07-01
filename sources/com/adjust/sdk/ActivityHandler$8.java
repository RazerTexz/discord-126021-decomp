package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$8 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ boolean val$askingAttribution;

    public ActivityHandler$8(ActivityHandler activityHandler, boolean z2) {
        this.this$0 = activityHandler;
        this.val$askingAttribution = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$1400(this.this$0, this.val$askingAttribution);
    }
}
