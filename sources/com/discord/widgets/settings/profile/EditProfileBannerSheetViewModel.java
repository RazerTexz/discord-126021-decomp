package com.discord.widgets.settings.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.models.user.User;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EditProfileBannerSheetViewModel extends d0<EditProfileBannerSheetViewModel$ViewState> {
    public static final EditProfileBannerSheetViewModel$Companion Companion = new EditProfileBannerSheetViewModel$Companion(null);
    private final String defaultBannerColorHex;
    private final String initialColorPreviewHex;
    private boolean upsellViewedTracked;

    public /* synthetic */ EditProfileBannerSheetViewModel(String str, String str2, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? EditProfileBannerSheetViewModel$Companion.observeStoreState$default(Companion, null, null, 3, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(EditProfileBannerSheetViewModel editProfileBannerSheetViewModel, EditProfileBannerSheetViewModel$StoreState editProfileBannerSheetViewModel$StoreState) {
        editProfileBannerSheetViewModel.handleStoreState(editProfileBannerSheetViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(EditProfileBannerSheetViewModel$StoreState storeState) {
        EditProfileBannerSheetViewModel$ViewState viewState = getViewState();
        String bannerColorHex = viewState != null ? viewState.getBannerColorHex() : null;
        User user = storeState.getUser();
        if (bannerColorHex == null) {
            bannerColorHex = this.initialColorPreviewHex;
        }
        if (bannerColorHex == null) {
            bannerColorHex = this.defaultBannerColorHex;
        }
        updateViewState(new EditProfileBannerSheetViewModel$ViewState(bannerColorHex, !UserUtils.INSTANCE.isPremiumTier2(user)));
    }

    public final boolean getUpsellViewedTracked() {
        return this.upsellViewedTracked;
    }

    public final void setUpsellViewedTracked(boolean z2) {
        this.upsellViewedTracked = z2;
    }

    @MainThread
    public final void updateColorPreview(String colorHex) {
        EditProfileBannerSheetViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            if (colorHex == null) {
                colorHex = this.defaultBannerColorHex;
            }
            updateViewState(EditProfileBannerSheetViewModel$ViewState.copy$default(viewState, colorHex, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProfileBannerSheetViewModel(String str, String str2, Observable<EditProfileBannerSheetViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(str, "defaultBannerColorHex");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.defaultBannerColorHex = str;
        this.initialColorPreviewHex = str2;
        Observable<EditProfileBannerSheetViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), EditProfileBannerSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new EditProfileBannerSheetViewModel$1(this), 62, (Object) null);
    }
}
