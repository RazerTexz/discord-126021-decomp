package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$Actions$requestMembers$3$1<T> implements Action1<Long> {
    public final /* synthetic */ String $query;

    public StoreGuilds$Actions$requestMembers$3$1(String str) {
        this.$query = str;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Long l) {
        call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Long l) {
        StoreGatewayConnection gatewaySocket = StoreStream.Companion.getGatewaySocket();
        m.checkNotNullExpressionValue(l, "selectedGuildId");
        StoreGatewayConnection.requestGuildMembers$default(gatewaySocket, l.longValue(), this.$query, null, null, 12, null);
    }
}
