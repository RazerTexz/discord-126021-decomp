package com.discord.widgets.chat.input.sticker;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
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
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.widgets.chat.input.sticker.StickerAdapterItems3;
import com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StickerPackStoreSheetViewModel2 analytics;
    private final long stickerPackId;
    private final StoreStickers stickersStore;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
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
                return Collections2.emptyList();
            }
            arrayList.add(new StickerAdapterItems4(stickerPack, false));
            for (Sticker sticker : stickerPack.getStickers()) {
                arrayList.add(new StickerAdapterItems3(sticker, stickerAnimationSettings, StickerAdapterItems3.Mode.STORE, StickerUtils.getStickerSendability$default(StickerUtils.INSTANCE, sticker, meUser, null, null, 12, null)));
            }
            return arrayList;
        }

        private final Observable<StoreState> observeStoreState(long stickerPackId, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser) {
            Observable<StoreState> observableI = Observable.i(storeStickers.observeStickerPack(stickerPackId), StoreUserSettings.observeStickerAnimationSettings$default(storeUserSettings, false, 1, null), StoreUser.observeMe$default(storeUser, false, 1, null), new Func3<StoreStickers.StickerPackState, Integer, MeUser, StoreState>() { // from class: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func3
                public /* bridge */ /* synthetic */ StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, Integer num, MeUser meUser) {
                    return call(stickerPackState, num.intValue(), meUser);
                }

                public final StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, int i, MeUser meUser) {
                    Intrinsics3.checkNotNullParameter(stickerPackState, "stickerPack");
                    Intrinsics3.checkNotNullParameter(meUser, "meUser");
                    return new StickerPackStoreSheetViewModel.StoreState(stickerPackState, i, meUser);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ser\n          )\n        }");
            return observableI;
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
            Intrinsics3.checkNotNullParameter(stickerPackState, "stickerPack");
            Intrinsics3.checkNotNullParameter(user, "meUser");
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
            Intrinsics3.checkNotNullParameter(stickerPack, "stickerPack");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
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
            return Intrinsics3.areEqual(this.stickerPack, storeState.stickerPack) && this.stickerAnimationSettings == storeState.stickerAnimationSettings && Intrinsics3.areEqual(this.meUser, storeState.meUser);
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
            StringBuilder sbU = outline.U("StoreState(stickerPack=");
            sbU.append(this.stickerPack);
            sbU.append(", stickerAnimationSettings=");
            sbU.append(this.stickerAnimationSettings);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(")");
            return sbU.toString();
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
            Intrinsics3.checkNotNullParameter(modelStickerPack, "stickerPack");
            Intrinsics3.checkNotNullParameter(list, "stickerItems");
            Intrinsics3.checkNotNullParameter(premiumTier, "meUserPremiumTier");
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
            return PremiumUtils3.grantsAccessToPremiumStickers(this.meUserPremiumTier);
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
            Intrinsics3.checkNotNullParameter(stickerPack, "stickerPack");
            Intrinsics3.checkNotNullParameter(stickerItems, "stickerItems");
            Intrinsics3.checkNotNullParameter(meUserPremiumTier, "meUserPremiumTier");
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
            return Intrinsics3.areEqual(this.stickerPack, viewState.stickerPack) && Intrinsics3.areEqual(this.stickerItems, viewState.stickerItems) && Intrinsics3.areEqual(this.meUserPremiumTier, viewState.meUserPremiumTier) && this.isPackEnabled == viewState.isPackEnabled;
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
            StringBuilder sbU = outline.U("ViewState(stickerPack=");
            sbU.append(this.stickerPack);
            sbU.append(", stickerItems=");
            sbU.append(this.stickerItems);
            sbU.append(", meUserPremiumTier=");
            sbU.append(this.meUserPremiumTier);
            sbU.append(", isPackEnabled=");
            return outline.O(sbU, this.isPackEnabled, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetStickerPackStoreSheet2.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetStickerPackStoreSheet2.STICKER_POPOUT_VIEW_ALL.ordinal()] = 1;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerPackStoreSheetViewModel(long j, StoreStickers storeStickers, StickerPackStoreSheetViewModel2 stickerPackStoreSheetViewModel2, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeStickers = (i & 2) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStoreState(j, storeStickers, companion2.getUserSettings(), companion2.getUsers());
        }
        this(j, storeStickers, stickerPackStoreSheetViewModel2, observable);
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
    public StickerPackStoreSheetViewModel(long j, StoreStickers storeStickers, StickerPackStoreSheetViewModel2 stickerPackStoreSheetViewModel2, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(storeStickers, "stickersStore");
        Intrinsics3.checkNotNullParameter(stickerPackStoreSheetViewModel2, "analytics");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.stickerPackId = j;
        this.stickersStore = storeStickers;
        this.analytics = stickerPackStoreSheetViewModel2;
        fetchStickersData();
        trackStickerPackStoreSheetViewed();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) StickerPackStoreSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
