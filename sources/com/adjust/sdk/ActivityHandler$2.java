package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$2 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;

    public ActivityHandler$2(ActivityHandler activityHandler) {
        this.this$0 = activityHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$100(this.this$0);
        ActivityHandler.access$200(this.this$0);
        ActivityHandler.access$300(this.this$0);
        ActivityHandler.access$400(this.this$0).verbose("Subsession start", new Object[0]);
        ActivityHandler.access$500(this.this$0);
    }
}
