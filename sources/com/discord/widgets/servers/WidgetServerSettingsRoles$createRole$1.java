package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.stores.StoreStream;
import d0.t.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$createRole$1<T, R> implements b<GuildRole, Observable<? extends GuildRole>> {
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsRoles$createRole$1(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GuildRole> call(GuildRole guildRole) {
        return call2(guildRole);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildRole> call2(GuildRole guildRole) {
        long id2 = guildRole.getId();
        return StoreStream.Companion.getGuilds().observeRoles(this.$guildId, m.listOf(Long.valueOf(id2))).G(new WidgetServerSettingsRoles$createRole$1$1(id2));
    }
}
