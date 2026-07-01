package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import rx.Observable;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices$init$1<T, R> implements b<Unit, Observable<? extends Long>> {
    public final /* synthetic */ StoreNotices this$0;

    public StoreNotices$init$1(StoreNotices storeNotices) {
        this.this$0 = storeNotices;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(Unit unit) {
        return call2(unit);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(Unit unit) {
        return Observable.E(0L, StoreNotices.access$getPollRateMs$p(this.this$0), TimeUnit.MILLISECONDS);
    }
}
