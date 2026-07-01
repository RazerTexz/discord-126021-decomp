package com.discord.stores;

import com.discord.models.application.Unread$Marker;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$computeUnreadMarker$3 extends o implements Function1<Long, Observable<Unread$Marker>> {
    public static final StoreReadStates$computeUnreadMarker$3 INSTANCE = new StoreReadStates$computeUnreadMarker$3();

    public StoreReadStates$computeUnreadMarker$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Observable<Unread$Marker> invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Observable<Unread$Marker> invoke(long j) {
        Observable<Unread$Marker> observableInvoke = StoreReadStates$computeUnreadMarker$1.INSTANCE.invoke(j);
        m.checkNotNullExpressionValue(observableInvoke, "getMarker(channelId)");
        return observableInvoke;
    }
}
