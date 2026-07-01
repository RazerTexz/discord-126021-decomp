package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$resendAllLocalMessages$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$resendAllLocalMessages$1(StoreMessages storeMessages) {
        super(0);
        this.this$0 = storeMessages;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMessages.access$getInitResendFinished$p(this.this$0).onNext(Boolean.TRUE);
    }
}
