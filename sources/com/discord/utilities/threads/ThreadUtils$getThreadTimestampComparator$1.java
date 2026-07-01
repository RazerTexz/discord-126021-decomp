package com.discord.utilities.threads;

import com.discord.stores.StoreThreadsActiveJoined$ActiveJoinedThread;
import java.util.Comparator;

/* JADX INFO: compiled from: ThreadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadUtils$getThreadTimestampComparator$1<T> implements Comparator<StoreThreadsActiveJoined$ActiveJoinedThread> {
    public static final ThreadUtils$getThreadTimestampComparator$1 INSTANCE = new ThreadUtils$getThreadTimestampComparator$1();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(StoreThreadsActiveJoined$ActiveJoinedThread storeThreadsActiveJoined$ActiveJoinedThread, StoreThreadsActiveJoined$ActiveJoinedThread storeThreadsActiveJoined$ActiveJoinedThread2) {
        return compare2(storeThreadsActiveJoined$ActiveJoinedThread, storeThreadsActiveJoined$ActiveJoinedThread2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(StoreThreadsActiveJoined$ActiveJoinedThread storeThreadsActiveJoined$ActiveJoinedThread, StoreThreadsActiveJoined$ActiveJoinedThread storeThreadsActiveJoined$ActiveJoinedThread2) {
        return (storeThreadsActiveJoined$ActiveJoinedThread2.getJoinTimestamp().getDateTimeMillis() > storeThreadsActiveJoined$ActiveJoinedThread.getJoinTimestamp().getDateTimeMillis() ? 1 : (storeThreadsActiveJoined$ActiveJoinedThread2.getJoinTimestamp().getDateTimeMillis() == storeThreadsActiveJoined$ActiveJoinedThread.getJoinTimestamp().getDateTimeMillis() ? 0 : -1));
    }
}
