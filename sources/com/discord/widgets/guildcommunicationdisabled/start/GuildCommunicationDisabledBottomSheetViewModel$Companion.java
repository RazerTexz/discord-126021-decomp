package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.stores.StoreGuilds;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCommunicationDisabledBottomSheetViewModel$Companion {
    private GuildCommunicationDisabledBottomSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(GuildCommunicationDisabledBottomSheetViewModel$Companion guildCommunicationDisabledBottomSheetViewModel$Companion, long j, long j2, ObservationDeck observationDeck, StoreGuilds storeGuilds) {
        return guildCommunicationDisabledBottomSheetViewModel$Companion.observeStores(j, j2, observationDeck, storeGuilds);
    }

    private final Observable<GuildCommunicationDisabledBottomSheetViewModel$StoreState> observeStores(long userId, long guildId, ObservationDeck observationDeck, StoreGuilds guildStore) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{guildStore}, false, null, null, new GuildCommunicationDisabledBottomSheetViewModel$Companion$observeStores$1(guildStore, guildId, userId), 14, null);
    }

    public /* synthetic */ GuildCommunicationDisabledBottomSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
