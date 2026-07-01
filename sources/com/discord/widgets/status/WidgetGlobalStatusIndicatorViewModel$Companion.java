package com.discord.widgets.status;

import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.streams.StreamContextService;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel$Companion {
    private WidgetGlobalStatusIndicatorViewModel$Companion() {
    }

    private final Observable<WidgetGlobalStatusIndicatorViewModel$StoreState> observeStoreState(StreamContextService streamContextService, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StoreStageChannels storeStageChannels, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances, ObservationDeck observationDeck) {
        return storeVoiceChannelSelected.observeSelectedChannel().Y(new WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1(storeConnectivity, storeChannelsSelected, storeRtcConnection, storeGuilds, storeVoiceParticipants, streamContextService, storeStageChannels, observationDeck, storeUserRelationships, storeStageInstances));
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetGlobalStatusIndicatorViewModel$Companion widgetGlobalStatusIndicatorViewModel$Companion, StreamContextService streamContextService, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StoreStageChannels storeStageChannels, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances, ObservationDeck observationDeck, int i, Object obj) {
        return widgetGlobalStatusIndicatorViewModel$Companion.observeStoreState(streamContextService, storeVoiceChannelSelected, storeConnectivity, storeChannelsSelected, storeRtcConnection, storeGuilds, storeVoiceParticipants, storeStageChannels, storeUserRelationships, storeStageInstances, (i & 1024) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public /* synthetic */ WidgetGlobalStatusIndicatorViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
