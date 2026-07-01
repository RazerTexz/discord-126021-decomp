package com.adjust.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class AdjustInstance$7 implements Runnable {
    public final /* synthetic */ AdjustInstance this$0;
    public final /* synthetic */ long val$clickTime;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ String val$rawReferrer;

    public AdjustInstance$7(AdjustInstance adjustInstance, Context context, String str, long j) {
        this.this$0 = adjustInstance;
        this.val$context = context;
        this.val$rawReferrer = str;
        this.val$clickTime = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        new SharedPreferencesManager(this.val$context).saveRawReferrer(this.val$rawReferrer, this.val$clickTime);
    }
}
