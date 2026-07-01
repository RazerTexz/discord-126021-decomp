package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$22 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ boolean val$preSaved;
    public final /* synthetic */ String val$token;

    public ActivityHandler$22(ActivityHandler activityHandler, boolean z2, String str) {
        this.this$0 = activityHandler;
        this.val$preSaved = z2;
        this.val$token = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.val$preSaved) {
            new SharedPreferencesManager(this.this$0.getContext()).savePushToken(this.val$token);
        }
        if (ActivityHandler.access$900(this.this$0).hasFirstSdkStartNotOcurred()) {
            return;
        }
        ActivityHandler.access$2200(this.this$0, this.val$token);
    }
}
