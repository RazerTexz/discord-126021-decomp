package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$logout$2<T, R> implements b<Void, Observable<? extends String>> {
    public final /* synthetic */ StoreAuthentication this$0;

    public StoreAuthentication$logout$2(StoreAuthentication storeAuthentication) {
        this.this$0 = storeAuthentication;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends String> call(Void r1) {
        return call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends String> call2(Void r1) {
        return StoreAuthentication.access$getFingerprintSnapshotOrGenerate(this.this$0);
    }
}
