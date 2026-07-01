package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$deferredInit$1$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ StoreStream$deferredInit$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$deferredInit$1$1(StoreStream$deferredInit$1 storeStream$deferredInit$1) {
        super(1);
        this.this$0 = storeStream$deferredInit$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        StoreStream.access$handlePreLogout(this.this$0.this$0);
    }
}
