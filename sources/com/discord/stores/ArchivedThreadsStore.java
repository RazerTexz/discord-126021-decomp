package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadListing;
import com.discord.api.thread.ThreadMetadata;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Tuples2<Long, ThreadListingType>, Subscription> fetchSubscriptions;
    private Map<Tuples2<Long, ThreadListingType>, ThreadListingState> listings;
    private Map<Tuples2<Long, ThreadListingType>, ? extends ThreadListingState> listingsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreForumPostMessages storeForumPostMessages;
    private final StoreStream storeStream;

    /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
    public static abstract class ThreadListingState {

        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class Error extends ThreadListingState {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final /* data */ class Listing extends ThreadListingState {
            private final boolean hasMore;
            private final boolean isLoadingMore;
            private final List<Channel> threads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Listing(List<Channel> list, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "threads");
                this.threads = list;
                this.hasMore = z2;
                this.isLoadingMore = z3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Listing copy$default(Listing listing, List list, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = listing.threads;
                }
                if ((i & 2) != 0) {
                    z2 = listing.hasMore;
                }
                if ((i & 4) != 0) {
                    z3 = listing.isLoadingMore;
                }
                return listing.copy(list, z2, z3);
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

            public final Listing copy(List<Channel> threads, boolean hasMore, boolean isLoadingMore) {
                Intrinsics3.checkNotNullParameter(threads, "threads");
                return new Listing(threads, hasMore, isLoadingMore);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Listing)) {
                    return false;
                }
                Listing listing = (Listing) other;
                return Intrinsics3.areEqual(this.threads, listing.threads) && this.hasMore == listing.hasMore && this.isLoadingMore == listing.isLoadingMore;
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
                StringBuilder sbU = outline.U("Listing(threads=");
                sbU.append(this.threads);
                sbU.append(", hasMore=");
                sbU.append(this.hasMore);
                sbU.append(", isLoadingMore=");
                return outline.O(sbU, this.isLoadingMore, ")");
            }
        }

        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class Uninitialized extends ThreadListingState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ThreadListingState() {
        }

        public /* synthetic */ ThreadListingState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
    public static final class ThreadListingType {
        private static final /* synthetic */ ThreadListingType[] $VALUES;
        public static final ThreadListingType ALL_ARCHIVED_PRIVATE_THREADS;
        public static final ThreadListingType ALL_ARCHIVED_PUBLIC_THREADS;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ThreadListingType MY_ARCHIVED_PRIVATE_THREADS;

        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class ALL_ARCHIVED_PRIVATE_THREADS extends ThreadListingType {
            public ALL_ARCHIVED_PRIVATE_THREADS(String str, int i) {
                super(str, i, null);
            }

            @Override // com.discord.stores.ArchivedThreadsStore.ThreadListingType
            public Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads) {
                Intrinsics3.checkNotNullParameter(threads, "threads");
                try {
                    return RestAPI.INSTANCE.getApi().getAllPrivateArchivedThreads(channelId, ThreadListingType.INSTANCE.getLastArchiveTimestamp(threads));
                } catch (IllegalStateException e) {
                    Observable<ThreadListing> observableX = Observable.x(e);
                    Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(e)");
                    return observableX;
                }
            }
        }

        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class ALL_ARCHIVED_PUBLIC_THREADS extends ThreadListingType {
            public ALL_ARCHIVED_PUBLIC_THREADS(String str, int i) {
                super(str, i, null);
            }

            @Override // com.discord.stores.ArchivedThreadsStore.ThreadListingType
            public Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads) {
                Intrinsics3.checkNotNullParameter(threads, "threads");
                try {
                    return RestAPI.INSTANCE.getApi().getAllPublicArchivedThreads(channelId, ThreadListingType.INSTANCE.getLastArchiveTimestamp(threads));
                } catch (IllegalStateException e) {
                    Observable<ThreadListing> observableX = Observable.x(e);
                    Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(e)");
                    return observableX;
                }
            }
        }

        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class Companion {
            private Companion() {
            }

            private final String getLastArchiveTimestamp(List<Channel> threads) {
                String archiveTimestamp;
                if (threads.isEmpty()) {
                    return null;
                }
                ThreadMetadata threadMetadata = ((Channel) _Collections.last((List) threads)).getThreadMetadata();
                if (threadMetadata == null || (archiveTimestamp = threadMetadata.getArchiveTimestamp()) == null) {
                    throw new IllegalStateException("Thread missing threadMetadata");
                }
                return archiveTimestamp;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class MY_ARCHIVED_PRIVATE_THREADS extends ThreadListingType {
            public MY_ARCHIVED_PRIVATE_THREADS(String str, int i) {
                super(str, i, null);
            }

            @Override // com.discord.stores.ArchivedThreadsStore.ThreadListingType
            public Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads) {
                Intrinsics3.checkNotNullParameter(threads, "threads");
                Channel channel = (Channel) _Collections.lastOrNull((List) threads);
                return RestAPI.INSTANCE.getApi().getMyPrivateArchivedThreads(channelId, channel != null ? Long.valueOf(channel.getId()) : null);
            }
        }

        static {
            MY_ARCHIVED_PRIVATE_THREADS my_archived_private_threads = new MY_ARCHIVED_PRIVATE_THREADS("MY_ARCHIVED_PRIVATE_THREADS", 0);
            MY_ARCHIVED_PRIVATE_THREADS = my_archived_private_threads;
            ALL_ARCHIVED_PUBLIC_THREADS all_archived_public_threads = new ALL_ARCHIVED_PUBLIC_THREADS("ALL_ARCHIVED_PUBLIC_THREADS", 1);
            ALL_ARCHIVED_PUBLIC_THREADS = all_archived_public_threads;
            ALL_ARCHIVED_PRIVATE_THREADS all_archived_private_threads = new ALL_ARCHIVED_PRIVATE_THREADS("ALL_ARCHIVED_PRIVATE_THREADS", 2);
            ALL_ARCHIVED_PRIVATE_THREADS = all_archived_private_threads;
            $VALUES = new ThreadListingType[]{my_archived_private_threads, all_archived_public_threads, all_archived_private_threads};
            INSTANCE = new Companion(null);
        }

        private ThreadListingType(String str, int i) {
            super(str, i);
        }

        public static ThreadListingType valueOf(String str) {
            return (ThreadListingType) Enum.valueOf(ThreadListingType.class, str);
        }

        public static ThreadListingType[] values() {
            return (ThreadListingType[]) $VALUES.clone();
        }

        public abstract Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads);

        public /* synthetic */ ThreadListingType(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1, reason: invalid class name */
    /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Function0 $onTerminated;
        public final /* synthetic */ boolean $reload;
        public final /* synthetic */ ThreadListingType $threadListingType;

        /* JADX INFO: renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class C00701 extends Lambda implements Function1<Subscription, Unit> {
            public final /* synthetic */ Tuples2 $key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00701(Tuples2 tuples2) {
                super(1);
                this.$key = tuples2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
                invoke2(subscription);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Subscription subscription) {
                Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
                ArchivedThreadsStore.this.fetchSubscriptions.put(this.$key, subscription);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ Tuples2 $key;

            /* JADX INFO: renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
            public static final class C00711 extends Lambda implements Function0<Unit> {
                public C00711() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ArchivedThreadsStore.this.listings.put(AnonymousClass2.this.$key, ThreadListingState.Error.INSTANCE);
                    ArchivedThreadsStore.this.markChanged();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Tuples2 tuples2) {
                super(1);
                this.$key = tuples2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                ArchivedThreadsStore.this.dispatcher.schedule(new C00711());
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0 function0 = AnonymousClass1.this.$onTerminated;
                if (function0 != null) {
                }
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
        public static final class AnonymousClass4 extends Lambda implements Function1<ThreadListing, Unit> {
            public final /* synthetic */ List $currentThreads;
            public final /* synthetic */ Tuples2 $key;

            /* JADX INFO: renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$4$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
            public static final class C00721 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ThreadListing $result;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00721(ThreadListing threadListing) {
                    super(0);
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
                        ArchivedThreadsStore.this.storeStream.handleThreadCreateOrUpdate((Channel) it.next());
                    }
                    Map map = ArchivedThreadsStore.this.listings;
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    map.put(anonymousClass4.$key, new ThreadListingState.Listing(_Collections.plus((Collection) anonymousClass4.$currentThreads, (Iterable) this.$result.c()), this.$result.getHasMore(), false));
                    List<Message> listA = this.$result.a();
                    if (listA != null) {
                        ArchivedThreadsStore.this.storeForumPostMessages.bulkCreateFirstMessage(listA);
                    }
                    ArchivedThreadsStore.this.markChanged();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(Tuples2 tuples2, List list) {
                super(1);
                this.$key = tuples2;
                this.$currentThreads = list;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ThreadListing threadListing) {
                invoke2(threadListing);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ThreadListing threadListing) {
                Intrinsics3.checkNotNullParameter(threadListing, "result");
                ArchivedThreadsStore.this.dispatcher.schedule(new C00721(threadListing));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, ThreadListingType threadListingType, boolean z2, Function0 function0) {
            super(0);
            this.$channelId = j;
            this.$threadListingType = threadListingType;
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
            Tuples2 tuples2 = new Tuples2(Long.valueOf(this.$channelId), this.$threadListingType);
            ThreadListingState threadListingState = (ThreadListingState) ArchivedThreadsStore.this.listings.get(tuples2);
            boolean z2 = threadListingState instanceof ThreadListingState.Listing;
            List<Channel> listEmptyList = (!z2 || this.$reload) ? Collections2.emptyList() : ((ThreadListingState.Listing) threadListingState).getThreads();
            ArchivedThreadsStore.this.listings.put(tuples2, z2 ? ThreadListingState.Listing.copy$default((ThreadListingState.Listing) threadListingState, null, false, true, 3, null) : new ThreadListingState.Listing(listEmptyList, true, true));
            ArchivedThreadsStore.this.markChanged();
            Subscription subscription = (Subscription) ArchivedThreadsStore.this.fetchSubscriptions.get(tuples2);
            if (subscription != null) {
                subscription.unsubscribe();
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RetryWithDelay.restRetry$default(RetryWithDelay.INSTANCE, this.$threadListingType.fetchNext(this.$channelId, listEmptyList), 0L, null, null, 7, null), false, 1, null), (Class<?>) ArchivedThreadsStore.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C00701(tuples2)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(tuples2)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new AnonymousClass3()), new AnonymousClass4(tuples2, listEmptyList));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.ArchivedThreadsStore$loadAndObserveThreadListing$1, reason: invalid class name */
    /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ThreadListingState> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ ThreadListingType $threadListingType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, ThreadListingType threadListingType) {
            super(0);
            this.$channelId = j;
            this.$threadListingType = threadListingType;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ThreadListingState invoke() {
            ThreadListingState threadListingState = (ThreadListingState) ArchivedThreadsStore.this.listingsSnapshot.get(new Tuples2(Long.valueOf(this.$channelId), this.$threadListingType));
            return threadListingState != null ? threadListingState : ThreadListingState.Uninitialized.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.ArchivedThreadsStore$observeGuildForumThreadListing$1, reason: invalid class name */
    /* JADX INFO: compiled from: ArchivedThreadsStore.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ThreadListingState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ThreadListingState invoke() {
            ThreadListingState threadListingState = (ThreadListingState) ArchivedThreadsStore.this.listingsSnapshot.get(new Tuples2(Long.valueOf(this.$channelId), ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS));
            return threadListingState != null ? threadListingState : ThreadListingState.Uninitialized.INSTANCE;
        }
    }

    public /* synthetic */ ArchivedThreadsStore(StoreStream storeStream, Dispatcher dispatcher, StoreForumPostMessages storeForumPostMessages, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeForumPostMessages, (i & 8) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchGuildForumThreadListing$default(ArchivedThreadsStore archivedThreadsStore, long j, boolean z2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        archivedThreadsStore.fetchGuildForumThreadListing(j, z2, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchListing$default(ArchivedThreadsStore archivedThreadsStore, long j, ThreadListingType threadListingType, boolean z2, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? false : z2;
        if ((i & 8) != 0) {
            function0 = null;
        }
        archivedThreadsStore.fetchListing(j, threadListingType, z3, function0);
    }

    public final void fetchGuildForumThreadListing(long channelId, boolean reload, Function0<Unit> onTerminated) {
        fetchListing(channelId, ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS, reload, onTerminated);
    }

    public final void fetchListing(long channelId, ThreadListingType threadListingType, boolean reload, Function0<Unit> onTerminated) {
        Intrinsics3.checkNotNullParameter(threadListingType, "threadListingType");
        this.dispatcher.schedule(new AnonymousClass1(channelId, threadListingType, reload, onTerminated));
    }

    @Store3
    public final void handleConnectionOpen() {
        this.listings = new HashMap();
        Iterator<T> it = this.fetchSubscriptions.values().iterator();
        while (it.hasNext()) {
            ((Subscription) it.next()).unsubscribe();
        }
        this.fetchSubscriptions = new HashMap();
        markChanged();
    }

    public final Observable<ThreadListingState> loadAndObserveGuildForumThreadListing(long channelId) {
        fetchGuildForumThreadListing$default(this, channelId, false, null, 6, null);
        return observeGuildForumThreadListing(channelId);
    }

    public final Observable<ThreadListingState> loadAndObserveThreadListing(long channelId, ThreadListingType threadListingType) {
        Intrinsics3.checkNotNullParameter(threadListingType, "threadListingType");
        fetchListing$default(this, channelId, threadListingType, true, null, 8, null);
        Observable<ThreadListingState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId, threadListingType), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ThreadListingState> observeGuildForumThreadListing(long channelId) {
        Observable<ThreadListingState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.listingsSnapshot = new HashMap(this.listings);
    }

    public ArchivedThreadsStore(StoreStream storeStream, Dispatcher dispatcher, StoreForumPostMessages storeForumPostMessages, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.storeForumPostMessages = storeForumPostMessages;
        this.observationDeck = observationDeck;
        this.listings = new HashMap();
        this.listingsSnapshot = new HashMap();
        this.fetchSubscriptions = new HashMap();
    }
}
