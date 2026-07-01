package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$3 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;

    public ActivityHandler$3(ActivityHandler activityHandler) {
        this.this$0 = activityHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$600(this.this$0);
        ActivityHandler.access$700(this.this$0);
        ActivityHandler.access$400(this.this$0).verbose("Subsession end", new Object[0]);
        ActivityHandler.access$800(this.this$0);
    }
}
