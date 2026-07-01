package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$postPendingAck$2<T, R> implements b<StoreMessageAck$PendingAck, Boolean> {
    public static final StoreMessageAck$postPendingAck$2 INSTANCE = new StoreMessageAck$postPendingAck$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(StoreMessageAck$PendingAck storeMessageAck$PendingAck) {
        return call2(storeMessageAck$PendingAck);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreMessageAck$PendingAck storeMessageAck$PendingAck) {
        return Boolean.valueOf(!m.areEqual(storeMessageAck$PendingAck, StoreMessageAck$PendingAck.Companion.getEMPTY()));
    }
}
