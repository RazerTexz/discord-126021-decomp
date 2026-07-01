package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$call$2$2 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ StoreCalls$call$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreCalls$call$2$2(StoreCalls$call$2 storeCalls$call$2) {
        super(1);
        this.this$0 = storeCalls$call$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        StoreCalls$call$1 storeCalls$call$1 = this.this$0.$doCall$1;
        m.checkNotNullExpressionValue(bool, "isRingable");
        storeCalls$call$1.invoke(bool.booleanValue());
    }
}
