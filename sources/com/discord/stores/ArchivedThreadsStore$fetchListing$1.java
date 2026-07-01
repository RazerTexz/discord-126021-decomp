package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.z.d.o;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Subscription;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$fetchListing$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Function0 $onTerminated;
    public final /* synthetic */ boolean $reload;
    public final /* synthetic */ ArchivedThreadsStore$ThreadListingType $threadListingType;
    public final /* synthetic */ ArchivedThreadsStore this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivedThreadsStore$fetchListing$1(ArchivedThreadsStore archivedThreadsStore, long j, ArchivedThreadsStore$ThreadListingType archivedThreadsStore$ThreadListingType, boolean z2, Function0 function0) {
        super(0);
        this.this$0 = archivedThreadsStore;
        this.$channelId = j;
        this.$threadListingType = archivedThreadsStore$ThreadListingType;
        this.$reload = z2;
        this.$onTerminated = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Pair pair = new Pair(Long.valueOf(this.$channelId), this.$threadListingType);
        ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState = (ArchivedThreadsStore$ThreadListingState) ArchivedThreadsStore.access$getListings$p(this.this$0).get(pair);
        boolean z2 = archivedThreadsStore$ThreadListingState instanceof ArchivedThreadsStore$ThreadListingState$Listing;
        List<Channel> listEmptyList = (!z2 || this.$reload) ? n.emptyList() : ((ArchivedThreadsStore$ThreadListingState$Listing) archivedThreadsStore$ThreadListingState).getThreads();
        ArchivedThreadsStore.access$getListings$p(this.this$0).put(pair, z2 ? ArchivedThreadsStore$ThreadListingState$Listing.copy$default((ArchivedThreadsStore$ThreadListingState$Listing) archivedThreadsStore$ThreadListingState, null, false, true, 3, null) : new ArchivedThreadsStore$ThreadListingState$Listing(listEmptyList, true, true));
        this.this$0.markChanged();
        Subscription subscription = (Subscription) ArchivedThreadsStore.access$getFetchSubscriptions$p(this.this$0).get(pair);
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RetryWithDelay.restRetry$default(RetryWithDelay.INSTANCE, this.$threadListingType.fetchNext(this.$channelId, listEmptyList), 0L, null, null, 7, null), false, 1, null), this.this$0.getClass(), (Context) null, new ArchivedThreadsStore$fetchListing$1$1(this, pair), new ArchivedThreadsStore$fetchListing$1$2(this, pair), (Function0) null, new ArchivedThreadsStore$fetchListing$1$3(this), new ArchivedThreadsStore$fetchListing$1$4(this, pair, listEmptyList), 18, (Object) null);
    }
}
