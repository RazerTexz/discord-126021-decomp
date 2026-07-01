package com.discord.stores;

import com.discord.api.thread.ThreadListing;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$fetchListing$1$4 extends o implements Function1<ThreadListing, Unit> {
    public final /* synthetic */ List $currentThreads;
    public final /* synthetic */ Pair $key;
    public final /* synthetic */ ArchivedThreadsStore$fetchListing$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivedThreadsStore$fetchListing$1$4(ArchivedThreadsStore$fetchListing$1 archivedThreadsStore$fetchListing$1, Pair pair, List list) {
        super(1);
        this.this$0 = archivedThreadsStore$fetchListing$1;
        this.$key = pair;
        this.$currentThreads = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ThreadListing threadListing) {
        invoke2(threadListing);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ThreadListing threadListing) {
        m.checkNotNullParameter(threadListing, "result");
        ArchivedThreadsStore.access$getDispatcher$p(this.this$0.this$0).schedule(new ArchivedThreadsStore$fetchListing$1$4$1(this, threadListing));
    }
}
