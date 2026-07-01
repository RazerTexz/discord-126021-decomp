package com.adjust.sdk;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$41 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ Uri val$deeplink;
    public final /* synthetic */ Intent val$deeplinkIntent;

    public ActivityHandler$41(ActivityHandler activityHandler, Uri uri, Intent intent) {
        this.this$0 = activityHandler;
        this.val$deeplink = uri;
        this.val$deeplinkIntent = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ActivityHandler.access$3000(this.this$0) == null) {
            return;
        }
        if (ActivityHandler.access$3000(this.this$0).onDeeplinkResponseListener != null ? ActivityHandler.access$3000(this.this$0).onDeeplinkResponseListener.launchReceivedDeeplink(this.val$deeplink) : true) {
            ActivityHandler.access$3200(this.this$0, this.val$deeplinkIntent, this.val$deeplink);
        }
    }
}
