package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected$observeInitializedForAuthedUser$1<T, R> implements b<Boolean, Observable<? extends Boolean>> {
    public final /* synthetic */ StoreChannelsSelected this$0;

    public StoreChannelsSelected$observeInitializedForAuthedUser$1(StoreChannelsSelected storeChannelsSelected) {
        this.this$0 = storeChannelsSelected;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Boolean> call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isStoreChannelsInitialized");
        return bool.booleanValue() ? ObservationDeck.connectRx$default(StoreChannelsSelected.access$getObservationDeck$p(this.this$0), new ObservationDeck$UpdateSource[]{StoreChannelsSelected.access$getInitializedUpdateSource$cp()}, false, null, null, new StoreChannelsSelected$observeInitializedForAuthedUser$1$1(this), 14, null) : new k(Boolean.FALSE);
    }
}
