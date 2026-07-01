package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.permissions.PermissionUtils;
import j0.k.b;

/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode$getChannelCooldownObservable$newObservable$1<T, R> implements b<Long, Boolean> {
    public final /* synthetic */ StoreSlowMode$Type $type;

    public StoreSlowMode$getChannelCooldownObservable$newObservable$1(StoreSlowMode$Type storeSlowMode$Type) {
        this.$type = storeSlowMode$Type;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.valueOf(PermissionUtils.INSTANCE.hasBypassSlowmodePermissions(l, this.$type));
    }
}
