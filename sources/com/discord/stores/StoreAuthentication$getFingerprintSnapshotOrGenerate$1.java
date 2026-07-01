package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.restapi.RestAPIParams$EmptyBody;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$getFingerprintSnapshotOrGenerate$1<T, R> implements b<String, Observable<? extends String>> {
    public static final StoreAuthentication$getFingerprintSnapshotOrGenerate$1 INSTANCE = new StoreAuthentication$getFingerprintSnapshotOrGenerate$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends String> call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends String> call2(String str) {
        return str != null ? new k(str) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().postAuthFingerprint(new RestAPIParams$EmptyBody()), false, 1, null).G(StoreAuthentication$getFingerprintSnapshotOrGenerate$1$2.INSTANCE);
    }
}
