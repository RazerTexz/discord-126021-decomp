package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannelSelfPresence$init$2<T, R> implements b<Integer, Observable<? extends Boolean>> {
    public final /* synthetic */ StoreStageChannelSelfPresence this$0;

    public StoreStageChannelSelfPresence$init$2(StoreStageChannelSelfPresence storeStageChannelSelfPresence) {
        this.this$0 = storeStageChannelSelfPresence;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Boolean> call2(Integer num) {
        return Observable.j(ObservableExtensionsKt.leadingEdgeThrottle(this.this$0.getPublishStateTrigger(), num.intValue(), TimeUnit.SECONDS), this.this$0.getUserSettings().observeIsShowCurrentGameEnabled(), StoreStageChannelSelfPresence$init$2$1.INSTANCE);
    }
}
