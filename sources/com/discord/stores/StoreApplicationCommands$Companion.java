package com.discord.stores;

import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$Companion {
    private StoreApplicationCommands$Companion() {
    }

    public final ObservationDeck$UpdateSource getAutocompleteResultsUpdate() {
        return StoreApplicationCommands.access$getAutocompleteResultsUpdate$cp();
    }

    public final ObservationDeck$UpdateSource getDiscoverCommandsUpdate() {
        return StoreApplicationCommands.access$getDiscoverCommandsUpdate$cp();
    }

    public final ObservationDeck$UpdateSource getFrecencyCommandsUpdate() {
        return StoreApplicationCommands.access$getFrecencyCommandsUpdate$cp();
    }

    public final ObservationDeck$UpdateSource getGuildApplicationsUpdate() {
        return StoreApplicationCommands.access$getGuildApplicationsUpdate$cp();
    }

    public final ObservationDeck$UpdateSource getQueryCommandsUpdate() {
        return StoreApplicationCommands.access$getQueryCommandsUpdate$cp();
    }

    public /* synthetic */ StoreApplicationCommands$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
