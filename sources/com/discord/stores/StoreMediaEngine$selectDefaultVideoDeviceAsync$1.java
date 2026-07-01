package com.discord.stores;

import d0.w.i.a.d;
import d0.w.i.a.e;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.stores.StoreMediaEngine", f = "StoreMediaEngine.kt", l = {202}, m = "selectDefaultVideoDeviceAsync")
public final class StoreMediaEngine$selectDefaultVideoDeviceAsync$1 extends d {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StoreMediaEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$selectDefaultVideoDeviceAsync$1(StoreMediaEngine storeMediaEngine, Continuation continuation) {
        super(continuation);
        this.this$0 = storeMediaEngine;
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectDefaultVideoDeviceAsync(this);
    }
}
