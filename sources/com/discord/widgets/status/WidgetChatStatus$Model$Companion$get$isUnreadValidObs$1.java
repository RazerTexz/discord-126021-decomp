package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreMessageAck$Ack;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1<T, R> implements b<Long, Observable<? extends Boolean>> {
    public static final WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1 INSTANCE = new WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Boolean> call2(Long l) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreMessageAck messageAck = storeStream$Companion.getMessageAck();
        m.checkNotNullExpressionValue(l, "selectedChannelId");
        Observable<StoreMessageAck$Ack> observableObserveForChannel = messageAck.observeForChannel(l.longValue());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Observable.m(new k(Boolean.FALSE), Observable.j(observableObserveForChannel.p(200L, timeUnit), storeStream$Companion.getMessagesMostRecent().observeRecentMessageIds(l.longValue()).p(200L, timeUnit).Z(1), WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1.INSTANCE).b0(WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$2.INSTANCE));
    }
}
