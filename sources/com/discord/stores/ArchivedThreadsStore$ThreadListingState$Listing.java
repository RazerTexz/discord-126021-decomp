package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ArchivedThreadsStore$ThreadListingState$Listing extends ArchivedThreadsStore$ThreadListingState {
    private final boolean hasMore;
    private final boolean isLoadingMore;
    private final List<Channel> threads;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivedThreadsStore$ThreadListingState$Listing(List<Channel> list, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(list, "threads");
        this.threads = list;
        this.hasMore = z2;
        this.isLoadingMore = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchivedThreadsStore$ThreadListingState$Listing copy$default(ArchivedThreadsStore$ThreadListingState$Listing archivedThreadsStore$ThreadListingState$Listing, List list, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = archivedThreadsStore$ThreadListingState$Listing.threads;
        }
        if ((i & 2) != 0) {
            z2 = archivedThreadsStore$ThreadListingState$Listing.hasMore;
        }
        if ((i & 4) != 0) {
            z3 = archivedThreadsStore$ThreadListingState$Listing.isLoadingMore;
        }
        return archivedThreadsStore$ThreadListingState$Listing.copy(list, z2, z3);
    }

    public final List<Channel> component1() {
        return this.threads;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLoadingMore() {
        return this.isLoadingMore;
    }

    public final ArchivedThreadsStore$ThreadListingState$Listing copy(List<Channel> threads, boolean hasMore, boolean isLoadingMore) {
        m.checkNotNullParameter(threads, "threads");
        return new ArchivedThreadsStore$ThreadListingState$Listing(threads, hasMore, isLoadingMore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArchivedThreadsStore$ThreadListingState$Listing)) {
            return false;
        }
        ArchivedThreadsStore$ThreadListingState$Listing archivedThreadsStore$ThreadListingState$Listing = (ArchivedThreadsStore$ThreadListingState$Listing) other;
        return m.areEqual(this.threads, archivedThreadsStore$ThreadListingState$Listing.threads) && this.hasMore == archivedThreadsStore$ThreadListingState$Listing.hasMore && this.isLoadingMore == archivedThreadsStore$ThreadListingState$Listing.isLoadingMore;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<Channel> getThreads() {
        return this.threads;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        List<Channel> list = this.threads;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMore;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isLoadingMore;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isLoadingMore() {
        return this.isLoadingMore;
    }

    public String toString() {
        StringBuilder sbU = a.U("Listing(threads=");
        sbU.append(this.threads);
        sbU.append(", hasMore=");
        sbU.append(this.hasMore);
        sbU.append(", isLoadingMore=");
        return a.O(sbU, this.isLoadingMore, ")");
    }
}
