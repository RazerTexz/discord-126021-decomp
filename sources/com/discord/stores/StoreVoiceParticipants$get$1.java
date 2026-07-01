package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.t.h0;
import j0.k.b;
import j0.l.e.k;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$get$1<T, R> implements b<Channel, Observable<? extends Map<Long, ? extends StoreVoiceParticipants$VoiceUser>>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreVoiceParticipants this$0;

    public StoreVoiceParticipants$get$1(StoreVoiceParticipants storeVoiceParticipants, long j) {
        this.this$0 = storeVoiceParticipants;
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends StoreVoiceParticipants$VoiceUser>> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, StoreVoiceParticipants$VoiceUser>> call2(Channel channel) {
        if (channel == null) {
            return new k(h0.emptyMap());
        }
        long guildId = ChannelUtils.B(channel) ? 0L : channel.getGuildId();
        return this.this$0.getStream().getVoiceStates().observe(guildId, channel.getId()).Y(new StoreVoiceParticipants$get$1$1(this, channel, guildId));
    }
}
