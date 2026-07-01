package com.adjust.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class AdjustInstance$11 implements Runnable {
    public final /* synthetic */ AdjustInstance this$0;
    public final /* synthetic */ Context val$context;

    public AdjustInstance$11(AdjustInstance adjustInstance, Context context) {
        this.this$0 = adjustInstance;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        new SharedPreferencesManager(this.val$context).setSendingReferrersAsNotSent();
    }
}
