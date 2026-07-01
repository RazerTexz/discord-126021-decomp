package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$createRole$1$1<T, R> implements b<Map<Long, ? extends GuildRole>, GuildRole> {
    public final /* synthetic */ long $id;

    public WidgetServerSettingsRoles$createRole$1$1(long j) {
        this.$id = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GuildRole call(Map<Long, ? extends GuildRole> map) {
        return call2((Map<Long, GuildRole>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildRole call2(Map<Long, GuildRole> map) {
        return map.get(Long.valueOf(this.$id));
    }
}
