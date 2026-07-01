package com.discord.stores;

import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$Companion {
    private StoreUser$Companion() {
    }

    public final ObservationDeck$UpdateSource getMeUpdate() {
        return StoreUser.access$getMeUpdate$cp();
    }

    public final ObservationDeck$UpdateSource getUsersUpdate() {
        return StoreUser.access$getUsersUpdate$cp();
    }

    public /* synthetic */ StoreUser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
