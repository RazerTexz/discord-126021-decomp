package com.discord.stores.updates;

import kotlin.Lazy;
import p507d0.C12083g;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeckProvider {
    public static final ObservationDeckProvider INSTANCE = new ObservationDeckProvider();

    /* JADX INFO: renamed from: INSTANCE$delegate, reason: from kotlin metadata */
    private static final Lazy INSTANCE = C12083g.lazy(ObservationDeckProvider$INSTANCE$2.INSTANCE);

    private ObservationDeckProvider() {
    }

    public static final ObservationDeck get() {
        return INSTANCE.getINSTANCE();
    }

    private final ObservationDeck getINSTANCE() {
        return (ObservationDeck) INSTANCE.getValue();
    }
}
