package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import rx.functions.Func3;

/* JADX INFO: compiled from: ScreenShareManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenShareManager$subscribeToStores$1<T1, T2, T3, R> implements Func3<StoreApplicationStreaming$ActiveApplicationStream, RtcConnection, MeUser, ScreenShareManager$State> {
    public static final ScreenShareManager$subscribeToStores$1 INSTANCE = new ScreenShareManager$subscribeToStores$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ ScreenShareManager$State call(StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, RtcConnection rtcConnection, MeUser meUser) {
        return call2(storeApplicationStreaming$ActiveApplicationStream, rtcConnection, meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ScreenShareManager$State call2(StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, RtcConnection rtcConnection, MeUser meUser) {
        return new ScreenShareManager$State(storeApplicationStreaming$ActiveApplicationStream, rtcConnection, meUser != null ? Long.valueOf(meUser.getId()) : null);
    }
}
