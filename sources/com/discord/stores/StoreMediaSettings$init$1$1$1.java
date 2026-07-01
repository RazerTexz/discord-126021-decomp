package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import j0.k.b;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaSettings$init$1$1$1<T, R> implements b<Long, Boolean> {
    public static final StoreMediaSettings$init$1$1$1 INSTANCE = new StoreMediaSettings$init$1$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.valueOf(PermissionUtils.can(Permission.USE_VAD, l));
    }
}
