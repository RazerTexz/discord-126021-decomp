package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.application.Unread;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$getUnreadMarker$1<T, R> implements b<Unread, Boolean> {
    public final /* synthetic */ long $channelId;

    public StoreReadStates$getUnreadMarker$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Unread unread) {
        return call2(unread);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Unread unread) {
        m.checkNotNullParameter(unread, "marker");
        return Boolean.valueOf(unread.getMarker().getChannelId() == this.$channelId);
    }
}
