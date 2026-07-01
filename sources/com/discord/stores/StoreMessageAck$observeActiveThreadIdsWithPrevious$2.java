package com.discord.stores;

import androidx.core.app.NotificationCompat;
import java.util.Set;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$observeActiveThreadIdsWithPrevious$2<T1, T2, R> implements Func2<Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Set<? extends Long>, Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>> {
    public static final StoreMessageAck$observeActiveThreadIdsWithPrevious$2 INSTANCE = new StoreMessageAck$observeActiveThreadIdsWithPrevious$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> call(Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> pair, Set<? extends Long> set) {
        return call2((Pair<? extends Set<Long>, ? extends Set<Long>>) pair, (Set<Long>) set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<Set<Long>, Set<Long>> call2(Pair<? extends Set<Long>, ? extends Set<Long>> pair, Set<Long> set) {
        return new Pair<>(pair.getSecond(), set);
    }
}
