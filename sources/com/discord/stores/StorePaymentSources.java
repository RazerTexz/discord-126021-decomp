package com.discord.stores;

import androidx.core.view.PointerIconCompat;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.PaymentSourceRaw;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StorePaymentSources.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePaymentSources extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private StorePaymentSources$PaymentSourcesState paymentSourcesState;
    private StorePaymentSources$PaymentSourcesState paymentSourcesStateSnapshot;
    private final RestAPI restAPI;

    public /* synthetic */ StorePaymentSources(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ List access$ensureDefaultPaymentSource(StorePaymentSources storePaymentSources, List list) {
        return storePaymentSources.ensureDefaultPaymentSource(list);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StorePaymentSources storePaymentSources) {
        return storePaymentSources.dispatcher;
    }

    public static final /* synthetic */ StorePaymentSources$PaymentSourcesState access$getPaymentSourcesState$p(StorePaymentSources storePaymentSources) {
        return storePaymentSources.paymentSourcesState;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StorePaymentSources storePaymentSources) {
        return storePaymentSources.restAPI;
    }

    public static final /* synthetic */ void access$handlePaymentSourcesFetchFailure(StorePaymentSources storePaymentSources) {
        storePaymentSources.handlePaymentSourcesFetchFailure();
    }

    public static final /* synthetic */ void access$handlePaymentSourcesFetchStart(StorePaymentSources storePaymentSources) {
        storePaymentSources.handlePaymentSourcesFetchStart();
    }

    public static final /* synthetic */ void access$handlePaymentSourcesFetchSuccess(StorePaymentSources storePaymentSources, List list) {
        storePaymentSources.handlePaymentSourcesFetchSuccess(list);
    }

    public static final /* synthetic */ void access$setPaymentSourcesState$p(StorePaymentSources storePaymentSources, StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState) {
        storePaymentSources.paymentSourcesState = storePaymentSources$PaymentSourcesState;
    }

    private final List<ModelPaymentSource> ensureDefaultPaymentSource(List<PaymentSourceRaw> rawPaymentSources) {
        if (rawPaymentSources.isEmpty()) {
            return n.emptyList();
        }
        List mutableList = u.toMutableList((Collection) u.sortedWith(rawPaymentSources, new StorePaymentSources$ensureDefaultPaymentSource$$inlined$sortedBy$1()));
        mutableList.set(0, PaymentSourceRaw.copy$default((PaymentSourceRaw) u.first(mutableList), 0, null, false, null, true, null, null, null, 0, 0, PointerIconCompat.TYPE_CROSSHAIR, null));
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(mutableList, 10));
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            arrayList.add(ModelPaymentSource.Companion.wrap((PaymentSourceRaw) it.next()));
        }
        return arrayList;
    }

    @StoreThread
    private final void handlePaymentSourcesFetchFailure() {
        this.paymentSourcesState = StorePaymentSources$PaymentSourcesState$Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handlePaymentSourcesFetchStart() {
        this.paymentSourcesState = StorePaymentSources$PaymentSourcesState$Loading.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handlePaymentSourcesFetchSuccess(List<? extends ModelPaymentSource> paymentSources) {
        this.paymentSourcesState = new StorePaymentSources$PaymentSourcesState$Loaded(paymentSources);
        markChanged();
    }

    public final void fetchPaymentSources() {
        this.dispatcher.schedule(new StorePaymentSources$fetchPaymentSources$1(this));
    }

    /* JADX INFO: renamed from: getPaymentSourcesState, reason: from getter */
    public final StorePaymentSources$PaymentSourcesState getPaymentSourcesStateSnapshot() {
        return this.paymentSourcesStateSnapshot;
    }

    @StoreThread
    public final void handlePreLogout() {
        this.paymentSourcesState = StorePaymentSources$PaymentSourcesState$Unfetched.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleUserPaymentSourcesUpdate() {
        fetchPaymentSources();
    }

    public final Observable<StorePaymentSources$PaymentSourcesState> observePaymentSourcesState() {
        Observable<StorePaymentSources$PaymentSourcesState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StorePaymentSources$observePaymentSourcesState$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesStateCopy = this.paymentSourcesState;
        if (storePaymentSources$PaymentSourcesStateCopy instanceof StorePaymentSources$PaymentSourcesState$Loaded) {
            StorePaymentSources$PaymentSourcesState$Loaded storePaymentSources$PaymentSourcesState$Loaded = (StorePaymentSources$PaymentSourcesState$Loaded) storePaymentSources$PaymentSourcesStateCopy;
            storePaymentSources$PaymentSourcesStateCopy = storePaymentSources$PaymentSourcesState$Loaded.copy(new ArrayList(storePaymentSources$PaymentSourcesState$Loaded.getPaymentSources()));
        } else if (!m.areEqual(storePaymentSources$PaymentSourcesStateCopy, StorePaymentSources$PaymentSourcesState$Loading.INSTANCE) && !m.areEqual(storePaymentSources$PaymentSourcesStateCopy, StorePaymentSources$PaymentSourcesState$Failure.INSTANCE) && !m.areEqual(storePaymentSources$PaymentSourcesStateCopy, StorePaymentSources$PaymentSourcesState$Unfetched.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.paymentSourcesStateSnapshot = storePaymentSources$PaymentSourcesStateCopy;
    }

    public StorePaymentSources(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        StorePaymentSources$PaymentSourcesState$Unfetched storePaymentSources$PaymentSourcesState$Unfetched = StorePaymentSources$PaymentSourcesState$Unfetched.INSTANCE;
        this.paymentSourcesState = storePaymentSources$PaymentSourcesState$Unfetched;
        this.paymentSourcesStateSnapshot = storePaymentSources$PaymentSourcesState$Unfetched;
    }
}
