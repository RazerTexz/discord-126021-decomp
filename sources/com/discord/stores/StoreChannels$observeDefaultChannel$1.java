package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observeDefaultChannel$1<T, R> implements b<Map<Long, ? extends Long>, Observable<? extends Channel>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels this$0;

    public StoreChannels$observeDefaultChannel$1(StoreChannels storeChannels, long j) {
        this.this$0 = storeChannels;
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Map<Long, ? extends Long> map) {
        return call2((Map<Long, Long>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Map<Long, Long> map) {
        return this.this$0.observeChannelsForGuild(this.$guildId, 0).G(new StoreChannels$observeDefaultChannel$1$1(map));
    }
}
