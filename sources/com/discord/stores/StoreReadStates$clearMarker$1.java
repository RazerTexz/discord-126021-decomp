package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.application.Unread;
import j0.k.b;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$clearMarker$1<T, R> implements b<Unread, Unread> {
    public static final StoreReadStates$clearMarker$1 INSTANCE = new StoreReadStates$clearMarker$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Unread call(Unread unread) {
        return call2(unread);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Unread call2(Unread unread) {
        return unread.createWithEmptyCount();
    }
}
