package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.authentication.AuthState;
import j0.k.b;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$getAuthedToken$1<T, R> implements b<AuthState, String> {
    public static final StoreAuthentication$getAuthedToken$1 INSTANCE = new StoreAuthentication$getAuthedToken$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(AuthState authState) {
        return call2(authState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(AuthState authState) {
        if (authState != null) {
            return authState.getToken();
        }
        return null;
    }
}
