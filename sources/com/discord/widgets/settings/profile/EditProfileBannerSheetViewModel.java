package com.discord.widgets.settings.profile;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.user.UserProfile;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EditProfileBannerSheetViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String defaultBannerColorHex;
    private final String initialColorPreviewHex;
    private boolean upsellViewedTracked;

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
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
            EditProfileBannerSheetViewModel editProfileBannerSheetViewModel = EditProfileBannerSheetViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            editProfileBannerSheetViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreUser storeUser, StoreUserProfile storeUserProfile) {
            return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{StoreUser.INSTANCE.getMeUpdate(), storeUserProfile}, false, null, null, new EditProfileBannerSheetViewModel2(storeUser, storeUserProfile), 14, null);
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreUser storeUser, StoreUserProfile storeUserProfile, int i, Object obj) {
            if ((i & 1) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            if ((i & 2) != 0) {
                storeUserProfile = StoreStream.INSTANCE.getUserProfile();
            }
            return companion.observeStoreState(storeUser, storeUserProfile);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final User user;
        private final UserProfile userProfile;

        public StoreState(User user, UserProfile userProfile) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            this.user = user;
            this.userProfile = userProfile;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, User user, UserProfile userProfile, int i, Object obj) {
            if ((i & 1) != 0) {
                user = storeState.user;
            }
            if ((i & 2) != 0) {
                userProfile = storeState.userProfile;
            }
            return storeState.copy(user, userProfile);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public final StoreState copy(User user, UserProfile userProfile) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            return new StoreState(user, userProfile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.userProfile, storeState.userProfile);
        }

        public final User getUser() {
            return this.user;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            UserProfile userProfile = this.userProfile;
            return iHashCode + (userProfile != null ? userProfile.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", userProfile=");
            sbU.append(this.userProfile);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
    public static final /* data */ class ViewState {
        private final String bannerColorHex;
        private final boolean showPremiumUpsell;

        public ViewState(String str, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, "bannerColorHex");
            this.bannerColorHex = str;
            this.showPremiumUpsell = z2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewState.bannerColorHex;
            }
            if ((i & 2) != 0) {
                z2 = viewState.showPremiumUpsell;
            }
            return viewState.copy(str, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBannerColorHex() {
            return this.bannerColorHex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShowPremiumUpsell() {
            return this.showPremiumUpsell;
        }

        public final ViewState copy(String bannerColorHex, boolean showPremiumUpsell) {
            Intrinsics3.checkNotNullParameter(bannerColorHex, "bannerColorHex");
            return new ViewState(bannerColorHex, showPremiumUpsell);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.bannerColorHex, viewState.bannerColorHex) && this.showPremiumUpsell == viewState.showPremiumUpsell;
        }

        public final String getBannerColorHex() {
            return this.bannerColorHex;
        }

        public final boolean getShowPremiumUpsell() {
            return this.showPremiumUpsell;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            String str = this.bannerColorHex;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.showPremiumUpsell;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(bannerColorHex=");
            sbU.append(this.bannerColorHex);
            sbU.append(", showPremiumUpsell=");
            return outline.O(sbU, this.showPremiumUpsell, ")");
        }
    }

    public /* synthetic */ EditProfileBannerSheetViewModel(String str, String str2, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, 3, null) : observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ViewState viewState = getViewState();
        String bannerColorHex = viewState != null ? viewState.getBannerColorHex() : null;
        User user = storeState.getUser();
        if (bannerColorHex == null) {
            bannerColorHex = this.initialColorPreviewHex;
        }
        if (bannerColorHex == null) {
            bannerColorHex = this.defaultBannerColorHex;
        }
        updateViewState(new ViewState(bannerColorHex, !UserUtils.INSTANCE.isPremiumTier2(user)));
    }

    public final boolean getUpsellViewedTracked() {
        return this.upsellViewedTracked;
    }

    public final void setUpsellViewedTracked(boolean z2) {
        this.upsellViewedTracked = z2;
    }

    @MainThread
    public final void updateColorPreview(String colorHex) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (colorHex == null) {
                colorHex = this.defaultBannerColorHex;
            }
            updateViewState(ViewState.copy$default(viewState, colorHex, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProfileBannerSheetViewModel(String str, String str2, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(str, "defaultBannerColorHex");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.defaultBannerColorHex = str;
        this.initialColorPreviewHex = str2;
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) EditProfileBannerSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
