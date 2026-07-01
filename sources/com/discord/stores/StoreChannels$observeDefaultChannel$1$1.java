package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.f0.q;
import d0.t.u;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observeDefaultChannel$1$1<T, R> implements b<Map<Long, ? extends Channel>, Channel> {
    public final /* synthetic */ Map $guildChannelPermissions;

    public StoreChannels$observeDefaultChannel$1$1(Map map) {
        this.$guildChannelPermissions = map;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Channel call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Channel call2(Map<Long, Channel> map) {
        return (Channel) q.firstOrNull(q.sortedWith(q.filter(u.asSequence(map.values()), new StoreChannels$observeDefaultChannel$1$1$1(this)), ChannelUtils.h(Channel.Companion)));
    }
}
