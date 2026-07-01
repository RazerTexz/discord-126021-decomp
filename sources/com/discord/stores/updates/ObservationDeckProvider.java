package com.discord.stores.updates;

import d0.g;
import kotlin.Lazy;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeckProvider {
    public static final ObservationDeckProvider INSTANCE = new ObservationDeckProvider();

    /* JADX INFO: renamed from: INSTANCE$delegate, reason: from kotlin metadata */
    private static final Lazy INSTANCE = g.lazy(ObservationDeckProvider$INSTANCE$2.INSTANCE);

    private ObservationDeckProvider() {
    }

    public static final ObservationDeck get() {
        return INSTANCE.getINSTANCE();
    }

    private final ObservationDeck getINSTANCE() {
        return (ObservationDeck) INSTANCE.getValue();
    }
}
