package com.adjust.sdk;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$7 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ long val$clickTime;
    public final /* synthetic */ Uri val$url;

    public ActivityHandler$7(ActivityHandler activityHandler, Uri uri, long j) {
        this.this$0 = activityHandler;
        this.val$url = uri;
        this.val$clickTime = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$1300(this.this$0, this.val$url, this.val$clickTime);
    }
}
