package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$26 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ AdjustPlayStoreSubscription val$subscription;

    public ActivityHandler$26(ActivityHandler activityHandler, AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        this.this$0 = activityHandler;
        this.val$subscription = adjustPlayStoreSubscription;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$2600(this.this$0, this.val$subscription);
    }
}
