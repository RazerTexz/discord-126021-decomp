package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreMFA;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import java.util.concurrent.TimeUnit;
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
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetEnableMFAViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAViewModel extends AbstractC0859d0<ViewState> {
    private String encodedTotpSecret;
    private String password;
    private CompositeSubscription subs;
    private String totpSecret;

    /* JADX INFO: compiled from: WidgetEnableMFAViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final Integer screenIndex;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public ViewState(boolean z2, Integer num) {
            this.isLoading = z2;
            this.screenIndex = num;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.isLoading;
            }
            if ((i & 2) != 0) {
                num = viewState.screenIndex;
            }
            return viewState.copy(z2, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getScreenIndex() {
            return this.screenIndex;
        }

        public final ViewState copy(boolean isLoading, Integer screenIndex) {
            return new ViewState(isLoading, screenIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && C12238m.areEqual(this.screenIndex, viewState.screenIndex);
        }

        public final Integer getScreenIndex() {
            return this.screenIndex;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isLoading;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Integer num = this.screenIndex;
            return i + (num != null ? num.hashCode() : 0);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(isLoading=");
            sbM833U.append(this.isLoading);
            sbM833U.append(", screenIndex=");
            return C1643a.m818F(sbM833U, this.screenIndex, ")");
        }

        public /* synthetic */ ViewState(boolean z2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : num);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel$enableMFA$1 */
    /* JADX INFO: compiled from: WidgetEnableMFAViewModel.kt */
    public static final class C98011 extends AbstractC12240o implements Function1<EnableMfaResponse, Unit> {
        public C98011() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EnableMfaResponse enableMfaResponse) {
            invoke2(enableMfaResponse);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EnableMfaResponse enableMfaResponse) {
            WidgetEnableMFAViewModel.this.handleMFASuccess(enableMfaResponse.getToken());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel$enableMFA$2 */
    /* JADX INFO: compiled from: WidgetEnableMFAViewModel.kt */
    public static final class C98022 extends AbstractC12240o implements Function1<Error, Unit> {
        public C98022() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            WidgetEnableMFAViewModel.this.handleMFAFailure();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel$enableMFA$3 */
    /* JADX INFO: compiled from: WidgetEnableMFAViewModel.kt */
    public static final class C98033 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C98033() {
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
            WidgetEnableMFAViewModel.this.subs.m11136a(subscription);
        }
    }

    public WidgetEnableMFAViewModel() {
        super(new ViewState(false, 0));
        this.subs = new CompositeSubscription();
    }

    @MainThread
    private final void handleMFAFailure() {
        updateViewState(new ViewState(false, 2));
    }

    @MainThread
    private final void handleMFASuccess(String token) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getAuthentication().setAuthed(token);
        updateViewState(new ViewState(false, 3));
        companion.getMFA().updatePendingMFAState(StoreMFA.MFAActivationState.PENDING_ENABLED);
    }

    @MainThread
    public final void enableMFA(Context context, String mfaCode) {
        String str;
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(mfaCode, "mfaCode");
        updateViewState(new ViewState(true, null));
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str2 = this.encodedTotpSecret;
        if (str2 == null || (str = this.password) == null) {
            return;
        }
        Observable<EnableMfaResponse> observableM11111q = api.enableMFA(new RestAPIParams.EnableMFA(mfaCode, str2, str)).m11111q(2000L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11111q, "RestAPI\n        .api\n   …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableM11111q, false, 1, null), this, null, 2, null), (Class<?>) WidgetEnableMFAViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C98033()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C98022()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98011());
    }

    @MainThread
    public final String getPassword() {
        return this.password;
    }

    @MainThread
    public final String getTotpSecret() {
        return this.totpSecret;
    }

    @Override // p007b.p008a.p018d.AbstractC0859d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        this.subs.m11137b();
    }

    @MainThread
    public final void setPassword(String password) {
        C12238m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.password = password;
    }

    @MainThread
    public final void setTotpSecret(String secret) {
        C12238m.checkNotNullParameter(secret, "secret");
        this.totpSecret = secret;
        AuthUtils authUtils = AuthUtils.INSTANCE;
        if (secret != null) {
            this.encodedTotpSecret = authUtils.encodeTotpSecret(secret);
        }
    }

    @MainThread
    public final void updateScreenIndex(int currentPage) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, Integer.valueOf(currentPage), 1, null));
        }
    }
}
