package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$16 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ String val$key;
    public final /* synthetic */ String val$value;

    public ActivityHandler$16(ActivityHandler activityHandler, String str, String str2) {
        this.this$0 = activityHandler;
        this.val$key = str;
        this.val$value = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.addSessionCallbackParameterI(this.val$key, this.val$value);
    }
}
