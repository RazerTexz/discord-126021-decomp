package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeGuild$1<T, R> implements b<Map<Long, ? extends Guild>, Guild> {
    public final /* synthetic */ long $guildId;

    public StoreGuilds$observeGuild$1(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Guild call(Map<Long, ? extends Guild> map) {
        return call2((Map<Long, Guild>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Guild call2(Map<Long, Guild> map) {
        return map.get(Long.valueOf(this.$guildId));
    }
}
