package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreConnectivity$DelayedState;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.streams.StreamContextService;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetGlobalStatusIndicatorViewModel$StoreState>> {
    public final /* synthetic */ ObservationDeck $observationDeck;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreConnectivity $storeConnectivity;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreRtcConnection $storeRtcConnection;
    public final /* synthetic */ StoreStageChannels $storeStageChannels;
    public final /* synthetic */ StoreStageInstances $storeStageInstances;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreVoiceParticipants $storeVoiceParticipants;
    public final /* synthetic */ StreamContextService $streamContextService;

    public WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1(StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StreamContextService streamContextService, StoreStageChannels storeStageChannels, ObservationDeck observationDeck, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances) {
        this.$storeConnectivity = storeConnectivity;
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeRtcConnection = storeRtcConnection;
        this.$storeGuilds = storeGuilds;
        this.$storeVoiceParticipants = storeVoiceParticipants;
        this.$streamContextService = streamContextService;
        this.$storeStageChannels = storeStageChannels;
        this.$observationDeck = observationDeck;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storeStageInstances = storeStageInstances;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGlobalStatusIndicatorViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGlobalStatusIndicatorViewModel$StoreState> call2(Channel channel) {
        Object widgetGlobalStatusIndicatorViewModel$sam$rx_functions_Func1$0;
        if (channel != null) {
            k kVar = new k(channel);
            m.checkNotNullExpressionValue(kVar, "Observable\n                        .just(channel)");
            return ObservableCombineLatestOverloadsKt.combineLatest(kVar, this.$storeChannelsSelected.observeSelectedChannel(), this.$storeRtcConnection.getConnectionState(), this.$storeRtcConnection.getQuality(), this.$storeGuilds.observeGuild(channel.getGuildId()), this.$storeVoiceParticipants.get(channel.getId()), this.$streamContextService.getForActiveStream(), this.$storeStageChannels.observeMyRequestToSpeakState(channel.getId()), ObservationDeck.connectRx$default(this.$observationDeck, new ObservationDeck$UpdateSource[]{this.$storeUserRelationships, this.$storeStageChannels}, false, null, null, new WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$2(this, channel), 14, null), this.$storeStageInstances.observeStageInstanceForChannel(channel.getId()), WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$3.INSTANCE);
        }
        Observable<StoreConnectivity$DelayedState> observableObserveState = this.$storeConnectivity.observeState();
        WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1 widgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1 = WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1.INSTANCE;
        if (widgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1 != null) {
            widgetGlobalStatusIndicatorViewModel$sam$rx_functions_Func1$0 = widgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1;
            widgetGlobalStatusIndicatorViewModel$sam$rx_functions_Func1$0 = new WidgetGlobalStatusIndicatorViewModel$sam$rx_functions_Func1$0(widgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1);
        }
        widgetGlobalStatusIndicatorViewModel$sam$rx_functions_Func1$0 = widgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1;
        return observableObserveState.G((b) widgetGlobalStatusIndicatorViewModel$sam$rx_functions_Func1$0);
    }
}
