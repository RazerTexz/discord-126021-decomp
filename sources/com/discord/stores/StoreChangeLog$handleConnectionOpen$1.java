package com.discord.stores;

import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StoreChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.stores.StoreChangeLog$handleConnectionOpen$1", f = "StoreChangeLog.kt", l = {}, m = "invokeSuspend")
public final class StoreChangeLog$handleConnectionOpen$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ StoreChangeLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChangeLog$handleConnectionOpen$1(StoreChangeLog storeChangeLog, Continuation continuation) {
        super(2, continuation);
        this.this$0 = storeChangeLog;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new StoreChangeLog$handleConnectionOpen$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoreChangeLog$handleConnectionOpen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        StoreChangeLog.access$getDispatcher$p(this.this$0).schedule(new StoreChangeLog$handleConnectionOpen$1$1(this));
        return Unit.a;
    }
}
