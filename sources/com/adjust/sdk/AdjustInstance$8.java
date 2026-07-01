package com.adjust.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class AdjustInstance$8 implements Runnable {
    public final /* synthetic */ AdjustInstance this$0;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ String val$pushToken;

    public AdjustInstance$8(AdjustInstance adjustInstance, Context context, String str) {
        this.this$0 = adjustInstance;
        this.val$context = context;
        this.val$pushToken = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        new SharedPreferencesManager(this.val$context).savePushToken(this.val$pushToken);
    }
}
