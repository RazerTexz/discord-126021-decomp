package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.restapi.RestAPIParams$EnableMFA;
import com.discord.stores.StoreMFA$MFAActivationState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetEnableMFAViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAViewModel extends d0<WidgetEnableMFAViewModel$ViewState> {
    private String encodedTotpSecret;
    private String password;
    private CompositeSubscription subs;
    private String totpSecret;

    public WidgetEnableMFAViewModel() {
        super(new WidgetEnableMFAViewModel$ViewState(false, 0));
        this.subs = new CompositeSubscription();
    }

    public static final /* synthetic */ CompositeSubscription access$getSubs$p(WidgetEnableMFAViewModel widgetEnableMFAViewModel) {
        return widgetEnableMFAViewModel.subs;
    }

    public static final /* synthetic */ void access$handleMFAFailure(WidgetEnableMFAViewModel widgetEnableMFAViewModel) {
        widgetEnableMFAViewModel.handleMFAFailure();
    }

    public static final /* synthetic */ void access$handleMFASuccess(WidgetEnableMFAViewModel widgetEnableMFAViewModel, String str) {
        widgetEnableMFAViewModel.handleMFASuccess(str);
    }

    public static final /* synthetic */ void access$setSubs$p(WidgetEnableMFAViewModel widgetEnableMFAViewModel, CompositeSubscription compositeSubscription) {
        widgetEnableMFAViewModel.subs = compositeSubscription;
    }

    @MainThread
    private final void handleMFAFailure() {
        updateViewState(new WidgetEnableMFAViewModel$ViewState(false, 2));
    }

    @MainThread
    private final void handleMFASuccess(String token) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getAuthentication().setAuthed(token);
        updateViewState(new WidgetEnableMFAViewModel$ViewState(false, 3));
        storeStream$Companion.getMFA().updatePendingMFAState(StoreMFA$MFAActivationState.PENDING_ENABLED);
    }

    @MainThread
    public final void enableMFA(Context context, String mfaCode) {
        String str;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(mfaCode, "mfaCode");
        updateViewState(new WidgetEnableMFAViewModel$ViewState(true, null));
        RestAPI api = RestAPI.Companion.getApi();
        String str2 = this.encodedTotpSecret;
        if (str2 == null || (str = this.password) == null) {
            return;
        }
        Observable<EnableMfaResponse> observableQ = api.enableMFA(new RestAPIParams$EnableMFA(mfaCode, str2, str)).q(2000L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableQ, "RestAPI\n        .api\n   …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableQ, false, 1, null), this, null, 2, null), WidgetEnableMFAViewModel.class, context, new WidgetEnableMFAViewModel$enableMFA$3(this), new WidgetEnableMFAViewModel$enableMFA$2(this), (Function0) null, (Function0) null, new WidgetEnableMFAViewModel$enableMFA$1(this), 48, (Object) null);
    }

    @MainThread
    public final String getPassword() {
        return this.password;
    }

    @MainThread
    public final String getTotpSecret() {
        return this.totpSecret;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        this.subs.b();
    }

    @MainThread
    public final void setPassword(String password) {
        m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.password = password;
    }

    @MainThread
    public final void setTotpSecret(String secret) {
        m.checkNotNullParameter(secret, "secret");
        this.totpSecret = secret;
        AuthUtils authUtils = AuthUtils.INSTANCE;
        if (secret != null) {
            this.encodedTotpSecret = authUtils.encodeTotpSecret(secret);
        }
    }

    @MainThread
    public final void updateScreenIndex(int currentPage) {
        WidgetEnableMFAViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetEnableMFAViewModel$ViewState.copy$default(viewState, false, Integer.valueOf(currentPage), 1, null));
        }
    }
}
