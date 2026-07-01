package com.discord.stores;

import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$fetchListing$1$1 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ Pair $key;
    public final /* synthetic */ ArchivedThreadsStore$fetchListing$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivedThreadsStore$fetchListing$1$1(ArchivedThreadsStore$fetchListing$1 archivedThreadsStore$fetchListing$1, Pair pair) {
        super(1);
        this.this$0 = archivedThreadsStore$fetchListing$1;
        this.$key = pair;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        ArchivedThreadsStore.access$getFetchSubscriptions$p(this.this$0.this$0).put(this.$key, subscription);
    }
}
