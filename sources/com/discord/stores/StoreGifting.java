package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.restapi.RestAPIParams$GenerateGiftCode;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting {
    public static final StoreGifting$Companion Companion = new StoreGifting$Companion(null);
    private final Dispatcher dispatcher;
    private HashMap<String, StoreGifting$GiftState> knownGifts;
    private final BehaviorSubject<Map<String, StoreGifting$GiftState>> knownGiftsSubject;

    public StoreGifting(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.knownGifts = new HashMap<>();
        this.knownGiftsSubject = BehaviorSubject.l0(h0.emptyMap());
    }

    public static final /* synthetic */ void access$clearGiftsForSku(StoreGifting storeGifting, long j, Long l) {
        storeGifting.clearGiftsForSku(j, l);
    }

    public static final /* synthetic */ void access$fetchGift(StoreGifting storeGifting, String str) {
        storeGifting.fetchGift(str);
    }

    public static final /* synthetic */ void access$removeGiftCode(StoreGifting storeGifting, String str) {
        storeGifting.removeGiftCode(str);
    }

    public static final /* synthetic */ void access$setGifts(StoreGifting storeGifting, String str, StoreGifting$GiftState storeGifting$GiftState) {
        storeGifting.setGifts(str, storeGifting$GiftState);
    }

    @StoreThread
    private final void clearGiftsForSku(long skuId, Long subscriptionPlanId) {
        HashMap<String, StoreGifting$GiftState> map = this.knownGifts;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<String, StoreGifting$GiftState> map$Entry : map.entrySet()) {
            StoreGifting$GiftState value = map$Entry.getValue();
            boolean z2 = true;
            if (value instanceof StoreGifting$GiftState$Resolved) {
                StoreGifting$GiftState$Resolved storeGifting$GiftState$Resolved = (StoreGifting$GiftState$Resolved) value;
                if (storeGifting$GiftState$Resolved.getGift().getSkuId() == skuId && subscriptionPlanId != null && !(!m.areEqual(storeGifting$GiftState$Resolved.getGift().getSubscriptionPlanId(), subscriptionPlanId))) {
                    z2 = false;
                }
            }
            if (z2) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        this.knownGifts = new HashMap<>(linkedHashMap);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    @StoreThread
    private final void fetchGift(String giftCode) {
        if (this.knownGifts.containsKey(giftCode) && !(this.knownGifts.get(giftCode) instanceof StoreGifting$GiftState$LoadFailed)) {
            if (!(this.knownGifts.get(giftCode) instanceof StoreGifting$GiftState$Resolved)) {
                return;
            }
            StoreGifting$GiftState storeGifting$GiftState = this.knownGifts.get(giftCode);
            Objects.requireNonNull(storeGifting$GiftState, "null cannot be cast to non-null type com.discord.stores.StoreGifting.GiftState.Resolved");
            if (((StoreGifting$GiftState$Resolved) storeGifting$GiftState).getGift().isComplete()) {
                return;
            }
        }
        setGifts(giftCode, StoreGifting$GiftState$Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().resolveGiftCode(giftCode, true, true), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new StoreGifting$fetchGift$2(this, giftCode), (Function0) null, (Function0) null, new StoreGifting$fetchGift$1(this, giftCode), 54, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void generateGiftCode$default(StoreGifting storeGifting, long j, Long l, Function1 function1, Function1 function2, int i, Object obj) {
        storeGifting.generateGiftCode(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function2);
    }

    @StoreThread
    private final void removeGiftCode(String code) {
        this.knownGifts.remove(code);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    @StoreThread
    private final void setGifts(String code, StoreGifting$GiftState giftState) {
        this.knownGifts.put(code, giftState);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    public final void acceptGift(ModelGift gift) {
        m.checkNotNullParameter(gift, "gift");
        this.dispatcher.schedule(new StoreGifting$acceptGift$1(this, gift));
    }

    public final void fetchMyGiftsForSku(long skuId, Long planId) {
        String strMakeComboId = Companion.makeComboId(skuId, planId);
        if (!this.knownGifts.containsKey(strMakeComboId) || (this.knownGifts.get(strMakeComboId) instanceof StoreGifting$GiftState$LoadFailed)) {
            this.dispatcher.schedule(new StoreGifting$fetchMyGiftsForSku$1(this, strMakeComboId));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().resolveSkuIdGift(skuId, planId), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new StoreGifting$fetchMyGiftsForSku$2(this, strMakeComboId), (Function0) null, (Function0) null, new StoreGifting$fetchMyGiftsForSku$3(this, strMakeComboId, skuId, planId), 54, (Object) null);
        }
    }

    public final void generateGiftCode(long skuId, Long planId, Function1<? super ModelGift, Unit> onSuccess, Function1<? super Error, Unit> onError) {
        String strMakeComboId = Companion.makeComboId(skuId, planId);
        if (this.knownGifts.get(strMakeComboId) instanceof StoreGifting$GiftState$Loading) {
            return;
        }
        this.dispatcher.schedule(new StoreGifting$generateGiftCode$1(this, strMakeComboId));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().generateGiftCode(new RestAPIParams$GenerateGiftCode(skuId, planId)), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new StoreGifting$generateGiftCode$2(this, strMakeComboId, onError), (Function0) null, (Function0) null, new StoreGifting$generateGiftCode$3(this, strMakeComboId, onSuccess), 54, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final HashMap<String, StoreGifting$GiftState> getKnownGifts() {
        return this.knownGifts;
    }

    public final Observable<List<ModelGift>> getMyResolvedGifts(long userId) {
        Observable observableG = this.knownGiftsSubject.G(new StoreGifting$getMyResolvedGifts$1(userId));
        m.checkNotNullExpressionValue(observableG, "knownGiftsSubject\n      …              }\n        }");
        return observableG;
    }

    @StoreThread
    public final void handlePreLogout() {
        this.knownGifts.clear();
    }

    public final Observable<StoreGifting$GiftState> requestGift(String giftCode) {
        m.checkNotNullParameter(giftCode, "giftCode");
        this.dispatcher.schedule(new StoreGifting$requestGift$1(this, giftCode));
        Observable<StoreGifting$GiftState> observableR = this.knownGiftsSubject.G(new StoreGifting$requestGift$2(giftCode)).r();
        m.checkNotNullExpressionValue(observableR, "knownGiftsSubject\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final void revokeGiftCode(ModelGift gift) {
        m.checkNotNullParameter(gift, "gift");
        if (this.knownGifts.containsKey(gift.getCode()) && (this.knownGifts.get(gift.getCode()) instanceof StoreGifting$GiftState$Revoking)) {
            return;
        }
        this.dispatcher.schedule(new StoreGifting$revokeGiftCode$1(this, gift));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().revokeGiftCode(gift.getCode()), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new StoreGifting$revokeGiftCode$2(this, gift), (Function0) null, (Function0) null, new StoreGifting$revokeGiftCode$3(this, gift), 54, (Object) null);
    }

    public final void setKnownGifts(HashMap<String, StoreGifting$GiftState> map) {
        m.checkNotNullParameter(map, "<set-?>");
        this.knownGifts = map;
    }
}
