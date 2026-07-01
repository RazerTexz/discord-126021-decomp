package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildIntegration;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreGuildIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildIntegrations$get$2<T, R> implements b<Map<Long, ? extends ModelGuildIntegration>, ModelGuildIntegration> {
    public final /* synthetic */ long $integrationId;

    public StoreGuildIntegrations$get$2(long j) {
        this.$integrationId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ ModelGuildIntegration call(Map<Long, ? extends ModelGuildIntegration> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ModelGuildIntegration call2(Map<Long, ? extends ModelGuildIntegration> map) {
        if (map != null) {
            return map.get(Long.valueOf(this.$integrationId));
        }
        return null;
    }
}
