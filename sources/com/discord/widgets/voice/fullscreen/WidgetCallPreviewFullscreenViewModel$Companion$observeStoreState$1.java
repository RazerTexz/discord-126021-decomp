package com.discord.widgets.voice.fullscreen;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.model.CallModel;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetCallPreviewFullscreenViewModel$StoreState>> {
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreMentions $storeMentions;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreVoiceChannelSelected $storeVoiceChannelSelected;
    public final /* synthetic */ long $voiceChannelId;

    public WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1(StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreMentions storeMentions, long j, StoreVoiceChannelSelected storeVoiceChannelSelected) {
        this.$storeUser = storeUser;
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeMentions = storeMentions;
        this.$voiceChannelId = j;
        this.$storeVoiceChannelSelected = storeVoiceChannelSelected;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetCallPreviewFullscreenViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetCallPreviewFullscreenViewModel$StoreState> call2(Channel channel) {
        return Observable.e(StoreUser.observeMe$default(this.$storeUser, false, 1, null), this.$storeChannelsSelected.observeSelectedChannel(), TextInVoiceFeatureFlag.Companion.getINSTANCE().observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null), this.$storeMentions.observeTotalMentions(), this.$storeMentions.observeMentionCounts(), CallModel.Companion.get(this.$voiceChannelId), this.$storeVoiceChannelSelected.observeSelectedChannel(), new WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1$1(channel));
    }
}
