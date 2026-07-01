package com.discord.stores;

import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$Companion {
    private StoreApplicationInteractions$Companion() {
    }

    public final ObservationDeck$UpdateSource getComponentStateUpdate() {
        return StoreApplicationInteractions.access$getComponentStateUpdate$cp();
    }

    public final ObservationDeck$UpdateSource getSentInteractionsUpdate() {
        return StoreApplicationInteractions.access$getSentInteractionsUpdate$cp();
    }

    public /* synthetic */ StoreApplicationInteractions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
