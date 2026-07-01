package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import j0.k.b;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings$trackWithInvite$1<T, R> implements b<ModelInvite, Boolean> {
    public static final StoreInviteSettings$trackWithInvite$1 INSTANCE = new StoreInviteSettings$trackWithInvite$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(ModelInvite modelInvite) {
        return call2(modelInvite);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(ModelInvite modelInvite) {
        return Boolean.valueOf(modelInvite != null);
    }
}
