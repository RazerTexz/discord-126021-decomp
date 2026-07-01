package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$10 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ long val$installBeginTimestampSeconds;
    public final /* synthetic */ String val$installReferrer;
    public final /* synthetic */ String val$referrerApi;
    public final /* synthetic */ long val$referrerClickTimestampSeconds;

    public ActivityHandler$10(ActivityHandler activityHandler, String str, long j, long j2, String str2) {
        this.this$0 = activityHandler;
        this.val$installReferrer = str;
        this.val$referrerClickTimestampSeconds = j;
        this.val$installBeginTimestampSeconds = j2;
        this.val$referrerApi = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$1600(this.this$0, this.val$installReferrer, this.val$referrerClickTimestampSeconds, this.val$installBeginTimestampSeconds, this.val$referrerApi);
    }
}
