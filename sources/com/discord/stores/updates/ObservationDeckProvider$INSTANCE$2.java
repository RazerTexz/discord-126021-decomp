package com.discord.stores.updates;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeckProvider$INSTANCE$2 extends AbstractC12240o implements Function0<ObservationDeck> {
    public static final ObservationDeckProvider$INSTANCE$2 INSTANCE = new ObservationDeckProvider$INSTANCE$2();

    public ObservationDeckProvider$INSTANCE$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ObservationDeck invoke() {
        return new ObservationDeck(null, null, 3, null);
    }
}
