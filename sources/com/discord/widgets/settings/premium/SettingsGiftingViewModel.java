package com.discord.widgets.settings.premium;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.api.premium.OutboundPromotion;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelUserSettings;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreEntitlements$State;
import com.discord.stores.StoreEntitlements$State$Failure;
import com.discord.stores.StoreEntitlements$State$Loaded;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreGifting$GiftState;
import com.discord.stores.StoreGifting$GiftState$Invalid;
import com.discord.stores.StoreGifting$GiftState$LoadFailed;
import com.discord.stores.StoreGifting$GiftState$Loading;
import com.discord.stores.StoreGifting$GiftState$RedeemedFailed;
import com.discord.stores.StoreGifting$GiftState$Redeeming;
import com.discord.stores.StoreGifting$GiftState$Resolved;
import com.discord.stores.StoreGifting$GiftState$Revoking;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlayPurchases$Event;
import com.discord.stores.StoreGooglePlayPurchases$Event$PurchaseQueryFailure;
import com.discord.stores.StoreGooglePlayPurchases$Event$PurchaseQuerySuccess;
import com.discord.stores.StoreGooglePlayPurchases$QueryState;
import com.discord.stores.StoreGooglePlayPurchases$QueryState$InProgress;
import com.discord.stores.StoreGooglePlayPurchases$QueryState$NotInProgress;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreOutboundPromotions$State;
import com.discord.stores.StoreOutboundPromotions$State$Failed;
import com.discord.stores.StoreOutboundPromotions$State$Loaded;
import com.discord.stores.StoreOutboundPromotions$State$Loading;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel extends d0<SettingsGiftingViewModel$ViewState> {
    public static final SettingsGiftingViewModel$Companion Companion = new SettingsGiftingViewModel$Companion(null);
    private final BehaviorSubject<List<ClaimedOutboundPromotion>> claimedPromotionsSubject;
    private final PublishSubject<SettingsGiftingViewModel$Event> eventSubject;
    private final PublishSubject<SettingsGiftingViewModel$GiftPurchaseEvent> giftPurchaseEventSubject;
    private Function1<? super String, Unit> onGiftCodeResolved;
    private AtomicBoolean shouldCheckClaimedPromos;
    private final StoreEntitlements storeEntitlements;
    private final StoreGifting storeGifting;
    private final StoreOutboundPromotions storeOutboundPromotions;
    private final BehaviorSubject<SettingsGiftingViewModel$StoreState> storeStateSubject;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private final CompositeSubscription subscriptions;

    public SettingsGiftingViewModel() {
        this(null, null, null, null, null, null, null, Opcodes.LAND, null);
    }

    public /* synthetic */ SettingsGiftingViewModel(StoreEntitlements storeEntitlements, StoreGifting storeGifting, StoreUserSettingsSystem storeUserSettingsSystem, StoreOutboundPromotions storeOutboundPromotions, StoreGooglePlayPurchases storeGooglePlayPurchases, GooglePlayBillingManager googlePlayBillingManager, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getEntitlements() : storeEntitlements, (i & 2) != 0 ? StoreStream.Companion.getGifting() : storeGifting, (i & 4) != 0 ? StoreStream.Companion.getUserSettingsSystem() : storeUserSettingsSystem, (i & 8) != 0 ? StoreStream.Companion.getOutboundPromotions() : storeOutboundPromotions, (i & 16) != 0 ? StoreStream.Companion.getGooglePlayPurchases() : storeGooglePlayPurchases, (i & 32) != 0 ? GooglePlayBillingManager.INSTANCE : googlePlayBillingManager, (i & 64) != 0 ? SettingsGiftingViewModel$Companion.access$observeStores(Companion) : observable);
    }

    public static final /* synthetic */ SettingsGiftingViewModel$GiftAndPromoData access$combineData(SettingsGiftingViewModel settingsGiftingViewModel, SettingsGiftingViewModel$StoreState settingsGiftingViewModel$StoreState, List list) {
        return settingsGiftingViewModel.combineData(settingsGiftingViewModel$StoreState, list);
    }

    public static final /* synthetic */ PublishSubject access$getGiftPurchaseEventSubject$p(SettingsGiftingViewModel settingsGiftingViewModel) {
        return settingsGiftingViewModel.giftPurchaseEventSubject;
    }

    public static final /* synthetic */ AtomicBoolean access$getShouldCheckClaimedPromos$p(SettingsGiftingViewModel settingsGiftingViewModel) {
        return settingsGiftingViewModel.shouldCheckClaimedPromos;
    }

    public static final /* synthetic */ StoreEntitlements access$getStoreEntitlements$p(SettingsGiftingViewModel settingsGiftingViewModel) {
        return settingsGiftingViewModel.storeEntitlements;
    }

    public static final /* synthetic */ CompositeSubscription access$getSubscriptions$p(SettingsGiftingViewModel settingsGiftingViewModel) {
        return settingsGiftingViewModel.subscriptions;
    }

    public static final /* synthetic */ void access$handleAsyncData(SettingsGiftingViewModel settingsGiftingViewModel, SettingsGiftingViewModel$GiftAndPromoData settingsGiftingViewModel$GiftAndPromoData) {
        settingsGiftingViewModel.handleAsyncData(settingsGiftingViewModel$GiftAndPromoData);
    }

    public static final /* synthetic */ void access$handleGooglePlayPurchaseEvent(SettingsGiftingViewModel settingsGiftingViewModel, StoreGooglePlayPurchases$Event storeGooglePlayPurchases$Event) {
        settingsGiftingViewModel.handleGooglePlayPurchaseEvent(storeGooglePlayPurchases$Event);
    }

    public static final /* synthetic */ void access$handleGooglePlayQueryStateUpdate(SettingsGiftingViewModel settingsGiftingViewModel, StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState) {
        settingsGiftingViewModel.handleGooglePlayQueryStateUpdate(storeGooglePlayPurchases$QueryState);
    }

    public static final /* synthetic */ void access$maybeCheckClaimedPromos(SettingsGiftingViewModel settingsGiftingViewModel, boolean z2) {
        settingsGiftingViewModel.maybeCheckClaimedPromos(z2);
    }

    public static final /* synthetic */ void access$onHandleGiftCode(SettingsGiftingViewModel settingsGiftingViewModel, StoreGifting$GiftState storeGifting$GiftState) {
        settingsGiftingViewModel.onHandleGiftCode(storeGifting$GiftState);
    }

    public static final /* synthetic */ void access$setShouldCheckClaimedPromos$p(SettingsGiftingViewModel settingsGiftingViewModel, AtomicBoolean atomicBoolean) {
        settingsGiftingViewModel.shouldCheckClaimedPromos = atomicBoolean;
    }

    @MainThread
    private final SettingsGiftingViewModel$ViewState buildViewState(StoreEntitlements$State entitlementState, SettingsGiftingViewModel$ResolvingGiftState resolvingGiftState, Map<Long, ? extends List<ModelGift>> myPurchasedGifts, SettingsGiftingViewModel$OutboundPromoData outboundPromoData) {
        Set<Long> setEmptySet;
        if (!(entitlementState instanceof StoreEntitlements$State$Loaded) || !(outboundPromoData instanceof SettingsGiftingViewModel$OutboundPromoData$Loaded)) {
            return entitlementState instanceof StoreEntitlements$State$Failure ? SettingsGiftingViewModel$ViewState$Failure.INSTANCE : SettingsGiftingViewModel$ViewState$Loading.INSTANCE;
        }
        SettingsGiftingViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGiftingViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded = (SettingsGiftingViewModel$ViewState$Loaded) viewState;
        if (settingsGiftingViewModel$ViewState$Loaded == null || (setEmptySet = settingsGiftingViewModel$ViewState$Loaded.getExpandedSkuOrPlanIds()) == null) {
            setEmptySet = n0.emptySet();
        }
        Set<Long> set = setEmptySet;
        SettingsGiftingViewModel$ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof SettingsGiftingViewModel$ViewState$Loaded)) {
            viewState2 = null;
        }
        SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded2 = (SettingsGiftingViewModel$ViewState$Loaded) viewState2;
        return new SettingsGiftingViewModel$ViewState$Loaded(((StoreEntitlements$State$Loaded) entitlementState).getGiftableEntitlements(), resolvingGiftState, set, ((SettingsGiftingViewModel$OutboundPromoData$Loaded) outboundPromoData).getOutboundPromos(), myPurchasedGifts, settingsGiftingViewModel$ViewState$Loaded2 != null ? settingsGiftingViewModel$ViewState$Loaded2.getLastCopiedCode() : null);
    }

    private final SettingsGiftingViewModel$GiftAndPromoData combineData(SettingsGiftingViewModel$StoreState storeState, List<ClaimedOutboundPromotion> claimedPromos) {
        SettingsGiftingViewModel$ResolvingGiftState resolvingGiftState;
        SettingsGiftingViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGiftingViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded = (SettingsGiftingViewModel$ViewState$Loaded) viewState;
        if (settingsGiftingViewModel$ViewState$Loaded == null || (resolvingGiftState = settingsGiftingViewModel$ViewState$Loaded.getResolvingGiftState()) == null) {
            resolvingGiftState = SettingsGiftingViewModel$ResolvingGiftState$NotResolving.INSTANCE;
        }
        SettingsGiftingViewModel$ResolvingGiftState settingsGiftingViewModel$ResolvingGiftState = resolvingGiftState;
        StoreEntitlements$State entitlementState = storeState.getEntitlementState();
        StoreOutboundPromotions$State outboundPromoState = storeState.getOutboundPromoState();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (entitlementState instanceof StoreEntitlements$State$Loaded) {
            for (ModelGift modelGift : storeState.getMyResolvedGifts()) {
                Long subscriptionPlanId = modelGift.getSubscriptionPlanId();
                long jLongValue = subscriptionPlanId != null ? subscriptionPlanId.longValue() : modelGift.getSkuId();
                if (!linkedHashMap.containsKey(Long.valueOf(jLongValue))) {
                    linkedHashMap.put(Long.valueOf(jLongValue), new ArrayList());
                }
                List list = (List) linkedHashMap.get(Long.valueOf(jLongValue));
                if (list != null) {
                    list.add(modelGift);
                }
            }
        }
        return new SettingsGiftingViewModel$GiftAndPromoData(entitlementState, settingsGiftingViewModel$ResolvingGiftState, linkedHashMap, outboundPromoState, claimedPromos);
    }

    private final String getPromoImageUrl(long promoId) {
        String str = m.areEqual(this.storeUserSettingsSystem.getTheme(), ModelUserSettings.THEME_LIGHT) ? "logo-light" : "logo-dark";
        String str2 = BuildConfig.HOST_CDN;
        if (!(BuildConfig.HOST_CDN.length() > 0)) {
            str2 = null;
        }
        if (str2 == null) {
            str2 = BuildConfig.HOST_API;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("/promotions/");
        sb.append(promoId);
        sb.append(MentionUtilsKt.SLASH_CHAR);
        return a.J(sb, str, "?size=256");
    }

    private final List<SettingsGiftingViewModel$OutboundPromoItem> getPromos(List<OutboundPromotion> validActivePromos, List<ClaimedOutboundPromotion> claimedPromos) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (OutboundPromotion outboundPromotion : validActivePromos) {
            SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem = new SettingsGiftingViewModel$OutboundPromoItem(new ClaimStatus$Unclaimed(outboundPromotion.getId(), outboundPromotion.getEndDate()), outboundPromotion.getId(), outboundPromotion.getOutboundTitle(), outboundPromotion.getOutboundTermsAndConditions(), getPromoImageUrl(outboundPromotion.getId()));
            linkedHashMap.put(Long.valueOf(settingsGiftingViewModel$OutboundPromoItem.getId()), settingsGiftingViewModel$OutboundPromoItem);
        }
        for (ClaimedOutboundPromotion claimedOutboundPromotion : claimedPromos) {
            SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem2 = new SettingsGiftingViewModel$OutboundPromoItem(new ClaimStatus$Claimed(claimedOutboundPromotion.getPromotion().getId(), claimedOutboundPromotion.getCode(), claimedOutboundPromotion.getPromotion().getOutboundRedemptionModalBody(), claimedOutboundPromotion.d(), claimedOutboundPromotion.c()), claimedOutboundPromotion.getPromotion().getId(), claimedOutboundPromotion.getPromotion().getOutboundTitle(), claimedOutboundPromotion.getPromotion().getOutboundTermsAndConditions(), getPromoImageUrl(claimedOutboundPromotion.getPromotion().getId()));
            linkedHashMap.put(Long.valueOf(settingsGiftingViewModel$OutboundPromoItem2.getId()), settingsGiftingViewModel$OutboundPromoItem2);
        }
        return u.toList(linkedHashMap.values());
    }

    @MainThread
    private final void handleAsyncData(SettingsGiftingViewModel$GiftAndPromoData data) {
        SettingsGiftingViewModel$OutboundPromoData settingsGiftingViewModel$OutboundPromoData$Loaded;
        StoreOutboundPromotions$State outboundPromoState = data.getOutboundPromoState();
        if (outboundPromoState instanceof StoreOutboundPromotions$State$Loaded) {
            settingsGiftingViewModel$OutboundPromoData$Loaded = new SettingsGiftingViewModel$OutboundPromoData$Loaded(getPromos(((StoreOutboundPromotions$State$Loaded) outboundPromoState).getValidActivePromotions(), data.getClaimedOutboundPromotions()));
        } else if (outboundPromoState instanceof StoreOutboundPromotions$State$Failed) {
            settingsGiftingViewModel$OutboundPromoData$Loaded = new SettingsGiftingViewModel$OutboundPromoData$Loaded(n.emptyList());
        } else {
            if (!(outboundPromoState instanceof StoreOutboundPromotions$State$Loading)) {
                throw new NoWhenBranchMatchedException();
            }
            settingsGiftingViewModel$OutboundPromoData$Loaded = SettingsGiftingViewModel$OutboundPromoData$Loading.INSTANCE;
        }
        SettingsGiftingViewModel$ViewState settingsGiftingViewModel$ViewStateBuildViewState = buildViewState(data.getEntitlementState(), data.getResolvingGiftState(), data.getMyPurchasedGifts(), settingsGiftingViewModel$OutboundPromoData$Loaded);
        if (settingsGiftingViewModel$ViewStateBuildViewState instanceof SettingsGiftingViewModel$ViewState$Loaded) {
            this.storeOutboundPromotions.markSeen();
        }
        updateViewState(settingsGiftingViewModel$ViewStateBuildViewState);
    }

    private final void handleGooglePlayPurchaseEvent(StoreGooglePlayPurchases$Event event) {
        if (!(event instanceof StoreGooglePlayPurchases$Event$PurchaseQuerySuccess)) {
            if (event instanceof StoreGooglePlayPurchases$Event$PurchaseQueryFailure) {
                PublishSubject<SettingsGiftingViewModel$GiftPurchaseEvent> publishSubject = this.giftPurchaseEventSubject;
                publishSubject.k.onNext(new SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase(2131887073));
                return;
            }
            return;
        }
        StoreGooglePlayPurchases$Event$PurchaseQuerySuccess storeGooglePlayPurchases$Event$PurchaseQuerySuccess = (StoreGooglePlayPurchases$Event$PurchaseQuerySuccess) event;
        if (storeGooglePlayPurchases$Event$PurchaseQuerySuccess.getGiftCode() != null) {
            this.storeEntitlements.fetchMyGiftEntitlements();
            PublishSubject<SettingsGiftingViewModel$GiftPurchaseEvent> publishSubject2 = this.giftPurchaseEventSubject;
            publishSubject2.k.onNext(new SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase(storeGooglePlayPurchases$Event$PurchaseQuerySuccess.getNewSkuName(), storeGooglePlayPurchases$Event$PurchaseQuerySuccess.getGiftCode()));
            return;
        }
        StoreGifting storeGifting = this.storeGifting;
        Long skuId = storeGooglePlayPurchases$Event$PurchaseQuerySuccess.getSkuId();
        m.checkNotNull(skuId);
        storeGifting.generateGiftCode(skuId.longValue(), storeGooglePlayPurchases$Event$PurchaseQuerySuccess.getSubscriptionPlanId(), new SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$2(this, event), new SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$1(this));
    }

    private final void handleGooglePlayQueryStateUpdate(StoreGooglePlayPurchases$QueryState queryState) {
        if (m.areEqual(queryState, StoreGooglePlayPurchases$QueryState$InProgress.INSTANCE)) {
            PublishSubject<SettingsGiftingViewModel$GiftPurchaseEvent> publishSubject = this.giftPurchaseEventSubject;
            publishSubject.k.onNext(SettingsGiftingViewModel$GiftPurchaseEvent$StartGiftPurchase.INSTANCE);
        } else if (m.areEqual(queryState, StoreGooglePlayPurchases$QueryState$NotInProgress.INSTANCE)) {
            PublishSubject<SettingsGiftingViewModel$GiftPurchaseEvent> publishSubject2 = this.giftPurchaseEventSubject;
            publishSubject2.k.onNext(SettingsGiftingViewModel$GiftPurchaseEvent$NotInProgress.INSTANCE);
        }
    }

    private final void maybeCheckClaimedPromos(boolean isUserPremium) {
        if (this.shouldCheckClaimedPromos.compareAndSet(true, false)) {
            if (!isUserPremium) {
                this.claimedPromotionsSubject.onNext(n.emptyList());
                return;
            }
            Observable observableM = ObservableExtensionsKt.restSubscribeOn$default(this.storeOutboundPromotions.fetchClaimedOutboundPromotions(), false, 1, null).t(new SettingsGiftingViewModel$maybeCheckClaimedPromos$1(this)).M(SettingsGiftingViewModel$maybeCheckClaimedPromos$2.INSTANCE);
            m.checkNotNullExpressionValue(observableM, "storeOutboundPromotions.…rorReturn { emptyList() }");
            ObservableExtensionsKt.appSubscribe$default(observableM, SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsGiftingViewModel$maybeCheckClaimedPromos$3(this.claimedPromotionsSubject), 62, (Object) null);
        }
    }

    @MainThread
    private final void onHandleGiftCode(StoreGifting$GiftState giftState) {
        SettingsGiftingViewModel$ViewState settingsGiftingViewModel$ViewStateBuildViewState;
        ModelGift gift;
        SettingsGiftingViewModel$ViewState viewState = getViewState();
        ModelGift gift2 = null;
        if (!(viewState instanceof SettingsGiftingViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded = (SettingsGiftingViewModel$ViewState$Loaded) viewState;
        if (settingsGiftingViewModel$ViewState$Loaded != null) {
            StoreEntitlements$State$Loaded storeEntitlements$State$Loaded = new StoreEntitlements$State$Loaded(settingsGiftingViewModel$ViewState$Loaded.getMyEntitlements(), h0.emptyMap());
            SettingsGiftingViewModel$OutboundPromoData$Loaded settingsGiftingViewModel$OutboundPromoData$Loaded = new SettingsGiftingViewModel$OutboundPromoData$Loaded(settingsGiftingViewModel$ViewState$Loaded.getOutboundPromos());
            if ((giftState instanceof StoreGifting$GiftState$Loading) || (giftState instanceof StoreGifting$GiftState$Redeeming)) {
                settingsGiftingViewModel$ViewStateBuildViewState = buildViewState(storeEntitlements$State$Loaded, SettingsGiftingViewModel$ResolvingGiftState$Resolving.INSTANCE, settingsGiftingViewModel$ViewState$Loaded.getMyPurchasedGifts(), settingsGiftingViewModel$OutboundPromoData$Loaded);
            } else if ((giftState instanceof StoreGifting$GiftState$LoadFailed) || (giftState instanceof StoreGifting$GiftState$RedeemedFailed) || (giftState instanceof StoreGifting$GiftState$Invalid)) {
                settingsGiftingViewModel$ViewStateBuildViewState = buildViewState(storeEntitlements$State$Loaded, SettingsGiftingViewModel$ResolvingGiftState$Error.INSTANCE, settingsGiftingViewModel$ViewState$Loaded.getMyPurchasedGifts(), settingsGiftingViewModel$OutboundPromoData$Loaded);
            } else {
                boolean z2 = giftState instanceof StoreGifting$GiftState$Revoking;
                if (!z2 && !(giftState instanceof StoreGifting$GiftState$Resolved)) {
                    throw new NoWhenBranchMatchedException();
                }
                StoreGifting$GiftState$Resolved storeGifting$GiftState$Resolved = (StoreGifting$GiftState$Resolved) (!(giftState instanceof StoreGifting$GiftState$Resolved) ? null : giftState);
                if (storeGifting$GiftState$Resolved == null || (gift = storeGifting$GiftState$Resolved.getGift()) == null) {
                    if (!z2) {
                        giftState = null;
                    }
                    StoreGifting$GiftState$Revoking storeGifting$GiftState$Revoking = (StoreGifting$GiftState$Revoking) giftState;
                    if (storeGifting$GiftState$Revoking != null) {
                        gift2 = storeGifting$GiftState$Revoking.getGift();
                    }
                } else {
                    gift2 = gift;
                }
                if (gift2 == null) {
                    return;
                }
                if (!gift2.isClaimedByMe()) {
                    this.onGiftCodeResolved.invoke(gift2.getCode());
                }
                settingsGiftingViewModel$ViewStateBuildViewState = buildViewState(storeEntitlements$State$Loaded, SettingsGiftingViewModel$ResolvingGiftState$NotResolving.INSTANCE, settingsGiftingViewModel$ViewState$Loaded.getMyPurchasedGifts(), settingsGiftingViewModel$OutboundPromoData$Loaded);
            }
            updateViewState(settingsGiftingViewModel$ViewStateBuildViewState);
        }
    }

    @MainThread
    public final void handleClaimedPromo(ClaimStatus$Claimed claimedStatus) {
        m.checkNotNullParameter(claimedStatus, "claimedStatus");
        SettingsGiftingViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGiftingViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded = (SettingsGiftingViewModel$ViewState$Loaded) viewState;
        if (settingsGiftingViewModel$ViewState$Loaded != null) {
            List<SettingsGiftingViewModel$OutboundPromoItem> outboundPromos = settingsGiftingViewModel$ViewState$Loaded.getOutboundPromos();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(outboundPromos, 10));
            for (SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItemCopy$default : outboundPromos) {
                if (settingsGiftingViewModel$OutboundPromoItemCopy$default.getId() == claimedStatus.getPromoId()) {
                    settingsGiftingViewModel$OutboundPromoItemCopy$default = SettingsGiftingViewModel$OutboundPromoItem.copy$default(settingsGiftingViewModel$OutboundPromoItemCopy$default, claimedStatus, 0L, null, null, null, 30, null);
                }
                arrayList.add(settingsGiftingViewModel$OutboundPromoItemCopy$default);
            }
            updateViewState(SettingsGiftingViewModel$ViewState$Loaded.copy$default(settingsGiftingViewModel$ViewState$Loaded, null, null, null, arrayList, null, null, 55, null));
        }
    }

    @MainThread
    public final void handleCopyClicked(String giftCode) {
        m.checkNotNullParameter(giftCode, "giftCode");
        SettingsGiftingViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGiftingViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded = (SettingsGiftingViewModel$ViewState$Loaded) viewState;
        if (settingsGiftingViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsGiftingViewModel$ViewState$Loaded.copy$default(settingsGiftingViewModel$ViewState$Loaded, null, null, null, null, null, giftCode, 31, null));
        }
    }

    public final void handlePromoButtonClicked(SettingsGiftingViewModel$OutboundPromoItem promoItem) {
        m.checkNotNullParameter(promoItem, "promoItem");
        PublishSubject<SettingsGiftingViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new SettingsGiftingViewModel$Event$ShowPromoDialog(promoItem.getClaimStatus()));
    }

    public final void handlePromoMoreDetailsClicked(SettingsGiftingViewModel$OutboundPromoItem promoItem) {
        m.checkNotNullParameter(promoItem, "promoItem");
        PublishSubject<SettingsGiftingViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new SettingsGiftingViewModel$Event$ShowPromoBottomSheet(promoItem.getTerms()));
    }

    @MainThread
    public final void handleSkuClicked(long skuId, Long planId) {
        SettingsGiftingViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGiftingViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded = (SettingsGiftingViewModel$ViewState$Loaded) viewState;
        if (settingsGiftingViewModel$ViewState$Loaded != null) {
            Set mutableSet = u.toMutableSet(settingsGiftingViewModel$ViewState$Loaded.getExpandedSkuOrPlanIds());
            long jLongValue = planId != null ? planId.longValue() : skuId;
            if (mutableSet.contains(Long.valueOf(jLongValue))) {
                mutableSet.remove(Long.valueOf(jLongValue));
            } else {
                mutableSet.add(Long.valueOf(jLongValue));
                this.storeGifting.fetchMyGiftsForSku(skuId, planId);
            }
            updateViewState(SettingsGiftingViewModel$ViewState$Loaded.copy$default(settingsGiftingViewModel$ViewState$Loaded, null, null, mutableSet, null, null, null, 59, null));
        }
    }

    public final Observable<SettingsGiftingViewModel$Event> observeEvents() {
        PublishSubject<SettingsGiftingViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final PublishSubject<SettingsGiftingViewModel$GiftPurchaseEvent> observeGiftPurchaseEvents() {
        PublishSubject<SettingsGiftingViewModel$GiftPurchaseEvent> publishSubject = this.giftPurchaseEventSubject;
        m.checkNotNullExpressionValue(publishSubject, "giftPurchaseEventSubject");
        return publishSubject;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        this.subscriptions.b();
    }

    @MainThread
    public final void redeemGiftCode(String giftCode, AppComponent appComponent) {
        m.checkNotNullParameter(giftCode, "giftCode");
        m.checkNotNullParameter(appComponent, "appComponent");
        if (getViewState() instanceof SettingsGiftingViewModel$ViewState$Loaded) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(this.storeGifting.requestGift(giftCode), appComponent, null, 2, null), SettingsGiftingViewModel.class, (Context) null, new SettingsGiftingViewModel$redeemGiftCode$1(this), (Function1) null, (Function0) null, (Function0) null, new SettingsGiftingViewModel$redeemGiftCode$2(this), 58, (Object) null);
        }
    }

    public final void setOnGiftCodeResolved(Function1<? super String, Unit> onGiftCodeResolved) {
        m.checkNotNullParameter(onGiftCodeResolved, "onGiftCodeResolved");
        this.onGiftCodeResolved = onGiftCodeResolved;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGiftingViewModel(StoreEntitlements storeEntitlements, StoreGifting storeGifting, StoreUserSettingsSystem storeUserSettingsSystem, StoreOutboundPromotions storeOutboundPromotions, StoreGooglePlayPurchases storeGooglePlayPurchases, GooglePlayBillingManager googlePlayBillingManager, Observable<SettingsGiftingViewModel$StoreState> observable) {
        super(SettingsGiftingViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(storeEntitlements, "storeEntitlements");
        m.checkNotNullParameter(storeGifting, "storeGifting");
        m.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        m.checkNotNullParameter(storeOutboundPromotions, "storeOutboundPromotions");
        m.checkNotNullParameter(storeGooglePlayPurchases, "storeGooglePlayPurchases");
        m.checkNotNullParameter(googlePlayBillingManager, "gPlayBillingManager");
        m.checkNotNullParameter(observable, "storeObservable");
        this.storeEntitlements = storeEntitlements;
        this.storeGifting = storeGifting;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        this.storeOutboundPromotions = storeOutboundPromotions;
        BehaviorSubject<SettingsGiftingViewModel$StoreState> behaviorSubjectK0 = BehaviorSubject.k0();
        this.storeStateSubject = behaviorSubjectK0;
        BehaviorSubject<List<ClaimedOutboundPromotion>> behaviorSubjectK1 = BehaviorSubject.k0();
        this.claimedPromotionsSubject = behaviorSubjectK1;
        this.shouldCheckClaimedPromos = new AtomicBoolean(true);
        this.giftPurchaseEventSubject = PublishSubject.k0();
        this.eventSubject = PublishSubject.k0();
        this.onGiftCodeResolved = SettingsGiftingViewModel$onGiftCodeResolved$1.INSTANCE;
        this.subscriptions = new CompositeSubscription();
        storeEntitlements.fetchMyGiftEntitlements();
        googlePlayBillingManager.queryPurchases();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeGooglePlayPurchases.observeEvents(), this, null, 2, null), SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsGiftingViewModel$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeGooglePlayPurchases.observeQueryState(), this, null, 2, null), SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsGiftingViewModel$2(this), 62, (Object) null);
        Observable observableU = ObservableExtensionsKt.computationLatest(observable).u(new SettingsGiftingViewModel$3(this));
        m.checkNotNullExpressionValue(observableU, "storeObservable\n        …oreState.isUserPremium) }");
        ObservableExtensionsKt.appSubscribe$default(observableU, SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsGiftingViewModel$4(behaviorSubjectK0), 62, (Object) null);
        m.checkNotNullExpressionValue(behaviorSubjectK0, "storeStateSubject");
        Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(behaviorSubjectK0);
        m.checkNotNullExpressionValue(behaviorSubjectK1, "claimedPromotionsSubject");
        Observable observableR = Observable.j(observableComputationLatest, ObservableExtensionsKt.computationLatest(behaviorSubjectK1), new SettingsGiftingViewModel$sam$rx_functions_Func2$0(new SettingsGiftingViewModel$5(this))).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsGiftingViewModel$6(this), 62, (Object) null);
    }
}
