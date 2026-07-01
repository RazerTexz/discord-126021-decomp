package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DisableGuildCommunicationViewModel$Companion {
    private DisableGuildCommunicationViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(DisableGuildCommunicationViewModel$Companion disableGuildCommunicationViewModel$Companion, long j, long j2, ObservationDeck observationDeck, StoreUser storeUser, StoreGuilds storeGuilds) {
        return disableGuildCommunicationViewModel$Companion.observeStores(j, j2, observationDeck, storeUser, storeGuilds);
    }

    private final Observable<DisableGuildCommunicationViewModel$StoreState> observeStores(long userId, long guildId, ObservationDeck observationDeck, StoreUser userStore, StoreGuilds guildsStore) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{userStore, guildsStore}, false, null, null, new DisableGuildCommunicationViewModel$Companion$observeStores$1(userStore, userId, guildsStore, guildId), 14, null);
    }

    public /* synthetic */ DisableGuildCommunicationViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
