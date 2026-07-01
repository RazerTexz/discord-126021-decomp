package com.adjust.sdk;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class Util$1 implements Callable<Object> {
    public final /* synthetic */ Context val$context;

    public Util$1(Context context) {
        this.val$context = context;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        try {
            return Reflection.getAdvertisingInfoObject(this.val$context);
        } catch (Exception unused) {
            return null;
        }
    }
}
