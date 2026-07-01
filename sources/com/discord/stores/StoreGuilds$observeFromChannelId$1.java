package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeFromChannelId$1<T, R> implements b<Channel, Observable<? extends Guild>> {
    public final /* synthetic */ StoreGuilds this$0;

    public StoreGuilds$observeFromChannelId$1(StoreGuilds storeGuilds) {
        this.this$0 = storeGuilds;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Guild> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Guild> call2(Channel channel) {
        return channel != null ? this.this$0.observeGuild(channel.getGuildId()) : new k(null);
    }
}
