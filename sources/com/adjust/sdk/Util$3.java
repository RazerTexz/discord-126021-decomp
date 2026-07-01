package com.adjust.sdk;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class Util$3 implements Callable<Boolean> {
    public final /* synthetic */ Object val$advertisingInfoObject;
    public final /* synthetic */ Context val$context;

    public Util$3(Context context, Object obj) {
        this.val$context = context;
        this.val$advertisingInfoObject = obj;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Boolean call() throws Exception {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        return Reflection.isPlayTrackingEnabled(this.val$context, this.val$advertisingInfoObject);
    }
}
