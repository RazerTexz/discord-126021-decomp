package com.discord.widgets.stickers;

import androidx.annotation.MainThread;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.PremiumUtilsKt;
import com.discord.widgets.stickers.StickerSheetViewModel;
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
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: StickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean hasFiredAnalytics;
    private final String location;
    private final Sticker sticker;
    private final StoreStickers storeStickers;
    private final StoreUser storeUser;

    /* JADX INFO: renamed from: com.discord.widgets.stickers.StickerSheetViewModel$1 */
    /* JADX INFO: compiled from: StickerSheetViewModel.kt */
    public static final class C101301 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C101301() {
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
            StickerSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: StickerSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreStickers storeStickers, StoreUser storeUser, Sticker sticker) {
            Long packId = sticker.getPackId();
            C12238m.checkNotNull(packId);
            Observable<StoreState> observableM11076j = Observable.m11076j(storeStickers.observeStickerPack(packId.longValue()), StoreUser.observeMe$default(storeUser, false, 1, null), new Func2<StoreStickers.StickerPackState, MeUser, StoreState>() { // from class: com.discord.widgets.stickers.StickerSheetViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func2
                public final StickerSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, MeUser meUser) {
                    C12238m.checkNotNullParameter(stickerPackState, "stickerPack");
                    C12238m.checkNotNullParameter(meUser, "meUser");
                    return new StickerSheetViewModel.StoreState(stickerPackState, meUser);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…ser\n          )\n        }");
            return observableM11076j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StickerSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final MeUser meUser;
        private final StoreStickers.StickerPackState stickerPack;

        public StoreState(StoreStickers.StickerPackState stickerPackState, MeUser meUser) {
            C12238m.checkNotNullParameter(stickerPackState, "stickerPack");
            C12238m.checkNotNullParameter(meUser, "meUser");
            this.stickerPack = stickerPackState;
            this.meUser = meUser;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreStickers.StickerPackState stickerPackState, MeUser meUser, int i, Object obj) {
            if ((i & 1) != 0) {
                stickerPackState = storeState.stickerPack;
            }
            if ((i & 2) != 0) {
                meUser = storeState.meUser;
            }
            return storeState.copy(stickerPackState, meUser);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final StoreState copy(StoreStickers.StickerPackState stickerPack, MeUser meUser) {
            C12238m.checkNotNullParameter(stickerPack, "stickerPack");
            C12238m.checkNotNullParameter(meUser, "meUser");
            return new StoreState(stickerPack, meUser);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.stickerPack, storeState.stickerPack) && C12238m.areEqual(this.meUser, storeState.meUser);
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        public int hashCode() {
            StoreStickers.StickerPackState stickerPackState = this.stickerPack;
            int iHashCode = (stickerPackState != null ? stickerPackState.hashCode() : 0) * 31;
            MeUser meUser = this.meUser;
            return iHashCode + (meUser != null ? meUser.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(stickerPack=");
            sbM833U.append(this.stickerPack);
            sbM833U.append(", meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: StickerSheetViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean canUsePremiumStickers;
        private final boolean isStickerPackEnabled;
        private final PremiumTier meUserPremiumTier;
        private final Sticker sticker;
        private final ModelStickerPack stickerPack;

        public ViewState(ModelStickerPack modelStickerPack, Sticker sticker, PremiumTier premiumTier, boolean z2) {
            C12238m.checkNotNullParameter(modelStickerPack, "stickerPack");
            C12238m.checkNotNullParameter(sticker, "sticker");
            C12238m.checkNotNullParameter(premiumTier, "meUserPremiumTier");
            this.stickerPack = modelStickerPack;
            this.sticker = sticker;
            this.meUserPremiumTier = premiumTier;
            this.isStickerPackEnabled = z2;
            this.canUsePremiumStickers = PremiumUtilsKt.grantsAccessToPremiumStickers(premiumTier);
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, ModelStickerPack modelStickerPack, Sticker sticker, PremiumTier premiumTier, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = viewState.stickerPack;
            }
            if ((i & 2) != 0) {
                sticker = viewState.sticker;
            }
            if ((i & 4) != 0) {
                premiumTier = viewState.meUserPremiumTier;
            }
            if ((i & 8) != 0) {
                z2 = viewState.isStickerPackEnabled;
            }
            return viewState.copy(modelStickerPack, sticker, premiumTier, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelStickerPack getStickerPack() {
            return this.stickerPack;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Sticker getSticker() {
            return this.sticker;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsStickerPackEnabled() {
            return this.isStickerPackEnabled;
        }

        public final ViewState copy(ModelStickerPack stickerPack, Sticker sticker, PremiumTier meUserPremiumTier, boolean isStickerPackEnabled) {
            C12238m.checkNotNullParameter(stickerPack, "stickerPack");
            C12238m.checkNotNullParameter(sticker, "sticker");
            C12238m.checkNotNullParameter(meUserPremiumTier, "meUserPremiumTier");
            return new ViewState(stickerPack, sticker, meUserPremiumTier, isStickerPackEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(this.stickerPack, viewState.stickerPack) && C12238m.areEqual(this.sticker, viewState.sticker) && C12238m.areEqual(this.meUserPremiumTier, viewState.meUserPremiumTier) && this.isStickerPackEnabled == viewState.isStickerPackEnabled;
        }

        public final boolean getCanUsePremiumStickers() {
            return this.canUsePremiumStickers;
        }

        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        public final Sticker getSticker() {
            return this.sticker;
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
            Sticker sticker = this.sticker;
            int iHashCode2 = (iHashCode + (sticker != null ? sticker.hashCode() : 0)) * 31;
            PremiumTier premiumTier = this.meUserPremiumTier;
            int iHashCode3 = (iHashCode2 + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
            boolean z2 = this.isStickerPackEnabled;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public final boolean isStickerPackEnabled() {
            return this.isStickerPackEnabled;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(stickerPack=");
            sbM833U.append(this.stickerPack);
            sbM833U.append(", sticker=");
            sbM833U.append(this.sticker);
            sbM833U.append(", meUserPremiumTier=");
            sbM833U.append(this.meUserPremiumTier);
            sbM833U.append(", isStickerPackEnabled=");
            return C1643a.m827O(sbM833U, this.isStickerPackEnabled, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerSheetViewModel(Sticker sticker, StoreStickers storeStickers, StoreUser storeUser, String str, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreStickers stickers = (i & 2) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers;
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(sticker, stickers, users, str, (i & 16) != 0 ? INSTANCE.observeStoreState(stickers, users, sticker) : observable);
    }

    private final void fetchStickersData() {
        StoreStickers storeStickers = this.storeStickers;
        Long packId = this.sticker.getPackId();
        C12238m.checkNotNull(packId);
        storeStickers.fetchStickerPack(packId.longValue());
        this.storeStickers.fetchEnabledStickerDirectory();
    }

    private final void handleLoadedStoreState(StoreState storeState) {
        boolean z2;
        MeUser meUser = storeState.getMeUser();
        StoreStickers.StickerPackState stickerPack = storeState.getStickerPack();
        Objects.requireNonNull(stickerPack, "null cannot be cast to non-null type com.discord.stores.StoreStickers.StickerPackState.Loaded");
        ModelStickerPack stickerPack2 = ((StoreStickers.StickerPackState.Loaded) stickerPack).getStickerPack();
        if (!this.hasFiredAnalytics && this.location != null) {
            StickerPurchaseLocation popoutPurchaseLocation = StickerPurchaseLocation.INSTANCE.getPopoutPurchaseLocation(stickerPack2.canBePurchased());
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Long packId = this.sticker.getPackId();
            C12238m.checkNotNull(packId);
            analyticsTracker.stickerPopoutOpened(packId.longValue(), this.location, new Traits.Location(null, popoutPurchaseLocation.getAnalyticsValue(), null, null, null, 29, null));
            this.hasFiredAnalytics = true;
        }
        Sticker sticker = this.sticker;
        PremiumTier premiumTier = meUser.getPremiumTier();
        List<ModelStickerPack> enabledStickerPacks = this.storeStickers.getEnabledStickerPacks();
        boolean z3 = false;
        if (!(enabledStickerPacks instanceof Collection) || !enabledStickerPacks.isEmpty()) {
            Iterator<T> it = enabledStickerPacks.iterator();
            while (it.hasNext()) {
                List<Sticker> stickers = ((ModelStickerPack) it.next()).getStickers();
                if (!(stickers instanceof Collection) || !stickers.isEmpty()) {
                    Iterator<T> it2 = stickers.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = false;
                            break;
                        } else {
                            if (((Sticker) it2.next()).getId() == this.sticker.getId()) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                } else {
                    z2 = false;
                    break;
                    break;
                }
                if (z2) {
                    z3 = true;
                    break;
                }
            }
        }
        updateViewState(new ViewState(stickerPack2, sticker, premiumTier, z3));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState.getStickerPack() instanceof StoreStickers.StickerPackState.Loaded) {
            handleLoadedStoreState(storeState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerSheetViewModel(Sticker sticker, StoreStickers storeStickers, StoreUser storeUser, String str, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(sticker, "sticker");
        C12238m.checkNotNullParameter(storeStickers, "storeStickers");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.sticker = sticker;
        this.storeStickers = storeStickers;
        this.storeUser = storeUser;
        this.location = str;
        fetchStickersData();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) StickerSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101301());
    }
}
