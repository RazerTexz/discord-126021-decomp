package com.discord.utilities.networking;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Backoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Backoff$fail$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Function0 $callback;
    public final /* synthetic */ Backoff this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Backoff$fail$1(Backoff backoff, Function0 function0) {
        super(0);
        this.this$0 = backoff;
        this.$callback = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Backoff.access$executeFailureCallback(this.this$0, this.$callback);
    }
}
