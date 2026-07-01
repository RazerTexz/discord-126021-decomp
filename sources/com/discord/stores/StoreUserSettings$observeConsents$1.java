package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Consents;
import j0.k.b;

/* JADX INFO: compiled from: StoreUserSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettings$observeConsents$1<T, R> implements b<Throwable, Consents> {
    public static final StoreUserSettings$observeConsents$1 INSTANCE = new StoreUserSettings$observeConsents$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Consents call(Throwable th) {
        return call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Consents call2(Throwable th) {
        return Consents.Companion.getDEFAULT();
    }
}
