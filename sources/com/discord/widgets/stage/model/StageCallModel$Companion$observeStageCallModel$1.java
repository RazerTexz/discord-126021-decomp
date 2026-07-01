package com.discord.widgets.stage.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallModel$Companion$observeStageCallModel$1<T, R> implements b<Channel, Observable<? extends StageCallModel>> {
    public final /* synthetic */ long $channelId;

    public StageCallModel$Companion$observeStageCallModel$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends StageCallModel> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StageCallModel> call2(Channel channel) {
        if (channel == null) {
            return new k(null);
        }
        if (!ChannelUtils.D(channel)) {
            return new k(null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.e(ObservableExtensionsKt.leadingEdgeThrottle(storeStream$Companion.getVoiceParticipants().get(channel.getId()), 250L, TimeUnit.MILLISECONDS), storeStream$Companion.getGuilds().observeComputed(channel.getGuildId()), storeStream$Companion.getGuilds().observeRoles(channel.getGuildId()), storeStream$Companion.getGuilds().observeGuild(channel.getGuildId()), storeStream$Companion.getUserRelationships().observeForType(2), storeStream$Companion.getStageInstances().observeStageInstanceForChannel(this.$channelId), storeStream$Companion.getLurking().isLurkingObs(channel.getGuildId()), new StageCallModel$Companion$observeStageCallModel$1$1(channel));
    }
}
