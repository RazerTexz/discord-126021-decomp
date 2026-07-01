package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeRoles$2<T, R> implements b<Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends GuildRole>> {
    public final /* synthetic */ long $guildId;

    public StoreGuilds$observeRoles$2(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends GuildRole> call(Map<Long, ? extends Map<Long, ? extends GuildRole>> map) {
        return call2((Map<Long, ? extends Map<Long, GuildRole>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, GuildRole> call2(Map<Long, ? extends Map<Long, GuildRole>> map) {
        Map<Long, GuildRole> map2 = map.get(Long.valueOf(this.$guildId));
        return map2 != null ? map2 : StoreGuilds.access$getEmptyRoles$cp();
    }
}
