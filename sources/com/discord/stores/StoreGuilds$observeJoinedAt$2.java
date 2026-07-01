package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.guildmember.GuildMemberUtilsKt;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeJoinedAt$2<T, R> implements b<Map<Long, ? extends Long>, Long> {
    public final /* synthetic */ long $guildId;

    public StoreGuilds$observeJoinedAt$2(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(Map<Long, ? extends Long> map) {
        return call2((Map<Long, Long>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Map<Long, Long> map) {
        return Long.valueOf(GuildMemberUtilsKt.getJoinedAtOrNow(map.get(Long.valueOf(this.$guildId))));
    }
}
