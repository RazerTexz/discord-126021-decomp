package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$19 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ String val$key;

    public ActivityHandler$19(ActivityHandler activityHandler, String str) {
        this.this$0 = activityHandler;
        this.val$key = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.removeSessionPartnerParameterI(this.val$key);
    }
}
