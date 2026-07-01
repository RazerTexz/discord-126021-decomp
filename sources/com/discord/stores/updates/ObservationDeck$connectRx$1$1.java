package com.discord.stores.updates;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Emitter;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck$connectRx$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Emitter $emitter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservationDeck$connectRx$1$1(Emitter emitter) {
        super(0);
        this.$emitter = emitter;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$emitter.onNext(Unit.a);
    }
}
