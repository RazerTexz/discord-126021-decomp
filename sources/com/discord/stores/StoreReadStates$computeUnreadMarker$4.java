package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.application.Unread;
import com.discord.models.application.Unread$Marker;
import d0.z.d.m;
import j0.k.a;
import j0.k.a$a;
import j0.k.b;
import j0.l.a.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$computeUnreadMarker$4<T, R> implements b<Unread$Marker, Observable<? extends Unread>> {
    public final /* synthetic */ StoreReadStates this$0;

    public StoreReadStates$computeUnreadMarker$4(StoreReadStates storeReadStates) {
        this.this$0 = storeReadStates;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Unread> call(Unread$Marker unread$Marker) {
        return call2(unread$Marker);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Unread> call2(Unread$Marker unread$Marker) {
        m.checkNotNullParameter(unread$Marker, "marker");
        Observable<R> observableA0 = StoreStream.Companion.getMessages().observeMessagesForChannel(unread$Marker.getChannelId()).G(new StoreReadStates$computeUnreadMarker$4$1(unread$Marker)).a0(StoreReadStates.access$getMarkAsRead$p(this.this$0).y(StoreReadStates$computeUnreadMarker$4$2.INSTANCE));
        StoreReadStates$computeUnreadMarker$4$3 storeReadStates$computeUnreadMarker$4$3 = new StoreReadStates$computeUnreadMarker$4$3(this);
        a$a a_a = a.a;
        return Observable.h0(new k(observableA0, new j0.l.e.a(a_a, a_a, storeReadStates$computeUnreadMarker$4$3)));
    }
}
