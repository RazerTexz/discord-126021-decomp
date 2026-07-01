package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$17 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ String val$key;
    public final /* synthetic */ String val$value;

    public ActivityHandler$17(ActivityHandler activityHandler, String str, String str2) {
        this.this$0 = activityHandler;
        this.val$key = str;
        this.val$value = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.addSessionPartnerParameterI(this.val$key, this.val$value);
    }
}
