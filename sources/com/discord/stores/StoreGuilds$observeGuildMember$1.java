package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeGuildMember$1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends GuildMember>>, GuildMember> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;

    public StoreGuilds$observeGuildMember$1(long j, long j2) {
        this.$guildId = j;
        this.$userId = j2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
        return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildMember call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
        Map<Long, GuildMember> map2 = map.get(Long.valueOf(this.$guildId));
        if (map2 != null) {
            return map2.get(Long.valueOf(this.$userId));
        }
        return null;
    }
}
