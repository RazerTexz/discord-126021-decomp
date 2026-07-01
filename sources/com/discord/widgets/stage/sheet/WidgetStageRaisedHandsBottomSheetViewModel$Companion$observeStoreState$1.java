package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.time.Clock;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel$StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Clock $clock;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StoreStageChannels $stageChannels;
    public final /* synthetic */ StoreVoiceParticipants $voiceParticipants;

    public WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1(StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, long j, StoreStageChannels storeStageChannels, Clock clock) {
        this.$guildsStore = storeGuilds;
        this.$voiceParticipants = storeVoiceParticipants;
        this.$channelId = j;
        this.$stageChannels = storeStageChannels;
        this.$clock = clock;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel$StoreState> call2(Channel channel) {
        return Observable.h(this.$guildsStore.observeRoles(channel.getGuildId()), this.$guildsStore.observeComputed(channel.getGuildId()), this.$voiceParticipants.get(this.$channelId), this.$stageChannels.observeMyRoles(this.$channelId), new WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1(this, channel));
    }
}
