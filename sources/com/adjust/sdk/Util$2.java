package com.adjust.sdk;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class Util$2 implements Callable<String> {
    public final /* synthetic */ Object val$advertisingInfoObject;
    public final /* synthetic */ Context val$context;

    public Util$2(Context context, Object obj) {
        this.val$context = context;
        this.val$advertisingInfoObject = obj;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ String call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public String call2() {
        return Reflection.getPlayAdId(this.val$context, this.val$advertisingInfoObject);
    }
}
