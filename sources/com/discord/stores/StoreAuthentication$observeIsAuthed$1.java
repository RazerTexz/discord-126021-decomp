package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.authentication.AuthState;
import j0.k.b;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$observeIsAuthed$1<T, R> implements b<AuthState, Boolean> {
    public static final StoreAuthentication$observeIsAuthed$1 INSTANCE = new StoreAuthentication$observeIsAuthed$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(AuthState authState) {
        return call2(authState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(AuthState authState) {
        return Boolean.valueOf(authState != null);
    }
}
