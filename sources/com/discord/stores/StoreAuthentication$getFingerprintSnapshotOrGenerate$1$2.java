package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.fingerprint.FingerprintResponse;
import j0.k.b;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$getFingerprintSnapshotOrGenerate$1$2<T, R> implements b<FingerprintResponse, String> {
    public static final StoreAuthentication$getFingerprintSnapshotOrGenerate$1$2 INSTANCE = new StoreAuthentication$getFingerprintSnapshotOrGenerate$1$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(FingerprintResponse fingerprintResponse) {
        return call2(fingerprintResponse);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(FingerprintResponse fingerprintResponse) {
        return fingerprintResponse.getFingerprint();
    }
}
