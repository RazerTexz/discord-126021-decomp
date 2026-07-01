package com.discord.stores;

import com.android.billingclient.api.SkuDetails;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.billing.GooglePlayInAppSkus;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlaySkuDetails extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private StoreGooglePlaySkuDetails$State skuState;
    private StoreGooglePlaySkuDetails$State skuStateSnapshot;

    public StoreGooglePlaySkuDetails(ObservationDeck observationDeck, Dispatcher dispatcher) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        StoreGooglePlaySkuDetails$State$Uninitialized storeGooglePlaySkuDetails$State$Uninitialized = StoreGooglePlaySkuDetails$State$Uninitialized.INSTANCE;
        this.skuState = storeGooglePlaySkuDetails$State$Uninitialized;
        this.skuStateSnapshot = storeGooglePlaySkuDetails$State$Uninitialized;
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final StoreGooglePlaySkuDetails$State getSkuStateSnapshot() {
        return this.skuStateSnapshot;
    }

    public final void handleError() {
        this.dispatcher.schedule(new StoreGooglePlaySkuDetails$handleError$1(this));
    }

    @StoreThread
    public final void handleFetchError() {
        this.skuState = StoreGooglePlaySkuDetails$State$Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleFetchSuccess(List<? extends SkuDetails> newSkuDetails) {
        m.checkNotNullParameter(newSkuDetails, "newSkuDetails");
        StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State = this.skuState;
        if (!(storeGooglePlaySkuDetails$State instanceof StoreGooglePlaySkuDetails$State$Loaded)) {
            storeGooglePlaySkuDetails$State = null;
        }
        StoreGooglePlaySkuDetails$State$Loaded storeGooglePlaySkuDetails$State$Loaded = (StoreGooglePlaySkuDetails$State$Loaded) storeGooglePlaySkuDetails$State;
        Map<String, SkuDetails> skuDetails = storeGooglePlaySkuDetails$State$Loaded != null ? storeGooglePlaySkuDetails$State$Loaded.getSkuDetails() : null;
        if (skuDetails == null) {
            skuDetails = h0.emptyMap();
        }
        Map<String, ? extends SkuDetails> mutableMap = h0.toMutableMap(skuDetails);
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(newSkuDetails, 10)), 16));
        for (Object obj : newSkuDetails) {
            linkedHashMap.put(((SkuDetails) obj).d(), obj);
        }
        mutableMap.putAll(linkedHashMap);
        GooglePlayInAppSkus.INSTANCE.populateSkuDetails(mutableMap);
        this.skuState = new StoreGooglePlaySkuDetails$State$Loaded(mutableMap);
        markChanged();
    }

    public final Observable<StoreGooglePlaySkuDetails$State> observeState() {
        Observable<StoreGooglePlaySkuDetails$State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGooglePlaySkuDetails$observeState$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$StateCopy = this.skuState;
        if (storeGooglePlaySkuDetails$StateCopy instanceof StoreGooglePlaySkuDetails$State$Loaded) {
            StoreGooglePlaySkuDetails$State$Loaded storeGooglePlaySkuDetails$State$Loaded = (StoreGooglePlaySkuDetails$State$Loaded) storeGooglePlaySkuDetails$StateCopy;
            storeGooglePlaySkuDetails$StateCopy = storeGooglePlaySkuDetails$State$Loaded.copy(new HashMap(storeGooglePlaySkuDetails$State$Loaded.getSkuDetails()));
        } else if (!m.areEqual(storeGooglePlaySkuDetails$StateCopy, StoreGooglePlaySkuDetails$State$Uninitialized.INSTANCE) && !m.areEqual(storeGooglePlaySkuDetails$StateCopy, StoreGooglePlaySkuDetails$State$Failure.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.skuStateSnapshot = storeGooglePlaySkuDetails$StateCopy;
    }

    public final void updateSkuDetails(List<? extends SkuDetails> skuDetails) {
        m.checkNotNullParameter(skuDetails, "skuDetails");
        this.dispatcher.schedule(new StoreGooglePlaySkuDetails$updateSkuDetails$1(this, skuDetails));
    }
}
