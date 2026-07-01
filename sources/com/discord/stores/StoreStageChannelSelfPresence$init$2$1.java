package com.discord.stores;

import androidx.core.app.NotificationCompat;
import kotlin.Unit;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannelSelfPresence$init$2$1<T1, T2, R> implements Func2<Unit, Boolean, Boolean> {
    public static final StoreStageChannelSelfPresence$init$2$1 INSTANCE = new StoreStageChannelSelfPresence$init$2$1();

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Unit unit, Boolean bool) {
        return bool;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Unit unit, Boolean bool) {
        return call2(unit, bool);
    }
}
