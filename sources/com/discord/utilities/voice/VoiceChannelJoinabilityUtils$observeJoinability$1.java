package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: VoiceChannelJoinabilityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceChannelJoinabilityUtils$observeJoinability$1<T, R> implements b<Channel, Observable<? extends VoiceChannelJoinability>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;
    public final /* synthetic */ StoreStageInstances $stageInstancesStore;
    public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;
    public final /* synthetic */ StoreVoiceStates $voiceStatesStore;

    public VoiceChannelJoinabilityUtils$observeJoinability$1(StoreVoiceStates storeVoiceStates, long j, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageInstances storeStageInstances) {
        this.$voiceStatesStore = storeVoiceStates;
        this.$channelId = j;
        this.$permissionsStore = storePermissions;
        this.$guildsStore = storeGuilds;
        this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.$stageInstancesStore = storeStageInstances;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends VoiceChannelJoinability> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends VoiceChannelJoinability> call2(Channel channel) {
        return channel == null ? new k(VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST) : Observable.f(this.$voiceStatesStore.observe(channel.getGuildId(), this.$channelId), this.$permissionsStore.observePermissionsForChannel(this.$channelId), this.$guildsStore.observeGuild(channel.getGuildId()), GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null), this.$voiceChannelSelectedStore.observeSelectedVoiceChannelId(), this.$stageInstancesStore.observeStageInstanceForChannel(this.$channelId), new VoiceChannelJoinabilityUtils$observeJoinability$1$1(channel));
    }
}
