package com.discord.widgets.stage.start;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageViewModel$Companion$observeStores$1<T, R> implements b<Channel, Observable<? extends ModeratorStartStageViewModel$StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;
    public final /* synthetic */ StoreVoiceParticipants $voiceParticipantsStore;

    public ModeratorStartStageViewModel$Companion$observeStores$1(StoreVoiceParticipants storeVoiceParticipants, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, long j) {
        this.$voiceParticipantsStore = storeVoiceParticipants;
        this.$guildScheduledEventsStore = storeGuildScheduledEvents;
        this.$permissionsStore = storePermissions;
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ModeratorStartStageViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModeratorStartStageViewModel$StoreState> call2(Channel channel) {
        return Observable.i(ObservableExtensionsKt.leadingEdgeThrottle(this.$voiceParticipantsStore.get(channel.getId()), 250L, TimeUnit.MILLISECONDS), StoreGuildScheduledEvents.observeGuildScheduledEvents$default(this.$guildScheduledEventsStore, channel.getGuildId(), false, 2, null), this.$permissionsStore.observePermissionsForChannel(channel.getId()), new ModeratorStartStageViewModel$Companion$observeStores$1$1(this));
    }
}
