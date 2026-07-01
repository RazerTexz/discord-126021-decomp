package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadListing;
import d0.t.u;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$fetchListing$1$4$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ThreadListing $result;
    public final /* synthetic */ ArchivedThreadsStore$fetchListing$1$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivedThreadsStore$fetchListing$1$4$1(ArchivedThreadsStore$fetchListing$1$4 archivedThreadsStore$fetchListing$1$4, ThreadListing threadListing) {
        super(0);
        this.this$0 = archivedThreadsStore$fetchListing$1$4;
        this.$result = threadListing;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Iterator<T> it = this.$result.c().iterator();
        while (it.hasNext()) {
            ArchivedThreadsStore.access$getStoreStream$p(this.this$0.this$0.this$0).handleThreadCreateOrUpdate((Channel) it.next());
        }
        Map mapAccess$getListings$p = ArchivedThreadsStore.access$getListings$p(this.this$0.this$0.this$0);
        ArchivedThreadsStore$fetchListing$1$4 archivedThreadsStore$fetchListing$1$4 = this.this$0;
        mapAccess$getListings$p.put(archivedThreadsStore$fetchListing$1$4.$key, new ArchivedThreadsStore$ThreadListingState$Listing(u.plus((Collection) archivedThreadsStore$fetchListing$1$4.$currentThreads, (Iterable) this.$result.c()), this.$result.getHasMore(), false));
        List<Message> listA = this.$result.a();
        if (listA != null) {
            ArchivedThreadsStore.access$getStoreForumPostMessages$p(this.this$0.this$0.this$0).bulkCreateFirstMessage(listA);
        }
        this.this$0.this$0.this$0.markChanged();
    }
}
