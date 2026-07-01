package com.discord.stores;

import com.discord.models.domain.ModelSubscription;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* JADX INFO: compiled from: StoreSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private StoreSubscriptions$SubscriptionsState subscriptionsState;
    private StoreSubscriptions$SubscriptionsState subscriptionsStateSnapshot;

    public StoreSubscriptions(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        StoreSubscriptions$SubscriptionsState$Unfetched storeSubscriptions$SubscriptionsState$Unfetched = StoreSubscriptions$SubscriptionsState$Unfetched.INSTANCE;
        this.subscriptionsState = storeSubscriptions$SubscriptionsState$Unfetched;
        this.subscriptionsStateSnapshot = storeSubscriptions$SubscriptionsState$Unfetched;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreSubscriptions storeSubscriptions) {
        return storeSubscriptions.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreSubscriptions storeSubscriptions) {
        return storeSubscriptions.restAPI;
    }

    public static final /* synthetic */ StoreSubscriptions$SubscriptionsState access$getSubscriptionsState$p(StoreSubscriptions storeSubscriptions) {
        return storeSubscriptions.subscriptionsState;
    }

    public static final /* synthetic */ void access$handleSubscriptionsFetchFailure(StoreSubscriptions storeSubscriptions) {
        storeSubscriptions.handleSubscriptionsFetchFailure();
    }

    public static final /* synthetic */ void access$handleSubscriptionsFetchStart(StoreSubscriptions storeSubscriptions) {
        storeSubscriptions.handleSubscriptionsFetchStart();
    }

    public static final /* synthetic */ void access$handleSubscriptionsFetchSuccess(StoreSubscriptions storeSubscriptions, List list) {
        storeSubscriptions.handleSubscriptionsFetchSuccess(list);
    }

    public static final /* synthetic */ void access$setSubscriptionsState$p(StoreSubscriptions storeSubscriptions, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        storeSubscriptions.subscriptionsState = storeSubscriptions$SubscriptionsState;
    }

    @StoreThread
    private final void handleSubscriptionsFetchFailure() {
        this.subscriptionsState = StoreSubscriptions$SubscriptionsState$Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handleSubscriptionsFetchStart() {
        this.subscriptionsState = StoreSubscriptions$SubscriptionsState$Loading.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handleSubscriptionsFetchSuccess(List<ModelSubscription> subscriptions) {
        this.subscriptionsState = new StoreSubscriptions$SubscriptionsState$Loaded(subscriptions);
        markChanged();
    }

    public final void fetchSubscriptions() {
        this.dispatcher.schedule(new StoreSubscriptions$fetchSubscriptions$1(this));
    }

    /* JADX INFO: renamed from: getSubscriptions, reason: from getter */
    public final StoreSubscriptions$SubscriptionsState getSubscriptionsStateSnapshot() {
        return this.subscriptionsStateSnapshot;
    }

    @StoreThread
    public final void handlePreLogout() {
        this.subscriptionsState = StoreSubscriptions$SubscriptionsState$Unfetched.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleUserSubscriptionsUpdate() {
        fetchSubscriptions();
    }

    public final boolean hasFetchedSubscriptions() {
        return this.subscriptionsStateSnapshot instanceof StoreSubscriptions$SubscriptionsState$Loaded;
    }

    public final boolean isFetchingSubscriptions() {
        return this.subscriptionsStateSnapshot instanceof StoreSubscriptions$SubscriptionsState$Loading;
    }

    public final Observable<StoreSubscriptions$SubscriptionsState> observeSubscriptions() {
        Observable<StoreSubscriptions$SubscriptionsState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreSubscriptions$observeSubscriptions$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsStateCopy = this.subscriptionsState;
        if (storeSubscriptions$SubscriptionsStateCopy instanceof StoreSubscriptions$SubscriptionsState$Loaded) {
            StoreSubscriptions$SubscriptionsState$Loaded storeSubscriptions$SubscriptionsState$Loaded = (StoreSubscriptions$SubscriptionsState$Loaded) storeSubscriptions$SubscriptionsStateCopy;
            storeSubscriptions$SubscriptionsStateCopy = storeSubscriptions$SubscriptionsState$Loaded.copy(new ArrayList(storeSubscriptions$SubscriptionsState$Loaded.getSubscriptions()));
        } else if (!m.areEqual(storeSubscriptions$SubscriptionsStateCopy, StoreSubscriptions$SubscriptionsState$Failure.INSTANCE) && !m.areEqual(storeSubscriptions$SubscriptionsStateCopy, StoreSubscriptions$SubscriptionsState$Loading.INSTANCE) && !m.areEqual(storeSubscriptions$SubscriptionsStateCopy, StoreSubscriptions$SubscriptionsState$Unfetched.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.subscriptionsStateSnapshot = storeSubscriptions$SubscriptionsStateCopy;
    }
}
