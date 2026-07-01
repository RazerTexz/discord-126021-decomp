package com.discord.stores;

import com.discord.models.application.Unread$Marker;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$computeUnreadMarker$1 extends o implements Function1<Long, Observable<Unread$Marker>> {
    public static final StoreReadStates$computeUnreadMarker$1 INSTANCE = new StoreReadStates$computeUnreadMarker$1();

    public StoreReadStates$computeUnreadMarker$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Observable<Unread$Marker> invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Observable<Unread$Marker> invoke(long j) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.i(storeStream$Companion.getMessageAck().observeAll().G(new StoreReadStates$computeUnreadMarker$1$1(j)).Z(1), storeStream$Companion.getMessageAck().observeAll().G(new StoreReadStates$computeUnreadMarker$1$2(j)), storeStream$Companion.getMessagesMostRecent().observeRecentMessageIds(j).Z(1), new StoreReadStates$computeUnreadMarker$1$3(j));
    }
}
