package com.discord.stores;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$getFingerprintSnapshotOrGenerate$2<T> implements Action1<String> {
    public final /* synthetic */ StoreAuthentication this$0;

    public StoreAuthentication$getFingerprintSnapshotOrGenerate$2(StoreAuthentication storeAuthentication) {
        this.this$0 = storeAuthentication;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        this.this$0.setFingerprint(str, false);
    }
}
