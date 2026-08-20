package com.discord.widgets.chat.input.sticker;

import androidx.annotation.MainThread;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.PremiumUtilsKt;
import com.discord.utilities.stickers.StickerUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StickerPackStoreSheetAnalytics analytics;
    private final long stickerPackId;
    private final StoreStickers stickersStore;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel$1 */
    /* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
    public static final class C78931 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C78931() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            StickerPackStoreSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final List<MGRecyclerDataPayload> buildStoreStickerListItems(ModelStickerPack stickerPack, int stickerAnimationSettings, User meUser) {
            ArrayList arrayList = new ArrayList();
            if (stickerPack.getStickers().isEmpty()) {
                return C12147n.emptyList();
            }
            arrayList.add(new StoreHeaderItem(stickerPack, false));
            for (Sticker sticker : stickerPack.getStickers()) {
                arrayList.add(new StickerItem(sticker, stickerAnimationSettings, StickerItem.Mode.STORE, StickerUtils.getStickerSendability$default(StickerUtils.INSTANCE, sticker, meUser, null, null, 12, null)));
            }
            return arrayList;
        }

        private final Observable<StoreState> observeStoreState(long stickerPackId, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser) {
            Observable<StoreState> observableM11075i = Observable.m11075i(storeStickers.observeStickerPack(stickerPackId), StoreUserSettings.observeStickerAnimationSettings$default(storeUserSettings, false, 1, null), StoreUser.observeMe$default(storeUser, false, 1, null), new Func3<StoreStickers.StickerPackState, Integer, MeUser, StoreState>() { // from class: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func3
                public /* bridge */ /* synthetic */ StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, Integer num, MeUser meUser) {
                    return call(stickerPackState, num.intValue(), meUser);
                }

                public final StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, int i, MeUser meUser) {
                    C12238m.checkNotNullParameter(stickerPackState, "stickerPack");
                    C12238m.checkNotNullParameter(meUser, "meUser");
                    return new StickerPackStoreSheetViewModel.StoreState(stickerPackState, i, meUser);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…ser\n          )\n        }");
            return observableM11075i;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final User meUser;
        private final int stickerAnimationSettings;
        private final StoreStickers.StickerPackState stickerPack;

        public StoreState(StoreStickers.StickerPackState stickerPackState, int i, User user) {
            C12238m.checkNotNullParameter(stickerPackState, "stickerPack");
            C12238m.checkNotNullParameter(user, "meUser");
            this.stickerPack = stickerPackState;
            this.stickerAnimationSettings = i;
            this.meUser = user;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreStickers.StickerPackState stickerPackState, int i, User user, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                stickerPackState = storeState.stickerPack;
            }
            if ((i2 & 2) != 0) {
                i = storeState.stickerAnimationSettings;
            }
            if ((i2 & 4) != 0) {
                user = storeState.meUser;
            }
            return storeState.copy(stickerPackState, i, user);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStickerAnimationSettings() {
            return this.stickerAnimationSettings;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final User getMeUser() {
            return this.meUser;
        }

        public final StoreState copy(StoreStickers.StickerPackState stickerPack, int stickerAnimationSettings, User meUser) {
            C12238m.checkNotNullParameter(stickerPack, "stickerPack");
            C12238m.checkNotNullParameter(meUser, "meUser");
            return new StoreState(stickerPack, stickerAnimationSettings, meUser);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.stickerPack, storeState.stickerPack) && this.stickerAnimationSettings == storeState.stickerAnimationSettings && C12238m.areEqual(this.meUser, storeState.meUser);
        }

        public final User getMeUser() {
            return this.meUser;
        }

        public final int getStickerAnimationSettings() {
            return this.stickerAnimationSettings;
        }

        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        public int hashCode() {
            StoreStickers.StickerPackState stickerPackState = this.stickerPack;
            int iHashCode = (((stickerPackState != null ? stickerPackState.hashCode() : 0) * 31) + this.stickerAnimationSettings) * 31;
            User user = this.meUser;
            return iHashCode + (user != null ? user.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(stickerPack=");
            sbM833U.append(this.stickerPack);
            sbM833U.append(", stickerAnimationSettings=");
            sbM833U.append(this.stickerAnimationSettings);
            sbM833U.append(", meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean isPackEnabled;
        private final PremiumTier meUserPremiumTier;
        private final List<MGRecyclerDataPayload> stickerItems;
        private final ModelStickerPack stickerPack;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(ModelStickerPack modelStickerPack, List<? extends MGRecyclerDataPayload> list, PremiumTier premiumTier, boolean z2) {
            C12238m.checkNotNullParameter(modelStickerPack, "stickerPack");
            C12238m.checkNotNullParameter(list, "stickerItems");
            C12238m.checkNotNullParameter(premiumTier, "meUserPremiumTier");
            this.stickerPack = modelStickerPack;
            this.stickerItems = list;
            this.meUserPremiumTier = premiumTier;
            this.isPackEnabled = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, ModelStickerPack modelStickerPack, List list, PremiumTier premiumTier, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = viewState.stickerPack;
            }
            if ((i & 2) != 0) {
                list = viewState.stickerItems;
            }
            if ((i & 4) != 0) {
                premiumTier = viewState.meUserPremiumTier;
            }
            if ((i & 8) != 0) {
                z2 = viewState.isPackEnabled;
            }
            return viewState.copy(modelStickerPack, list, premiumTier, z2);
        }

        public final boolean canUserAccessToPremiumStickers() {
            return PremiumUtilsKt.grantsAccessToPremiumStickers(this.meUserPremiumTier);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelStickerPack getStickerPack() {
            return this.stickerPack;
        }

        public final List<MGRecyclerDataPayload> component2() {
            return this.stickerItems;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsPackEnabled() {
            return this.isPackEnabled;
        }

        public final ViewState copy(ModelStickerPack stickerPack, List<? extends MGRecyclerDataPayload> stickerItems, PremiumTier meUserPremiumTier, boolean isPackEnabled) {
            C12238m.checkNotNullParameter(stickerPack, "stickerPack");
            C12238m.checkNotNullParameter(stickerItems, "stickerItems");
            C12238m.checkNotNullParameter(meUserPremiumTier, "meUserPremiumTier");
            return new ViewState(stickerPack, stickerItems, meUserPremiumTier, isPackEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(this.stickerPack, viewState.stickerPack) && C12238m.areEqual(this.stickerItems, viewState.stickerItems) && C12238m.areEqual(this.meUserPremiumTier, viewState.meUserPremiumTier) && this.isPackEnabled == viewState.isPackEnabled;
        }

        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        public final List<MGRecyclerDataPayload> getStickerItems() {
            return this.stickerItems;
        }

        public final ModelStickerPack getStickerPack() {
            return this.stickerPack;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            ModelStickerPack modelStickerPack = this.stickerPack;
            int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
            List<MGRecyclerDataPayload> list = this.stickerItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            PremiumTier premiumTier = this.meUserPremiumTier;
            int iHashCode3 = (iHashCode2 + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
            boolean z2 = this.isPackEnabled;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public final boolean isPackEnabled() {
            return this.isPackEnabled;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(stickerPack=");
            sbM833U.append(this.stickerPack);
            sbM833U.append(", stickerItems=");
            sbM833U.append(this.stickerItems);
            sbM833U.append(", meUserPremiumTier=");
            sbM833U.append(this.meUserPremiumTier);
            sbM833U.append(", isPackEnabled=");
            return C1643a.m827O(sbM833U, this.isPackEnabled, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StickerPackStoreSheetViewType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[StickerPackStoreSheetViewType.STICKER_POPOUT_VIEW_ALL.ordinal()] = 1;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerPackStoreSheetViewModel(long j, StoreStickers storeStickers, StickerPackStoreSheetAnalytics stickerPackStoreSheetAnalytics, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeStickers = (i & 2) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStoreState(j, storeStickers, companion2.getUserSettings(), companion2.getUsers());
        }
        this(j, storeStickers, stickerPackStoreSheetAnalytics, observable);
    }

    private final void handleLoadedStoreState(StoreState storeState) {
        int stickerAnimationSettings = storeState.getStickerAnimationSettings();
        User meUser = storeState.getMeUser();
        ArrayList arrayList = new ArrayList();
        StoreStickers.StickerPackState stickerPack = storeState.getStickerPack();
        Objects.requireNonNull(stickerPack, "null cannot be cast to non-null type com.discord.stores.StoreStickers.StickerPackState.Loaded");
        ModelStickerPack stickerPack2 = ((StoreStickers.StickerPackState.Loaded) stickerPack).getStickerPack();
        arrayList.addAll(INSTANCE.buildStoreStickerListItems(stickerPack2, stickerAnimationSettings, storeState.getMeUser()));
        PremiumTier premiumTier = meUser.getPremiumTier();
        List<ModelStickerPack> enabledStickerPacks = this.stickersStore.getEnabledStickerPacks();
        boolean z2 = true;
        if ((enabledStickerPacks instanceof Collection) && enabledStickerPacks.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = enabledStickerPacks.iterator();
            while (it.hasNext()) {
                if (((ModelStickerPack) it.next()).getId() == this.stickerPackId) {
                }
            }
            z2 = false;
        }
        updateViewState(new ViewState(stickerPack2, arrayList, premiumTier, z2));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState.getStickerPack() instanceof StoreStickers.StickerPackState.Loaded) {
            handleLoadedStoreState(storeState);
        }
    }

    private final void trackStickerPackStoreSheetViewed() {
        AnalyticsTracker.INSTANCE.stickerPackViewAllViewed(this.analytics.getSticker(), this.analytics.getType().ordinal() != 0 ? "Sticker Pack Detail Sheet" : "Sticker Pack Detail Sheet (Sticker Upsell Popout)", this.analytics.getLocation(), new Traits.Location(null, this.analytics.getLocation(), null, null, null, 29, null));
    }

    public final void fetchStickersData() {
        this.stickersStore.fetchStickerPack(this.stickerPackId);
        this.stickersStore.fetchEnabledStickerDirectory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPackStoreSheetViewModel(long j, StoreStickers storeStickers, StickerPackStoreSheetAnalytics stickerPackStoreSheetAnalytics, Observable<StoreState> observable) {
        super(null);
        C12238m.checkNotNullParameter(storeStickers, "stickersStore");
        C12238m.checkNotNullParameter(stickerPackStoreSheetAnalytics, "analytics");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.stickerPackId = j;
        this.stickersStore = storeStickers;
        this.analytics = stickerPackStoreSheetAnalytics;
        fetchStickersData();
        trackStickerPackStoreSheetViewed();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) StickerPackStoreSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78931());
    }
}
