package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.t.o0;
import java.util.Map;
import java.util.Set;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$observeActiveThreadIdsWithPrevious$1<T1, T2, R> implements Func2<Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>, Map<Long, ? extends Channel>, Set<? extends Long>> {
    public static final StoreMessageAck$observeActiveThreadIdsWithPrevious$1 INSTANCE = new StoreMessageAck$observeActiveThreadIdsWithPrevious$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread> map, Map<Long, ? extends Channel> map2) {
        return call2((Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>) map, (Map<Long, Channel>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> map, Map<Long, Channel> map2) {
        return o0.plus((Set) map.keySet(), (Iterable) map2.keySet());
    }
}
