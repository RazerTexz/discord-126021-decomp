package com.discord.widgets.hubs;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel$Companion {
    private WidgetHubDescriptionViewModel$Companion() {
    }

    public final Observable<HubDescriptionState> observeStores(long channelId, long guildId, ObservationDeck observationDeck, StoreChannels channelStore, StoreGuilds guildStore) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(channelStore, "channelStore");
        m.checkNotNullParameter(guildStore, "guildStore");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{channelStore, guildStore}, false, null, null, new WidgetHubDescriptionViewModel$Companion$observeStores$1(channelStore, channelId, guildStore, guildId), 14, null);
    }

    public /* synthetic */ WidgetHubDescriptionViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
