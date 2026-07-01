package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelEntitlement;
import com.discord.restapi.RestAPIInterface$DefaultImpls;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreEntitlements.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEntitlements extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, List<ModelEntitlement>> entitlementMap;
    private Map<Long, ? extends List<ModelEntitlement>> giftEntitlementMap;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private StoreEntitlements$State state;
    private StoreEntitlements$State stateSnapshot;

    public /* synthetic */ StoreEntitlements(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, observationDeck, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreEntitlements storeEntitlements) {
        return storeEntitlements.dispatcher;
    }

    public static final /* synthetic */ StoreEntitlements$State access$getStateSnapshot$p(StoreEntitlements storeEntitlements) {
        return storeEntitlements.stateSnapshot;
    }

    public static final /* synthetic */ void access$setStateSnapshot$p(StoreEntitlements storeEntitlements, StoreEntitlements$State storeEntitlements$State) {
        storeEntitlements.stateSnapshot = storeEntitlements$State;
    }

    public final void fetchMyEntitlementsForApplication(long applicationId) {
        this.dispatcher.schedule(new StoreEntitlements$fetchMyEntitlementsForApplication$1(this));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPIInterface$DefaultImpls.getMyEntitlements$default(this.restAPI, applicationId, false, 2, null), false, 1, null), StoreEntitlements.class, (Context) null, (Function1) null, new StoreEntitlements$fetchMyEntitlementsForApplication$2(this), (Function0) null, (Function0) null, new StoreEntitlements$fetchMyEntitlementsForApplication$3(this, applicationId), 54, (Object) null);
    }

    public final void fetchMyGiftEntitlements() {
        this.dispatcher.schedule(new StoreEntitlements$fetchMyGiftEntitlements$1(this));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifts(), false, 1, null), StoreEntitlements.class, (Context) null, (Function1) null, new StoreEntitlements$fetchMyGiftEntitlements$2(this), (Function0) null, (Function0) null, new StoreEntitlements$fetchMyGiftEntitlements$3(this), 54, (Object) null);
    }

    /* JADX INFO: renamed from: getEntitlementState, reason: from getter */
    public final StoreEntitlements$State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @StoreThread
    public final void handleFetchEntitlementsSuccess(long applicationId, List<ModelEntitlement> entitlements) {
        m.checkNotNullParameter(entitlements, "entitlements");
        this.entitlementMap.put(Long.valueOf(applicationId), entitlements);
        this.state = new StoreEntitlements$State$Loaded(this.giftEntitlementMap, this.entitlementMap);
        markChanged();
    }

    @StoreThread
    public final void handleFetchError() {
        this.state = StoreEntitlements$State$Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleFetchGiftsSuccess(List<ModelEntitlement> giftEntitlements) {
        m.checkNotNullParameter(giftEntitlements, "giftEntitlements");
        HashMap map = new HashMap();
        for (ModelEntitlement modelEntitlement : giftEntitlements) {
            List arrayList = (List) map.get(Long.valueOf(modelEntitlement.getSkuId()));
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(modelEntitlement);
            map.put(Long.valueOf(modelEntitlement.getSkuId()), arrayList);
        }
        this.giftEntitlementMap = map;
        this.state = new StoreEntitlements$State$Loaded(map, this.entitlementMap);
        markChanged();
    }

    @StoreThread
    public final void handleFetchingState() {
        this.state = StoreEntitlements$State$Loading.INSTANCE;
        markChanged();
    }

    public final Observable<StoreEntitlements$State> observeEntitlementState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreEntitlements$observeEntitlementState$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.stateSnapshot = this.state.deepCopy();
    }

    public StoreEntitlements(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.giftEntitlementMap = h0.emptyMap();
        this.entitlementMap = new LinkedHashMap();
        StoreEntitlements$State$Loading storeEntitlements$State$Loading = StoreEntitlements$State$Loading.INSTANCE;
        this.state = storeEntitlements$State$Loading;
        this.stateSnapshot = storeEntitlements$State$Loading;
    }
}
