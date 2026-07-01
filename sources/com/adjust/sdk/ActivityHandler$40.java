package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$40 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;

    public ActivityHandler$40(ActivityHandler activityHandler) {
        this.this$0 = activityHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ActivityHandler.access$3000(this.this$0) == null || ActivityHandler.access$3000(this.this$0).onAttributionChangedListener == null) {
            return;
        }
        ActivityHandler.access$3000(this.this$0).onAttributionChangedListener.onAttributionChanged(ActivityHandler.access$3100(this.this$0));
    }
}
