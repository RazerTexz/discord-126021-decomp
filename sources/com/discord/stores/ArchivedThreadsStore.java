package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Pair<Long, ArchivedThreadsStore$ThreadListingType>, Subscription> fetchSubscriptions;
    private Map<Pair<Long, ArchivedThreadsStore$ThreadListingType>, ArchivedThreadsStore$ThreadListingState> listings;
    private Map<Pair<Long, ArchivedThreadsStore$ThreadListingType>, ? extends ArchivedThreadsStore$ThreadListingState> listingsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreForumPostMessages storeForumPostMessages;
    private final StoreStream storeStream;

    public /* synthetic */ ArchivedThreadsStore(StoreStream storeStream, Dispatcher dispatcher, StoreForumPostMessages storeForumPostMessages, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeForumPostMessages, (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.dispatcher;
    }

    public static final /* synthetic */ Map access$getFetchSubscriptions$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.fetchSubscriptions;
    }

    public static final /* synthetic */ Map access$getListings$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.listings;
    }

    public static final /* synthetic */ Map access$getListingsSnapshot$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.listingsSnapshot;
    }

    public static final /* synthetic */ StoreForumPostMessages access$getStoreForumPostMessages$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.storeForumPostMessages;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.storeStream;
    }

    public static final /* synthetic */ void access$setFetchSubscriptions$p(ArchivedThreadsStore archivedThreadsStore, Map map) {
        archivedThreadsStore.fetchSubscriptions = map;
    }

    public static final /* synthetic */ void access$setListings$p(ArchivedThreadsStore archivedThreadsStore, Map map) {
        archivedThreadsStore.listings = map;
    }

    public static final /* synthetic */ void access$setListingsSnapshot$p(ArchivedThreadsStore archivedThreadsStore, Map map) {
        archivedThreadsStore.listingsSnapshot = map;
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
    public static /* synthetic */ void fetchListing$default(ArchivedThreadsStore archivedThreadsStore, long j, ArchivedThreadsStore$ThreadListingType archivedThreadsStore$ThreadListingType, boolean z2, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? false : z2;
        if ((i & 8) != 0) {
            function0 = null;
        }
        archivedThreadsStore.fetchListing(j, archivedThreadsStore$ThreadListingType, z3, function0);
    }

    public final void fetchGuildForumThreadListing(long channelId, boolean reload, Function0<Unit> onTerminated) {
        fetchListing(channelId, ArchivedThreadsStore$ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS, reload, onTerminated);
    }

    public final void fetchListing(long channelId, ArchivedThreadsStore$ThreadListingType threadListingType, boolean reload, Function0<Unit> onTerminated) {
        m.checkNotNullParameter(threadListingType, "threadListingType");
        this.dispatcher.schedule(new ArchivedThreadsStore$fetchListing$1(this, channelId, threadListingType, reload, onTerminated));
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.listings = new HashMap();
        Iterator<T> it = this.fetchSubscriptions.values().iterator();
        while (it.hasNext()) {
            ((Subscription) it.next()).unsubscribe();
        }
        this.fetchSubscriptions = new HashMap();
        markChanged();
    }

    public final Observable<ArchivedThreadsStore$ThreadListingState> loadAndObserveGuildForumThreadListing(long channelId) {
        fetchGuildForumThreadListing$default(this, channelId, false, null, 6, null);
        return observeGuildForumThreadListing(channelId);
    }

    public final Observable<ArchivedThreadsStore$ThreadListingState> loadAndObserveThreadListing(long channelId, ArchivedThreadsStore$ThreadListingType threadListingType) {
        m.checkNotNullParameter(threadListingType, "threadListingType");
        fetchListing$default(this, channelId, threadListingType, true, null, 8, null);
        Observable<ArchivedThreadsStore$ThreadListingState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new ArchivedThreadsStore$loadAndObserveThreadListing$1(this, channelId, threadListingType), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ArchivedThreadsStore$ThreadListingState> observeGuildForumThreadListing(long channelId) {
        Observable<ArchivedThreadsStore$ThreadListingState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new ArchivedThreadsStore$observeGuildForumThreadListing$1(this, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.listingsSnapshot = new HashMap(this.listings);
    }

    public ArchivedThreadsStore(StoreStream storeStream, Dispatcher dispatcher, StoreForumPostMessages storeForumPostMessages, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.storeForumPostMessages = storeForumPostMessages;
        this.observationDeck = observationDeck;
        this.listings = new HashMap();
        this.listingsSnapshot = new HashMap();
        this.fetchSubscriptions = new HashMap();
    }
}
