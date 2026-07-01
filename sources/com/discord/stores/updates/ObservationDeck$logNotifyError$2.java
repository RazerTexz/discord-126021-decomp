package com.discord.stores.updates;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck$logNotifyError$2 extends o implements Function1<ObservationDeck$Observer, CharSequence> {
    public static final ObservationDeck$logNotifyError$2 INSTANCE = new ObservationDeck$logNotifyError$2();

    public ObservationDeck$logNotifyError$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ObservationDeck$Observer observationDeck$Observer) {
        return invoke2(observationDeck$Observer);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ObservationDeck$Observer observationDeck$Observer) {
        m.checkNotNullParameter(observationDeck$Observer, "observer");
        return observationDeck$Observer.toDebugLogString();
    }
}
