package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import j0.k.b;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$observeMe$2<T, R> implements b<MeUser, Boolean> {
    public final /* synthetic */ boolean $emitEmpty;

    public StoreUser$observeMe$2(boolean z2) {
        this.$emitEmpty = z2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        return Boolean.valueOf(meUser != StoreUser.access$getEMPTY_ME_USER$cp() || this.$emitEmpty);
    }
}
