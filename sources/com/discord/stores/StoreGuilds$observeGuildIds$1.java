package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import j0.k.b;
import j0.l.e.k;
import java.util.Map;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeGuildIds$1<T, R> implements b<Map<Long, ? extends Guild>, Observable<? extends Set<? extends Long>>> {
    public static final StoreGuilds$observeGuildIds$1 INSTANCE = new StoreGuilds$observeGuildIds$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Set<? extends Long>> call(Map<Long, ? extends Guild> map) {
        return call2((Map<Long, Guild>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Set<Long>> call2(Map<Long, Guild> map) {
        return new k(map.keySet());
    }
}
