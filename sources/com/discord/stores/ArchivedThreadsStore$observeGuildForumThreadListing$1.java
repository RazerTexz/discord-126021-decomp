package com.discord.stores;

import d0.z.d.o;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$observeGuildForumThreadListing$1 extends o implements Function0<ArchivedThreadsStore$ThreadListingState> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ ArchivedThreadsStore this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivedThreadsStore$observeGuildForumThreadListing$1(ArchivedThreadsStore archivedThreadsStore, long j) {
        super(0);
        this.this$0 = archivedThreadsStore;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ArchivedThreadsStore$ThreadListingState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ArchivedThreadsStore$ThreadListingState invoke() {
        ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState = (ArchivedThreadsStore$ThreadListingState) ArchivedThreadsStore.access$getListingsSnapshot$p(this.this$0).get(new Pair(Long.valueOf(this.$channelId), ArchivedThreadsStore$ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS));
        return archivedThreadsStore$ThreadListingState != null ? archivedThreadsStore$ThreadListingState : ArchivedThreadsStore$ThreadListingState$Uninitialized.INSTANCE;
    }
}
