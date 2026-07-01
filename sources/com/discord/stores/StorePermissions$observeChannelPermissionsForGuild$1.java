package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.h0;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StorePermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePermissions$observeChannelPermissionsForGuild$1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends Long>>, Map<Long, ? extends Long>> {
    public final /* synthetic */ long $guildId;

    public StorePermissions$observeChannelPermissionsForGuild$1(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends Long> call(Map<Long, ? extends Map<Long, ? extends Long>> map) {
        return call2((Map<Long, ? extends Map<Long, Long>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Long> call2(Map<Long, ? extends Map<Long, Long>> map) {
        m.checkNotNullExpressionValue(map, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
        Map<Long, Long> mapEmptyMap = map.get(Long.valueOf(this.$guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        return mapEmptyMap;
    }
}
