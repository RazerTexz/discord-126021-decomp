package com.discord.widgets.settings.premium;

import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.api.premium.OutboundPromotion;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.MentionUtilsKt;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func4;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BehaviorSubject<List<ClaimedOutboundPromotion>> claimedPromotionsSubject;
    private final PublishSubject<Event> eventSubject;
    private final PublishSubject<GiftPurchaseEvent> giftPurchaseEventSubject;
    private Function1<? super String, Unit> onGiftCodeResolved;
    private AtomicBoolean shouldCheckClaimedPromos;
    private final StoreEntitlements storeEntitlements;
    private final StoreGifting storeGifting;
    private final StoreOutboundPromotions storeOutboundPromotions;
    private final BehaviorSubject<StoreState> storeStateSubject;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private final CompositeSubscription subscriptions;

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$1 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* synthetic */ class C98731 extends C12236k implements Function1<StoreGooglePlayPurchases.Event, Unit> {
        public C98731(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handleGooglePlayPurchaseEvent", "handleGooglePlayPurchaseEvent(Lcom/discord/stores/StoreGooglePlayPurchases$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreGooglePlayPurchases.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreGooglePlayPurchases.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((SettingsGiftingViewModel) this.receiver).handleGooglePlayPurchaseEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$2 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* synthetic */ class C98742 extends C12236k implements Function1<StoreGooglePlayPurchases.QueryState, Unit> {
        public C98742(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handleGooglePlayQueryStateUpdate", "handleGooglePlayQueryStateUpdate(Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreGooglePlayPurchases.QueryState queryState) {
            invoke2(queryState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreGooglePlayPurchases.QueryState queryState) {
            C12238m.checkNotNullParameter(queryState, "p1");
            ((SettingsGiftingViewModel) this.receiver).handleGooglePlayQueryStateUpdate(queryState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$4 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* synthetic */ class C98764 extends C12236k implements Function1<StoreState, Unit> {
        public C98764(BehaviorSubject behaviorSubject) {
            super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            ((BehaviorSubject) this.receiver).onNext(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$5 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* synthetic */ class C98775 extends C12236k implements Function2<StoreState, List<? extends ClaimedOutboundPromotion>, GiftAndPromoData> {
        public C98775(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(2, settingsGiftingViewModel, SettingsGiftingViewModel.class, "combineData", "combineData(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;Ljava/util/List;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GiftAndPromoData invoke(StoreState storeState, List<? extends ClaimedOutboundPromotion> list) {
            return invoke2(storeState, (List<ClaimedOutboundPromotion>) list);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GiftAndPromoData invoke2(StoreState storeState, List<ClaimedOutboundPromotion> list) {
            C12238m.checkNotNullParameter(storeState, "p1");
            C12238m.checkNotNullParameter(list, "p2");
            return ((SettingsGiftingViewModel) this.receiver).combineData(storeState, list);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$6 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* synthetic */ class C98786 extends C12236k implements Function1<GiftAndPromoData, Unit> {
        public C98786(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handleAsyncData", "handleAsyncData(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GiftAndPromoData giftAndPromoData) {
            invoke2(giftAndPromoData);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GiftAndPromoData giftAndPromoData) {
            C12238m.checkNotNullParameter(giftAndPromoData, "p1");
            ((SettingsGiftingViewModel) this.receiver).handleAsyncData(giftAndPromoData);
        }
    }

    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreEntitlements.State> observableObserveEntitlementState = companion.getEntitlements().observeEntitlementState();
            Observable<R> observableM11099Y = companion.getUsers().observeMeId().m11099Y(new InterfaceC12589b<Long, Observable<? extends List<? extends ModelGift>>>() { // from class: com.discord.widgets.settings.premium.SettingsGiftingViewModel$Companion$observeStores$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends List<ModelGift>> call(Long l) {
                    StoreGifting gifting = StoreStream.INSTANCE.getGifting();
                    C12238m.checkNotNullExpressionValue(l, "meId");
                    return gifting.getMyResolvedGifts(l.longValue());
                }
            });
            Observable<StoreOutboundPromotions.State> observableObserveState = companion.getOutboundPromotions().observeState();
            Observable observableM11083G = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).m11083G(new InterfaceC12589b<MeUser, Boolean>() { // from class: com.discord.widgets.settings.premium.SettingsGiftingViewModel$Companion$observeStores$2
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(MeUser meUser) {
                    UserUtils userUtils = UserUtils.INSTANCE;
                    C12238m.checkNotNullExpressionValue(meUser, "it");
                    return Boolean.valueOf(userUtils.isPremium(meUser));
                }
            });
            final SettingsGiftingViewModel$Companion$observeStores$3 settingsGiftingViewModel$Companion$observeStores$3 = SettingsGiftingViewModel$Companion$observeStores$3.INSTANCE;
            Object obj = settingsGiftingViewModel$Companion$observeStores$3;
            if (settingsGiftingViewModel$Companion$observeStores$3 != null) {
                obj = new Func4() { // from class: com.discord.widgets.settings.premium.SettingsGiftingViewModel$sam$rx_functions_Func4$0
                    @Override // p658rx.functions.Func4
                    public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return settingsGiftingViewModel$Companion$observeStores$3.invoke(obj2, obj3, obj4, obj5);
                    }
                };
            }
            Observable<StoreState> observableM11112r = Observable.m11073h(observableObserveEntitlementState, observableM11099Y, observableObserveState, observableM11083G, (Func4) obj).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n          .co…  .distinctUntilChanged()");
            return observableM11112r;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final /* data */ class ShowPromoBottomSheet extends Event {
            private final String content;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowPromoBottomSheet(String str) {
                super(null);
                C12238m.checkNotNullParameter(str, "content");
                this.content = str;
            }

            public static /* synthetic */ ShowPromoBottomSheet copy$default(ShowPromoBottomSheet showPromoBottomSheet, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showPromoBottomSheet.content;
                }
                return showPromoBottomSheet.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            public final ShowPromoBottomSheet copy(String content) {
                C12238m.checkNotNullParameter(content, "content");
                return new ShowPromoBottomSheet(content);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowPromoBottomSheet) && C12238m.areEqual(this.content, ((ShowPromoBottomSheet) other).content);
                }
                return true;
            }

            public final String getContent() {
                return this.content;
            }

            public int hashCode() {
                String str = this.content;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m822J(C1643a.m833U("ShowPromoBottomSheet(content="), this.content, ")");
            }
        }

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final /* data */ class ShowPromoDialog extends Event {
            private final ClaimStatus claimStatus;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowPromoDialog(ClaimStatus claimStatus) {
                super(null);
                C12238m.checkNotNullParameter(claimStatus, "claimStatus");
                this.claimStatus = claimStatus;
            }

            public static /* synthetic */ ShowPromoDialog copy$default(ShowPromoDialog showPromoDialog, ClaimStatus claimStatus, int i, Object obj) {
                if ((i & 1) != 0) {
                    claimStatus = showPromoDialog.claimStatus;
                }
                return showPromoDialog.copy(claimStatus);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ClaimStatus getClaimStatus() {
                return this.claimStatus;
            }

            public final ShowPromoDialog copy(ClaimStatus claimStatus) {
                C12238m.checkNotNullParameter(claimStatus, "claimStatus");
                return new ShowPromoDialog(claimStatus);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowPromoDialog) && C12238m.areEqual(this.claimStatus, ((ShowPromoDialog) other).claimStatus);
                }
                return true;
            }

            public final ClaimStatus getClaimStatus() {
                return this.claimStatus;
            }

            public int hashCode() {
                ClaimStatus claimStatus = this.claimStatus;
                if (claimStatus != null) {
                    return claimStatus.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ShowPromoDialog(claimStatus=");
                sbM833U.append(this.claimStatus);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* data */ class GiftAndPromoData {
        private final List<ClaimedOutboundPromotion> claimedOutboundPromotions;
        private final StoreEntitlements.State entitlementState;
        private final Map<Long, List<ModelGift>> myPurchasedGifts;
        private final StoreOutboundPromotions.State outboundPromoState;
        private final ResolvingGiftState resolvingGiftState;

        /* JADX WARN: Multi-variable type inference failed */
        public GiftAndPromoData(StoreEntitlements.State state, ResolvingGiftState resolvingGiftState, Map<Long, ? extends List<ModelGift>> map, StoreOutboundPromotions.State state2, List<ClaimedOutboundPromotion> list) {
            C12238m.checkNotNullParameter(state, "entitlementState");
            C12238m.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
            C12238m.checkNotNullParameter(map, "myPurchasedGifts");
            C12238m.checkNotNullParameter(state2, "outboundPromoState");
            C12238m.checkNotNullParameter(list, "claimedOutboundPromotions");
            this.entitlementState = state;
            this.resolvingGiftState = resolvingGiftState;
            this.myPurchasedGifts = map;
            this.outboundPromoState = state2;
            this.claimedOutboundPromotions = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GiftAndPromoData copy$default(GiftAndPromoData giftAndPromoData, StoreEntitlements.State state, ResolvingGiftState resolvingGiftState, Map map, StoreOutboundPromotions.State state2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                state = giftAndPromoData.entitlementState;
            }
            if ((i & 2) != 0) {
                resolvingGiftState = giftAndPromoData.resolvingGiftState;
            }
            ResolvingGiftState resolvingGiftState2 = resolvingGiftState;
            if ((i & 4) != 0) {
                map = giftAndPromoData.myPurchasedGifts;
            }
            Map map2 = map;
            if ((i & 8) != 0) {
                state2 = giftAndPromoData.outboundPromoState;
            }
            StoreOutboundPromotions.State state3 = state2;
            if ((i & 16) != 0) {
                list = giftAndPromoData.claimedOutboundPromotions;
            }
            return giftAndPromoData.copy(state, resolvingGiftState2, map2, state3, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ResolvingGiftState getResolvingGiftState() {
            return this.resolvingGiftState;
        }

        public final Map<Long, List<ModelGift>> component3() {
            return this.myPurchasedGifts;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StoreOutboundPromotions.State getOutboundPromoState() {
            return this.outboundPromoState;
        }

        public final List<ClaimedOutboundPromotion> component5() {
            return this.claimedOutboundPromotions;
        }

        public final GiftAndPromoData copy(StoreEntitlements.State entitlementState, ResolvingGiftState resolvingGiftState, Map<Long, ? extends List<ModelGift>> myPurchasedGifts, StoreOutboundPromotions.State outboundPromoState, List<ClaimedOutboundPromotion> claimedOutboundPromotions) {
            C12238m.checkNotNullParameter(entitlementState, "entitlementState");
            C12238m.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
            C12238m.checkNotNullParameter(myPurchasedGifts, "myPurchasedGifts");
            C12238m.checkNotNullParameter(outboundPromoState, "outboundPromoState");
            C12238m.checkNotNullParameter(claimedOutboundPromotions, "claimedOutboundPromotions");
            return new GiftAndPromoData(entitlementState, resolvingGiftState, myPurchasedGifts, outboundPromoState, claimedOutboundPromotions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GiftAndPromoData)) {
                return false;
            }
            GiftAndPromoData giftAndPromoData = (GiftAndPromoData) other;
            return C12238m.areEqual(this.entitlementState, giftAndPromoData.entitlementState) && C12238m.areEqual(this.resolvingGiftState, giftAndPromoData.resolvingGiftState) && C12238m.areEqual(this.myPurchasedGifts, giftAndPromoData.myPurchasedGifts) && C12238m.areEqual(this.outboundPromoState, giftAndPromoData.outboundPromoState) && C12238m.areEqual(this.claimedOutboundPromotions, giftAndPromoData.claimedOutboundPromotions);
        }

        public final List<ClaimedOutboundPromotion> getClaimedOutboundPromotions() {
            return this.claimedOutboundPromotions;
        }

        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        public final Map<Long, List<ModelGift>> getMyPurchasedGifts() {
            return this.myPurchasedGifts;
        }

        public final StoreOutboundPromotions.State getOutboundPromoState() {
            return this.outboundPromoState;
        }

        public final ResolvingGiftState getResolvingGiftState() {
            return this.resolvingGiftState;
        }

        public int hashCode() {
            StoreEntitlements.State state = this.entitlementState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            ResolvingGiftState resolvingGiftState = this.resolvingGiftState;
            int iHashCode2 = (iHashCode + (resolvingGiftState != null ? resolvingGiftState.hashCode() : 0)) * 31;
            Map<Long, List<ModelGift>> map = this.myPurchasedGifts;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            StoreOutboundPromotions.State state2 = this.outboundPromoState;
            int iHashCode4 = (iHashCode3 + (state2 != null ? state2.hashCode() : 0)) * 31;
            List<ClaimedOutboundPromotion> list = this.claimedOutboundPromotions;
            return iHashCode4 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("GiftAndPromoData(entitlementState=");
            sbM833U.append(this.entitlementState);
            sbM833U.append(", resolvingGiftState=");
            sbM833U.append(this.resolvingGiftState);
            sbM833U.append(", myPurchasedGifts=");
            sbM833U.append(this.myPurchasedGifts);
            sbM833U.append(", outboundPromoState=");
            sbM833U.append(this.outboundPromoState);
            sbM833U.append(", claimedOutboundPromotions=");
            return C1643a.m824L(sbM833U, this.claimedOutboundPromotions, ")");
        }
    }

    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static abstract class GiftPurchaseEvent {

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final /* data */ class CompleteGiftPurchase extends GiftPurchaseEvent {
            private final String newGiftCode;
            private final String skuName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CompleteGiftPurchase(String str, String str2) {
                super(null);
                C12238m.checkNotNullParameter(str, "skuName");
                C12238m.checkNotNullParameter(str2, "newGiftCode");
                this.skuName = str;
                this.newGiftCode = str2;
            }

            public static /* synthetic */ CompleteGiftPurchase copy$default(CompleteGiftPurchase completeGiftPurchase, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = completeGiftPurchase.skuName;
                }
                if ((i & 2) != 0) {
                    str2 = completeGiftPurchase.newGiftCode;
                }
                return completeGiftPurchase.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSkuName() {
                return this.skuName;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getNewGiftCode() {
                return this.newGiftCode;
            }

            public final CompleteGiftPurchase copy(String skuName, String newGiftCode) {
                C12238m.checkNotNullParameter(skuName, "skuName");
                C12238m.checkNotNullParameter(newGiftCode, "newGiftCode");
                return new CompleteGiftPurchase(skuName, newGiftCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CompleteGiftPurchase)) {
                    return false;
                }
                CompleteGiftPurchase completeGiftPurchase = (CompleteGiftPurchase) other;
                return C12238m.areEqual(this.skuName, completeGiftPurchase.skuName) && C12238m.areEqual(this.newGiftCode, completeGiftPurchase.newGiftCode);
            }

            public final String getNewGiftCode() {
                return this.newGiftCode;
            }

            public final String getSkuName() {
                return this.skuName;
            }

            public int hashCode() {
                String str = this.skuName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.newGiftCode;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("CompleteGiftPurchase(skuName=");
                sbM833U.append(this.skuName);
                sbM833U.append(", newGiftCode=");
                return C1643a.m822J(sbM833U, this.newGiftCode, ")");
            }
        }

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final /* data */ class ErrorGiftPurchase extends GiftPurchaseEvent {
            private final int message;

            public ErrorGiftPurchase(@StringRes int i) {
                super(null);
                this.message = i;
            }

            public static /* synthetic */ ErrorGiftPurchase copy$default(ErrorGiftPurchase errorGiftPurchase, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = errorGiftPurchase.message;
                }
                return errorGiftPurchase.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getMessage() {
                return this.message;
            }

            public final ErrorGiftPurchase copy(@StringRes int message) {
                return new ErrorGiftPurchase(message);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ErrorGiftPurchase) && this.message == ((ErrorGiftPurchase) other).message;
                }
                return true;
            }

            public final int getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("ErrorGiftPurchase(message="), this.message, ")");
            }
        }

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final class NotInProgress extends GiftPurchaseEvent {
            public static final NotInProgress INSTANCE = new NotInProgress();

            private NotInProgress() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final class StartGiftPurchase extends GiftPurchaseEvent {
            public static final StartGiftPurchase INSTANCE = new StartGiftPurchase();

            private StartGiftPurchase() {
                super(null);
            }
        }

        private GiftPurchaseEvent() {
        }

        public /* synthetic */ GiftPurchaseEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static abstract class OutboundPromoData {

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final /* data */ class Loaded extends OutboundPromoData {
            private final List<OutboundPromoItem> outboundPromos;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<OutboundPromoItem> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "outboundPromos");
                this.outboundPromos = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.outboundPromos;
                }
                return loaded.copy(list);
            }

            public final List<OutboundPromoItem> component1() {
                return this.outboundPromos;
            }

            public final Loaded copy(List<OutboundPromoItem> outboundPromos) {
                C12238m.checkNotNullParameter(outboundPromos, "outboundPromos");
                return new Loaded(outboundPromos);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.outboundPromos, ((Loaded) other).outboundPromos);
                }
                return true;
            }

            public final List<OutboundPromoItem> getOutboundPromos() {
                return this.outboundPromos;
            }

            public int hashCode() {
                List<OutboundPromoItem> list = this.outboundPromos;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("Loaded(outboundPromos="), this.outboundPromos, ")");
            }
        }

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final class Loading extends OutboundPromoData {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private OutboundPromoData() {
        }

        public /* synthetic */ OutboundPromoData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* data */ class OutboundPromoItem {
        private final ClaimStatus claimStatus;
        private final long id;
        private final String imageUrl;
        private final String terms;
        private final String title;

        public OutboundPromoItem(ClaimStatus claimStatus, long j, String str, String str2, String str3) {
            C12238m.checkNotNullParameter(claimStatus, "claimStatus");
            C12238m.checkNotNullParameter(str, "title");
            C12238m.checkNotNullParameter(str2, "terms");
            C12238m.checkNotNullParameter(str3, "imageUrl");
            this.claimStatus = claimStatus;
            this.id = j;
            this.title = str;
            this.terms = str2;
            this.imageUrl = str3;
        }

        public static /* synthetic */ OutboundPromoItem copy$default(OutboundPromoItem outboundPromoItem, ClaimStatus claimStatus, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                claimStatus = outboundPromoItem.claimStatus;
            }
            if ((i & 2) != 0) {
                j = outboundPromoItem.id;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                str = outboundPromoItem.title;
            }
            String str4 = str;
            if ((i & 8) != 0) {
                str2 = outboundPromoItem.terms;
            }
            String str5 = str2;
            if ((i & 16) != 0) {
                str3 = outboundPromoItem.imageUrl;
            }
            return outboundPromoItem.copy(claimStatus, j2, str4, str5, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ClaimStatus getClaimStatus() {
            return this.claimStatus;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTerms() {
            return this.terms;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final OutboundPromoItem copy(ClaimStatus claimStatus, long id2, String title, String terms, String imageUrl) {
            C12238m.checkNotNullParameter(claimStatus, "claimStatus");
            C12238m.checkNotNullParameter(title, "title");
            C12238m.checkNotNullParameter(terms, "terms");
            C12238m.checkNotNullParameter(imageUrl, "imageUrl");
            return new OutboundPromoItem(claimStatus, id2, title, terms, imageUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OutboundPromoItem)) {
                return false;
            }
            OutboundPromoItem outboundPromoItem = (OutboundPromoItem) other;
            return C12238m.areEqual(this.claimStatus, outboundPromoItem.claimStatus) && this.id == outboundPromoItem.id && C12238m.areEqual(this.title, outboundPromoItem.title) && C12238m.areEqual(this.terms, outboundPromoItem.terms) && C12238m.areEqual(this.imageUrl, outboundPromoItem.imageUrl);
        }

        public final ClaimStatus getClaimStatus() {
            return this.claimStatus;
        }

        public final long getId() {
            return this.id;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getTerms() {
            return this.terms;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            ClaimStatus claimStatus = this.claimStatus;
            int iM3a = (C0002b.m3a(this.id) + ((claimStatus != null ? claimStatus.hashCode() : 0) * 31)) * 31;
            String str = this.title;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.terms;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.imageUrl;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("OutboundPromoItem(claimStatus=");
            sbM833U.append(this.claimStatus);
            sbM833U.append(", id=");
            sbM833U.append(this.id);
            sbM833U.append(", title=");
            sbM833U.append(this.title);
            sbM833U.append(", terms=");
            sbM833U.append(this.terms);
            sbM833U.append(", imageUrl=");
            return C1643a.m822J(sbM833U, this.imageUrl, ")");
        }
    }

    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static abstract class ResolvingGiftState {

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final class Error extends ResolvingGiftState {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final class NotResolving extends ResolvingGiftState {
            public static final NotResolving INSTANCE = new NotResolving();

            private NotResolving() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final class Resolving extends ResolvingGiftState {
            public static final Resolving INSTANCE = new Resolving();

            private Resolving() {
                super(null);
            }
        }

        private ResolvingGiftState() {
        }

        public /* synthetic */ ResolvingGiftState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreEntitlements.State entitlementState;
        private final boolean isUserPremium;
        private final List<ModelGift> myResolvedGifts;
        private final StoreOutboundPromotions.State outboundPromoState;

        public StoreState(StoreEntitlements.State state, List<ModelGift> list, StoreOutboundPromotions.State state2, boolean z2) {
            C12238m.checkNotNullParameter(state, "entitlementState");
            C12238m.checkNotNullParameter(list, "myResolvedGifts");
            C12238m.checkNotNullParameter(state2, "outboundPromoState");
            this.entitlementState = state;
            this.myResolvedGifts = list;
            this.outboundPromoState = state2;
            this.isUserPremium = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreEntitlements.State state, List list, StoreOutboundPromotions.State state2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                state = storeState.entitlementState;
            }
            if ((i & 2) != 0) {
                list = storeState.myResolvedGifts;
            }
            if ((i & 4) != 0) {
                state2 = storeState.outboundPromoState;
            }
            if ((i & 8) != 0) {
                z2 = storeState.isUserPremium;
            }
            return storeState.copy(state, list, state2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        public final List<ModelGift> component2() {
            return this.myResolvedGifts;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreOutboundPromotions.State getOutboundPromoState() {
            return this.outboundPromoState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsUserPremium() {
            return this.isUserPremium;
        }

        public final StoreState copy(StoreEntitlements.State entitlementState, List<ModelGift> myResolvedGifts, StoreOutboundPromotions.State outboundPromoState, boolean isUserPremium) {
            C12238m.checkNotNullParameter(entitlementState, "entitlementState");
            C12238m.checkNotNullParameter(myResolvedGifts, "myResolvedGifts");
            C12238m.checkNotNullParameter(outboundPromoState, "outboundPromoState");
            return new StoreState(entitlementState, myResolvedGifts, outboundPromoState, isUserPremium);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.entitlementState, storeState.entitlementState) && C12238m.areEqual(this.myResolvedGifts, storeState.myResolvedGifts) && C12238m.areEqual(this.outboundPromoState, storeState.outboundPromoState) && this.isUserPremium == storeState.isUserPremium;
        }

        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        public final List<ModelGift> getMyResolvedGifts() {
            return this.myResolvedGifts;
        }

        public final StoreOutboundPromotions.State getOutboundPromoState() {
            return this.outboundPromoState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            StoreEntitlements.State state = this.entitlementState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            List<ModelGift> list = this.myResolvedGifts;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            StoreOutboundPromotions.State state2 = this.outboundPromoState;
            int iHashCode3 = (iHashCode2 + (state2 != null ? state2.hashCode() : 0)) * 31;
            boolean z2 = this.isUserPremium;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public final boolean isUserPremium() {
            return this.isUserPremium;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(entitlementState=");
            sbM833U.append(this.entitlementState);
            sbM833U.append(", myResolvedGifts=");
            sbM833U.append(this.myResolvedGifts);
            sbM833U.append(", outboundPromoState=");
            sbM833U.append(this.outboundPromoState);
            sbM833U.append(", isUserPremium=");
            return C1643a.m827O(sbM833U, this.isUserPremium, ")");
        }
    }

    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Set<Long> expandedSkuOrPlanIds;
            private final String lastCopiedCode;
            private final Map<Long, List<ModelEntitlement>> myEntitlements;
            private final Map<Long, List<ModelGift>> myPurchasedGifts;
            private final List<OutboundPromoItem> outboundPromos;
            private final ResolvingGiftState resolvingGiftState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Map<Long, ? extends List<ModelEntitlement>> map, ResolvingGiftState resolvingGiftState, Set<Long> set, List<OutboundPromoItem> list, Map<Long, ? extends List<ModelGift>> map2, String str) {
                super(null);
                C12238m.checkNotNullParameter(map, "myEntitlements");
                C12238m.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
                C12238m.checkNotNullParameter(set, "expandedSkuOrPlanIds");
                C12238m.checkNotNullParameter(list, "outboundPromos");
                C12238m.checkNotNullParameter(map2, "myPurchasedGifts");
                this.myEntitlements = map;
                this.resolvingGiftState = resolvingGiftState;
                this.expandedSkuOrPlanIds = set;
                this.outboundPromos = list;
                this.myPurchasedGifts = map2;
                this.lastCopiedCode = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, ResolvingGiftState resolvingGiftState, Set set, List list, Map map2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.myEntitlements;
                }
                if ((i & 2) != 0) {
                    resolvingGiftState = loaded.resolvingGiftState;
                }
                ResolvingGiftState resolvingGiftState2 = resolvingGiftState;
                if ((i & 4) != 0) {
                    set = loaded.expandedSkuOrPlanIds;
                }
                Set set2 = set;
                if ((i & 8) != 0) {
                    list = loaded.outboundPromos;
                }
                List list2 = list;
                if ((i & 16) != 0) {
                    map2 = loaded.myPurchasedGifts;
                }
                Map map3 = map2;
                if ((i & 32) != 0) {
                    str = loaded.lastCopiedCode;
                }
                return loaded.copy(map, resolvingGiftState2, set2, list2, map3, str);
            }

            public final Map<Long, List<ModelEntitlement>> component1() {
                return this.myEntitlements;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ResolvingGiftState getResolvingGiftState() {
                return this.resolvingGiftState;
            }

            public final Set<Long> component3() {
                return this.expandedSkuOrPlanIds;
            }

            public final List<OutboundPromoItem> component4() {
                return this.outboundPromos;
            }

            public final Map<Long, List<ModelGift>> component5() {
                return this.myPurchasedGifts;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getLastCopiedCode() {
                return this.lastCopiedCode;
            }

            public final Loaded copy(Map<Long, ? extends List<ModelEntitlement>> myEntitlements, ResolvingGiftState resolvingGiftState, Set<Long> expandedSkuOrPlanIds, List<OutboundPromoItem> outboundPromos, Map<Long, ? extends List<ModelGift>> myPurchasedGifts, String lastCopiedCode) {
                C12238m.checkNotNullParameter(myEntitlements, "myEntitlements");
                C12238m.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
                C12238m.checkNotNullParameter(expandedSkuOrPlanIds, "expandedSkuOrPlanIds");
                C12238m.checkNotNullParameter(outboundPromos, "outboundPromos");
                C12238m.checkNotNullParameter(myPurchasedGifts, "myPurchasedGifts");
                return new Loaded(myEntitlements, resolvingGiftState, expandedSkuOrPlanIds, outboundPromos, myPurchasedGifts, lastCopiedCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.myEntitlements, loaded.myEntitlements) && C12238m.areEqual(this.resolvingGiftState, loaded.resolvingGiftState) && C12238m.areEqual(this.expandedSkuOrPlanIds, loaded.expandedSkuOrPlanIds) && C12238m.areEqual(this.outboundPromos, loaded.outboundPromos) && C12238m.areEqual(this.myPurchasedGifts, loaded.myPurchasedGifts) && C12238m.areEqual(this.lastCopiedCode, loaded.lastCopiedCode);
            }

            public final Set<Long> getExpandedSkuOrPlanIds() {
                return this.expandedSkuOrPlanIds;
            }

            public final String getLastCopiedCode() {
                return this.lastCopiedCode;
            }

            public final Map<Long, List<ModelEntitlement>> getMyEntitlements() {
                return this.myEntitlements;
            }

            public final Map<Long, List<ModelGift>> getMyPurchasedGifts() {
                return this.myPurchasedGifts;
            }

            public final List<OutboundPromoItem> getOutboundPromos() {
                return this.outboundPromos;
            }

            public final ResolvingGiftState getResolvingGiftState() {
                return this.resolvingGiftState;
            }

            public int hashCode() {
                Map<Long, List<ModelEntitlement>> map = this.myEntitlements;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                ResolvingGiftState resolvingGiftState = this.resolvingGiftState;
                int iHashCode2 = (iHashCode + (resolvingGiftState != null ? resolvingGiftState.hashCode() : 0)) * 31;
                Set<Long> set = this.expandedSkuOrPlanIds;
                int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
                List<OutboundPromoItem> list = this.outboundPromos;
                int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                Map<Long, List<ModelGift>> map2 = this.myPurchasedGifts;
                int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
                String str = this.lastCopiedCode;
                return iHashCode5 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(myEntitlements=");
                sbM833U.append(this.myEntitlements);
                sbM833U.append(", resolvingGiftState=");
                sbM833U.append(this.resolvingGiftState);
                sbM833U.append(", expandedSkuOrPlanIds=");
                sbM833U.append(this.expandedSkuOrPlanIds);
                sbM833U.append(", outboundPromos=");
                sbM833U.append(this.outboundPromos);
                sbM833U.append(", myPurchasedGifts=");
                sbM833U.append(this.myPurchasedGifts);
                sbM833U.append(", lastCopiedCode=");
                return C1643a.m822J(sbM833U, this.lastCopiedCode, ")");
            }
        }

        /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$1 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final class C98791 extends AbstractC12240o implements Function1<Error, Unit> {
        public C98791() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            SettingsGiftingViewModel.this.storeEntitlements.fetchMyGiftEntitlements();
            SettingsGiftingViewModel.this.giftPurchaseEventSubject.f27650k.onNext((T) new GiftPurchaseEvent.ErrorGiftPurchase(C5419R.string.billing_error_purchase));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$2 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final class C98802 extends AbstractC12240o implements Function1<ModelGift, Unit> {
        public final /* synthetic */ StoreGooglePlayPurchases.Event $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C98802(StoreGooglePlayPurchases.Event event) {
            super(1);
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            C12238m.checkNotNullParameter(modelGift, "it");
            SettingsGiftingViewModel.this.storeEntitlements.fetchMyGiftEntitlements();
            SettingsGiftingViewModel.this.giftPurchaseEventSubject.f27650k.onNext((T) new GiftPurchaseEvent.CompleteGiftPurchase(((StoreGooglePlayPurchases.Event.PurchaseQuerySuccess) this.$event).getNewSkuName(), modelGift.getCode()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$maybeCheckClaimedPromos$3 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* synthetic */ class C98833 extends C12236k implements Function1<List<? extends ClaimedOutboundPromotion>, Unit> {
        public C98833(BehaviorSubject behaviorSubject) {
            super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ClaimedOutboundPromotion> list) {
            invoke2((List<ClaimedOutboundPromotion>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ClaimedOutboundPromotion> list) {
            ((BehaviorSubject) this.receiver).onNext(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$redeemGiftCode$1 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final class C98841 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C98841() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            SettingsGiftingViewModel.this.subscriptions.m11136a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$redeemGiftCode$2 */
    /* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
    public static final /* synthetic */ class C98852 extends C12236k implements Function1<StoreGifting.GiftState, Unit> {
        public C98852(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "onHandleGiftCode", "onHandleGiftCode(Lcom/discord/stores/StoreGifting$GiftState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreGifting.GiftState giftState) {
            invoke2(giftState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreGifting.GiftState giftState) {
            C12238m.checkNotNullParameter(giftState, "p1");
            ((SettingsGiftingViewModel) this.receiver).onHandleGiftCode(giftState);
        }
    }

    public SettingsGiftingViewModel() {
        this(null, null, null, null, null, null, null, Opcodes.LAND, null);
    }

    public /* synthetic */ SettingsGiftingViewModel(StoreEntitlements storeEntitlements, StoreGifting storeGifting, StoreUserSettingsSystem storeUserSettingsSystem, StoreOutboundPromotions storeOutboundPromotions, StoreGooglePlayPurchases storeGooglePlayPurchases, GooglePlayBillingManager googlePlayBillingManager, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getEntitlements() : storeEntitlements, (i & 2) != 0 ? StoreStream.INSTANCE.getGifting() : storeGifting, (i & 4) != 0 ? StoreStream.INSTANCE.getUserSettingsSystem() : storeUserSettingsSystem, (i & 8) != 0 ? StoreStream.INSTANCE.getOutboundPromotions() : storeOutboundPromotions, (i & 16) != 0 ? StoreStream.INSTANCE.getGooglePlayPurchases() : storeGooglePlayPurchases, (i & 32) != 0 ? GooglePlayBillingManager.INSTANCE : googlePlayBillingManager, (i & 64) != 0 ? INSTANCE.observeStores() : observable);
    }

    @MainThread
    private final ViewState buildViewState(StoreEntitlements.State entitlementState, ResolvingGiftState resolvingGiftState, Map<Long, ? extends List<ModelGift>> myPurchasedGifts, OutboundPromoData outboundPromoData) {
        Set<Long> setEmptySet;
        if (!(entitlementState instanceof StoreEntitlements.State.Loaded) || !(outboundPromoData instanceof OutboundPromoData.Loaded)) {
            return entitlementState instanceof StoreEntitlements.State.Failure ? ViewState.Failure.INSTANCE : ViewState.Loading.INSTANCE;
        }
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (setEmptySet = loaded.getExpandedSkuOrPlanIds()) == null) {
            setEmptySet = C12148n0.emptySet();
        }
        Set<Long> set = setEmptySet;
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Loaded)) {
            viewState2 = null;
        }
        ViewState.Loaded loaded2 = (ViewState.Loaded) viewState2;
        return new ViewState.Loaded(((StoreEntitlements.State.Loaded) entitlementState).getGiftableEntitlements(), resolvingGiftState, set, ((OutboundPromoData.Loaded) outboundPromoData).getOutboundPromos(), myPurchasedGifts, loaded2 != null ? loaded2.getLastCopiedCode() : null);
    }

    private final GiftAndPromoData combineData(StoreState storeState, List<ClaimedOutboundPromotion> claimedPromos) {
        ResolvingGiftState resolvingGiftState;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (resolvingGiftState = loaded.getResolvingGiftState()) == null) {
            resolvingGiftState = ResolvingGiftState.NotResolving.INSTANCE;
        }
        ResolvingGiftState resolvingGiftState2 = resolvingGiftState;
        StoreEntitlements.State entitlementState = storeState.getEntitlementState();
        StoreOutboundPromotions.State outboundPromoState = storeState.getOutboundPromoState();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (entitlementState instanceof StoreEntitlements.State.Loaded) {
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
        return new GiftAndPromoData(entitlementState, resolvingGiftState2, linkedHashMap, outboundPromoState, claimedPromos);
    }

    private final String getPromoImageUrl(long promoId) {
        String str = C12238m.areEqual(this.storeUserSettingsSystem.getTheme(), ModelUserSettings.THEME_LIGHT) ? "logo-light" : "logo-dark";
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
        return C1643a.m822J(sb, str, "?size=256");
    }

    private final List<OutboundPromoItem> getPromos(List<OutboundPromotion> validActivePromos, List<ClaimedOutboundPromotion> claimedPromos) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (OutboundPromotion outboundPromotion : validActivePromos) {
            OutboundPromoItem outboundPromoItem = new OutboundPromoItem(new ClaimStatus.Unclaimed(outboundPromotion.getId(), outboundPromotion.getEndDate()), outboundPromotion.getId(), outboundPromotion.getOutboundTitle(), outboundPromotion.getOutboundTermsAndConditions(), getPromoImageUrl(outboundPromotion.getId()));
            linkedHashMap.put(Long.valueOf(outboundPromoItem.getId()), outboundPromoItem);
        }
        for (ClaimedOutboundPromotion claimedOutboundPromotion : claimedPromos) {
            OutboundPromoItem outboundPromoItem2 = new OutboundPromoItem(new ClaimStatus.Claimed(claimedOutboundPromotion.getPromotion().getId(), claimedOutboundPromotion.getCode(), claimedOutboundPromotion.getPromotion().getOutboundRedemptionModalBody(), claimedOutboundPromotion.m8136d(), claimedOutboundPromotion.m8135c()), claimedOutboundPromotion.getPromotion().getId(), claimedOutboundPromotion.getPromotion().getOutboundTitle(), claimedOutboundPromotion.getPromotion().getOutboundTermsAndConditions(), getPromoImageUrl(claimedOutboundPromotion.getPromotion().getId()));
            linkedHashMap.put(Long.valueOf(outboundPromoItem2.getId()), outboundPromoItem2);
        }
        return C12163u.toList(linkedHashMap.values());
    }

    @MainThread
    private final void handleAsyncData(GiftAndPromoData data) {
        OutboundPromoData loaded;
        StoreOutboundPromotions.State outboundPromoState = data.getOutboundPromoState();
        if (outboundPromoState instanceof StoreOutboundPromotions.State.Loaded) {
            loaded = new OutboundPromoData.Loaded(getPromos(((StoreOutboundPromotions.State.Loaded) outboundPromoState).getValidActivePromotions(), data.getClaimedOutboundPromotions()));
        } else if (outboundPromoState instanceof StoreOutboundPromotions.State.Failed) {
            loaded = new OutboundPromoData.Loaded(C12147n.emptyList());
        } else {
            if (!(outboundPromoState instanceof StoreOutboundPromotions.State.Loading)) {
                throw new NoWhenBranchMatchedException();
            }
            loaded = OutboundPromoData.Loading.INSTANCE;
        }
        ViewState viewStateBuildViewState = buildViewState(data.getEntitlementState(), data.getResolvingGiftState(), data.getMyPurchasedGifts(), loaded);
        if (viewStateBuildViewState instanceof ViewState.Loaded) {
            this.storeOutboundPromotions.markSeen();
        }
        updateViewState(viewStateBuildViewState);
    }

    private final void handleGooglePlayPurchaseEvent(StoreGooglePlayPurchases.Event event) {
        if (!(event instanceof StoreGooglePlayPurchases.Event.PurchaseQuerySuccess)) {
            if (event instanceof StoreGooglePlayPurchases.Event.PurchaseQueryFailure) {
                PublishSubject<GiftPurchaseEvent> publishSubject = this.giftPurchaseEventSubject;
                publishSubject.f27650k.onNext(new GiftPurchaseEvent.ErrorGiftPurchase(C5419R.string.billing_error_purchase));
                return;
            }
            return;
        }
        StoreGooglePlayPurchases.Event.PurchaseQuerySuccess purchaseQuerySuccess = (StoreGooglePlayPurchases.Event.PurchaseQuerySuccess) event;
        if (purchaseQuerySuccess.getGiftCode() != null) {
            this.storeEntitlements.fetchMyGiftEntitlements();
            PublishSubject<GiftPurchaseEvent> publishSubject2 = this.giftPurchaseEventSubject;
            publishSubject2.f27650k.onNext(new GiftPurchaseEvent.CompleteGiftPurchase(purchaseQuerySuccess.getNewSkuName(), purchaseQuerySuccess.getGiftCode()));
            return;
        }
        StoreGifting storeGifting = this.storeGifting;
        Long skuId = purchaseQuerySuccess.getSkuId();
        C12238m.checkNotNull(skuId);
        storeGifting.generateGiftCode(skuId.longValue(), purchaseQuerySuccess.getSubscriptionPlanId(), new C98802(event), new C98791());
    }

    private final void handleGooglePlayQueryStateUpdate(StoreGooglePlayPurchases.QueryState queryState) {
        if (C12238m.areEqual(queryState, StoreGooglePlayPurchases.QueryState.InProgress.INSTANCE)) {
            PublishSubject<GiftPurchaseEvent> publishSubject = this.giftPurchaseEventSubject;
            publishSubject.f27650k.onNext(GiftPurchaseEvent.StartGiftPurchase.INSTANCE);
        } else if (C12238m.areEqual(queryState, StoreGooglePlayPurchases.QueryState.NotInProgress.INSTANCE)) {
            PublishSubject<GiftPurchaseEvent> publishSubject2 = this.giftPurchaseEventSubject;
            publishSubject2.f27650k.onNext(GiftPurchaseEvent.NotInProgress.INSTANCE);
        }
    }

    private final void maybeCheckClaimedPromos(boolean isUserPremium) {
        if (this.shouldCheckClaimedPromos.compareAndSet(true, false)) {
            if (!isUserPremium) {
                this.claimedPromotionsSubject.onNext(C12147n.emptyList());
                return;
            }
            Observable observableM11087M = ObservableExtensionsKt.restSubscribeOn$default(this.storeOutboundPromotions.fetchClaimedOutboundPromotions(), false, 1, null).m11114t(new Action1<Throwable>() { // from class: com.discord.widgets.settings.premium.SettingsGiftingViewModel.maybeCheckClaimedPromos.1
                @Override // p658rx.functions.Action1
                public final void call(Throwable th) {
                    SettingsGiftingViewModel.this.shouldCheckClaimedPromos.set(true);
                }
            }).m11087M(new InterfaceC12589b<Throwable, List<? extends ClaimedOutboundPromotion>>() { // from class: com.discord.widgets.settings.premium.SettingsGiftingViewModel.maybeCheckClaimedPromos.2
                @Override // p637j0.p641k.InterfaceC12589b
                public final List<ClaimedOutboundPromotion> call(Throwable th) {
                    return C12147n.emptyList();
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11087M, "storeOutboundPromotions.…rorReturn { emptyList() }");
            ObservableExtensionsKt.appSubscribe(observableM11087M, (Class<?>) SettingsGiftingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98833(this.claimedPromotionsSubject));
        }
    }

    @MainThread
    private final void onHandleGiftCode(StoreGifting.GiftState giftState) {
        ViewState viewStateBuildViewState;
        ModelGift gift;
        ViewState viewState = getViewState();
        ModelGift gift2 = null;
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreEntitlements.State.Loaded loaded2 = new StoreEntitlements.State.Loaded(loaded.getMyEntitlements(), C12136h0.emptyMap());
            OutboundPromoData.Loaded loaded3 = new OutboundPromoData.Loaded(loaded.getOutboundPromos());
            if ((giftState instanceof StoreGifting.GiftState.Loading) || (giftState instanceof StoreGifting.GiftState.Redeeming)) {
                viewStateBuildViewState = buildViewState(loaded2, ResolvingGiftState.Resolving.INSTANCE, loaded.getMyPurchasedGifts(), loaded3);
            } else if ((giftState instanceof StoreGifting.GiftState.LoadFailed) || (giftState instanceof StoreGifting.GiftState.RedeemedFailed) || (giftState instanceof StoreGifting.GiftState.Invalid)) {
                viewStateBuildViewState = buildViewState(loaded2, ResolvingGiftState.Error.INSTANCE, loaded.getMyPurchasedGifts(), loaded3);
            } else {
                boolean z2 = giftState instanceof StoreGifting.GiftState.Revoking;
                if (!z2 && !(giftState instanceof StoreGifting.GiftState.Resolved)) {
                    throw new NoWhenBranchMatchedException();
                }
                StoreGifting.GiftState.Resolved resolved = (StoreGifting.GiftState.Resolved) (!(giftState instanceof StoreGifting.GiftState.Resolved) ? null : giftState);
                if (resolved == null || (gift = resolved.getGift()) == null) {
                    if (!z2) {
                        giftState = null;
                    }
                    StoreGifting.GiftState.Revoking revoking = (StoreGifting.GiftState.Revoking) giftState;
                    if (revoking != null) {
                        gift2 = revoking.getGift();
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
                viewStateBuildViewState = buildViewState(loaded2, ResolvingGiftState.NotResolving.INSTANCE, loaded.getMyPurchasedGifts(), loaded3);
            }
            updateViewState(viewStateBuildViewState);
        }
    }

    @MainThread
    public final void handleClaimedPromo(ClaimStatus.Claimed claimedStatus) {
        C12238m.checkNotNullParameter(claimedStatus, "claimedStatus");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            List<OutboundPromoItem> outboundPromos = loaded.getOutboundPromos();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(outboundPromos, 10));
            for (OutboundPromoItem outboundPromoItemCopy$default : outboundPromos) {
                if (outboundPromoItemCopy$default.getId() == claimedStatus.getPromoId()) {
                    outboundPromoItemCopy$default = OutboundPromoItem.copy$default(outboundPromoItemCopy$default, claimedStatus, 0L, null, null, null, 30, null);
                }
                arrayList.add(outboundPromoItemCopy$default);
            }
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, arrayList, null, null, 55, null));
        }
    }

    @MainThread
    public final void handleCopyClicked(String giftCode) {
        C12238m.checkNotNullParameter(giftCode, "giftCode");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, giftCode, 31, null));
        }
    }

    public final void handlePromoButtonClicked(OutboundPromoItem promoItem) {
        C12238m.checkNotNullParameter(promoItem, "promoItem");
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowPromoDialog(promoItem.getClaimStatus()));
    }

    public final void handlePromoMoreDetailsClicked(OutboundPromoItem promoItem) {
        C12238m.checkNotNullParameter(promoItem, "promoItem");
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowPromoBottomSheet(promoItem.getTerms()));
    }

    @MainThread
    public final void handleSkuClicked(long skuId, Long planId) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            Set mutableSet = C12163u.toMutableSet(loaded.getExpandedSkuOrPlanIds());
            long jLongValue = planId != null ? planId.longValue() : skuId;
            if (mutableSet.contains(Long.valueOf(jLongValue))) {
                mutableSet.remove(Long.valueOf(jLongValue));
            } else {
                mutableSet.add(Long.valueOf(jLongValue));
                this.storeGifting.fetchMyGiftsForSku(skuId, planId);
            }
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, mutableSet, null, null, null, 59, null));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final PublishSubject<GiftPurchaseEvent> observeGiftPurchaseEvents() {
        PublishSubject<GiftPurchaseEvent> publishSubject = this.giftPurchaseEventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "giftPurchaseEventSubject");
        return publishSubject;
    }

    @Override // p007b.p008a.p018d.AbstractC0859d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        this.subscriptions.m11137b();
    }

    @MainThread
    public final void redeemGiftCode(String giftCode, AppComponent appComponent) {
        C12238m.checkNotNullParameter(giftCode, "giftCode");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        if (getViewState() instanceof ViewState.Loaded) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(this.storeGifting.requestGift(giftCode), appComponent, null, 2, null), (Class<?>) SettingsGiftingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C98841()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98852(this));
        }
    }

    public final void setOnGiftCodeResolved(Function1<? super String, Unit> onGiftCodeResolved) {
        C12238m.checkNotNullParameter(onGiftCodeResolved, "onGiftCodeResolved");
        this.onGiftCodeResolved = onGiftCodeResolved;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGiftingViewModel(StoreEntitlements storeEntitlements, StoreGifting storeGifting, StoreUserSettingsSystem storeUserSettingsSystem, StoreOutboundPromotions storeOutboundPromotions, StoreGooglePlayPurchases storeGooglePlayPurchases, GooglePlayBillingManager googlePlayBillingManager, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(storeEntitlements, "storeEntitlements");
        C12238m.checkNotNullParameter(storeGifting, "storeGifting");
        C12238m.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        C12238m.checkNotNullParameter(storeOutboundPromotions, "storeOutboundPromotions");
        C12238m.checkNotNullParameter(storeGooglePlayPurchases, "storeGooglePlayPurchases");
        C12238m.checkNotNullParameter(googlePlayBillingManager, "gPlayBillingManager");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.storeEntitlements = storeEntitlements;
        this.storeGifting = storeGifting;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        this.storeOutboundPromotions = storeOutboundPromotions;
        BehaviorSubject<StoreState> behaviorSubjectM11129k0 = BehaviorSubject.m11129k0();
        this.storeStateSubject = behaviorSubjectM11129k0;
        BehaviorSubject<List<ClaimedOutboundPromotion>> behaviorSubjectM11129k1 = BehaviorSubject.m11129k0();
        this.claimedPromotionsSubject = behaviorSubjectM11129k1;
        this.shouldCheckClaimedPromos = new AtomicBoolean(true);
        this.giftPurchaseEventSubject = PublishSubject.m11133k0();
        this.eventSubject = PublishSubject.m11133k0();
        this.onGiftCodeResolved = SettingsGiftingViewModel$onGiftCodeResolved$1.INSTANCE;
        this.subscriptions = new CompositeSubscription();
        storeEntitlements.fetchMyGiftEntitlements();
        googlePlayBillingManager.queryPurchases();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(storeGooglePlayPurchases.observeEvents(), this, null, 2, null), (Class<?>) SettingsGiftingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98731(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(storeGooglePlayPurchases.observeQueryState(), this, null, 2, null), (Class<?>) SettingsGiftingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98742(this));
        Observable observableM11115u = ObservableExtensionsKt.computationLatest(observable).m11115u(new Action1<StoreState>() { // from class: com.discord.widgets.settings.premium.SettingsGiftingViewModel.3
            @Override // p658rx.functions.Action1
            public final void call(StoreState storeState) {
                SettingsGiftingViewModel.this.maybeCheckClaimedPromos(storeState.isUserPremium());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "storeObservable\n        …oreState.isUserPremium) }");
        ObservableExtensionsKt.appSubscribe(observableM11115u, (Class<?>) SettingsGiftingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98764(behaviorSubjectM11129k0));
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11129k0, "storeStateSubject");
        Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(behaviorSubjectM11129k0);
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11129k1, "claimedPromotionsSubject");
        Observable observableComputationLatest2 = ObservableExtensionsKt.computationLatest(behaviorSubjectM11129k1);
        final C98775 c98775 = new C98775(this);
        Observable observableM11112r = Observable.m11076j(observableComputationLatest, observableComputationLatest2, new Func2() { // from class: com.discord.widgets.settings.premium.SettingsGiftingViewModel$sam$rx_functions_Func2$0
            @Override // p658rx.functions.Func2
            public final /* synthetic */ Object call(Object obj, Object obj2) {
                return c98775.invoke(obj, obj2);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), (Class<?>) SettingsGiftingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98786(this));
    }
}
