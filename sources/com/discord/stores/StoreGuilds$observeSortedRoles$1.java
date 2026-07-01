package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.utilities.guilds.RoleUtils;
import d0.t.u;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeSortedRoles$1<T, R> implements b<Map<Long, ? extends GuildRole>, Observable<? extends List<? extends GuildRole>>> {
    public static final StoreGuilds$observeSortedRoles$1 INSTANCE = new StoreGuilds$observeSortedRoles$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends GuildRole>> call(Map<Long, ? extends GuildRole> map) {
        return call2((Map<Long, GuildRole>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<GuildRole>> call2(Map<Long, GuildRole> map) {
        return new k(u.sortedWith(map.values(), RoleUtils.getROLE_COMPARATOR()));
    }
}
