package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$4 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ AdjustEvent val$event;

    public ActivityHandler$4(ActivityHandler activityHandler, AdjustEvent adjustEvent) {
        this.this$0 = activityHandler;
        this.val$event = adjustEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ActivityHandler.access$900(this.this$0).hasFirstSdkStartNotOcurred()) {
            ActivityHandler.access$400(this.this$0).warn("Event tracked before first activity resumed.\nIf it was triggered in the Application class, it might timestamp or even send an install long before the user opens the app.\nPlease check https://github.com/adjust/android_sdk#can-i-trigger-an-event-at-application-launch for more information.", new Object[0]);
            ActivityHandler.access$500(this.this$0);
        }
        ActivityHandler.access$1000(this.this$0, this.val$event);
    }
}
