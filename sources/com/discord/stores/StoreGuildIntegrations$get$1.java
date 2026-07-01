package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildIntegration;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreGuildIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildIntegrations$get$1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>>, Map<Long, ? extends ModelGuildIntegration>> {
    public final /* synthetic */ long $guildId;

    public StoreGuildIntegrations$get$1(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends ModelGuildIntegration> call(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, ModelGuildIntegration> call2(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
        return (Map) map.get(Long.valueOf(this.$guildId));
    }
}
