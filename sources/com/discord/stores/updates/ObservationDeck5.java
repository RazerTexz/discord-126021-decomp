package com.discord.stores.updates;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.stores.updates.ObservationDeckProvider$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck5 extends Lambda implements Function0<ObservationDeck> {
    public static final ObservationDeck5 INSTANCE = new ObservationDeck5();

    public ObservationDeck5() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ObservationDeck invoke() {
        return new ObservationDeck(null, null, 3, null);
    }
}
