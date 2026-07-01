package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.m;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthLoginBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$AuthLogin$LoginSource;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManager$SmartLockCredentials;
import com.discord.utilities.auth.GoogleSmartLockManagerKt;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.g0.t;
import d0.t.u;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthLogin.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLoginBinding;", 0)};
    public static final WidgetAuthLogin$Companion Companion = new WidgetAuthLogin$Companion(null);
    public static final String GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID = "smartlock_extra_id";
    public static final String GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD = "smartlock_extra_password";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaForgotPasswordLauncher;
    private final ActivityResultLauncher<Intent> captchaLoginLauncher;
    public GoogleSmartLockManager googleSmartLockManager;
    private final LoggingConfig loggingConfig;
    private final ActivityResultLauncher<Intent> phoneVerifyLoginLauncher;
    private final ActivityResultLauncher<Intent> phoneVerifyPasswordLauncher;
    private GoogleSmartLockManager$SmartLockCredentials smartLockCredentials;
    private final ActivityResultLauncher<Intent> undeleteAccountLauncher;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    public WidgetAuthLogin() {
        super(R$layout.widget_auth_login);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthLogin$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthLogin$binding$2.INSTANCE, null, 2, null);
        WidgetAuthCaptcha$Companion widgetAuthCaptcha$Companion = WidgetAuthCaptcha.Companion;
        this.captchaForgotPasswordLauncher = widgetAuthCaptcha$Companion.registerForResult(this, new WidgetAuthLogin$captchaForgotPasswordLauncher$1(this));
        this.captchaLoginLauncher = widgetAuthCaptcha$Companion.registerForResult(this, new WidgetAuthLogin$captchaLoginLauncher$1(this));
        WidgetAuthPhoneVerify$Companion widgetAuthPhoneVerify$Companion = WidgetAuthPhoneVerify.Companion;
        this.phoneVerifyLoginLauncher = widgetAuthPhoneVerify$Companion.registerForResult(this, new WidgetAuthLogin$phoneVerifyLoginLauncher$1(this));
        this.phoneVerifyPasswordLauncher = widgetAuthPhoneVerify$Companion.registerForResult(this, new WidgetAuthLogin$phoneVerifyPasswordLauncher$1(this));
        this.undeleteAccountLauncher = WidgetAuthUndeleteAccount.Companion.registerForResult(this, new WidgetAuthLogin$undeleteAccountLauncher$1(this));
        this.validationManager = g.lazy(new WidgetAuthLogin$validationManager$2(this));
    }

    public static final /* synthetic */ void access$forgotPassword(WidgetAuthLogin widgetAuthLogin, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetAuthLogin.forgotPassword(captchaHelper$CaptchaPayload);
    }

    public static final /* synthetic */ WidgetAuthLoginBinding access$getBinding$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCaptchaForgotPasswordLauncher$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.captchaForgotPasswordLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPhoneVerifyPasswordLauncher$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.phoneVerifyPasswordLauncher;
    }

    public static final /* synthetic */ ValidationManager access$getValidationManager$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.getValidationManager();
    }

    public static final /* synthetic */ void access$handleError(WidgetAuthLogin widgetAuthLogin, Error error, String str) {
        widgetAuthLogin.handleError(error, str);
    }

    public static final /* synthetic */ void access$onLoginSuccess(WidgetAuthLogin widgetAuthLogin, String str, String str2) {
        widgetAuthLogin.onLoginSuccess(str, str2);
    }

    public static final /* synthetic */ void access$showEmailSentToast(WidgetAuthLogin widgetAuthLogin, String str) {
        widgetAuthLogin.showEmailSentToast(str);
    }

    private final void forgotPassword(CaptchaHelper$CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().e.getTextOrEmpty();
        if (textOrEmpty.length() == 0) {
            m.g(getContext(), 2131892648, 0, null, 12);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui(StoreStream.Companion.getAuthentication().forgotPassword(textOrEmpty, captchaPayload)), getBinding().h, 0L, 2, null), getContext(), "REST: forgotPassword", (Function1) null, new WidgetAuthLogin$forgotPassword$1(this, textOrEmpty), new WidgetAuthLogin$forgotPassword$2(this, textOrEmpty), (Function0) null, (Function0) null, 100, (Object) null);
        }
    }

    public static /* synthetic */ void forgotPassword$default(WidgetAuthLogin widgetAuthLogin, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetAuthLogin.forgotPassword(captchaHelper$CaptchaPayload);
    }

    private final WidgetAuthLoginBinding getBinding() {
        return (WidgetAuthLoginBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleError(Error error, String login) {
        Error$Response response = error.getResponse();
        d0.z.d.m.checkNotNullExpressionValue(response, "error.response");
        boolean z2 = response.getCode() == 20011;
        boolean z3 = response.getCode() == 20013;
        boolean z4 = response.getCode() == 70007;
        if (response.getCode() == 50035) {
            if (login == null || this.smartLockCredentials == null) {
                return;
            }
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                d0.z.d.m.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onSmartLockCredentialsFailed();
            GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
            if (googleSmartLockManager2 == null) {
                d0.z.d.m.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager2.deleteCredentials(login);
            this.smartLockCredentials = null;
            GoogleSmartLockManagerKt.clearSmartLockCredentials(getMostRecentIntent());
            return;
        }
        if (z2) {
            WidgetAuthUndeleteAccount.Companion.launch(requireContext(), this.undeleteAccountLauncher, false);
            return;
        }
        if (z3) {
            WidgetAuthUndeleteAccount.Companion.launch(requireContext(), this.undeleteAccountLauncher, true);
            return;
        }
        if (z4) {
            WidgetAuthPhoneVerify$Companion widgetAuthPhoneVerify$Companion = WidgetAuthPhoneVerify.Companion;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.phoneVerifyLoginLauncher;
            String textOrEmpty = getBinding().e.getTextOrEmpty();
            String string = getString(2131893785);
            d0.z.d.m.checkNotNullExpressionValue(string, "getString(R.string.phone_ip_authorization_title)");
            String string2 = getString(2131893783);
            d0.z.d.m.checkNotNullExpressionValue(string2, "getString(R.string.phone…p_authorization_subtitle)");
            widgetAuthPhoneVerify$Companion.launch(contextRequireContext, activityResultLauncher, textOrEmpty, string, string2);
            return;
        }
        Error$Response response2 = error.getResponse();
        d0.z.d.m.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getMessages().isEmpty()) {
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Map<String, List<String>> messages = response.getMessages();
        d0.z.d.m.checkNotNullExpressionValue(messages, "errorResponse.messages");
        List<String> mutableList = u.toMutableList((Collection) validationManager.setErrors(messages));
        WidgetAuthCaptcha.Companion.processErrorsForCaptcha(requireContext(), this.captchaLoginLauncher, mutableList, error);
        error.setShowErrorToasts(!mutableList.isEmpty());
    }

    public static /* synthetic */ void handleError$default(WidgetAuthLogin widgetAuthLogin, Error error, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        widgetAuthLogin.handleError(error, str);
    }

    private final void loadCachedLogin() {
        String savedLogin = StoreStream.Companion.getAuthentication().getSavedLogin();
        if (savedLogin == null || !(!t.isBlank(savedLogin))) {
            getBinding().e.requestFocus();
        } else {
            getBinding().e.setText(savedLogin);
            getBinding().g.requestFocus();
        }
    }

    private final void login(CaptchaHelper$CaptchaPayload captchaPayload, boolean undelete) {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            String textOrEmpty = getBinding().e.getTextOrEmpty();
            TextInputLayout textInputLayout = getBinding().g;
            d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
            login(textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout), captchaPayload, undelete);
        }
    }

    public static /* synthetic */ void login$default(WidgetAuthLogin widgetAuthLogin, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        widgetAuthLogin.login(captchaHelper$CaptchaPayload, z2);
    }

    private final void onLoginSuccess(String id2, String password) {
        if (GoogleSmartLockManagerKt.hasSmartLockCredentials(getMostRecentIntent())) {
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                d0.z.d.m.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onLoginWithSmartLockSuccess();
        }
        GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
        if (googleSmartLockManager2 == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        googleSmartLockManager2.saveCredentials(id2, password);
    }

    private final void showEmailSentToast(String email) {
        m.h(getContext(), b.h(requireContext(), 2131888661, new Object[]{email}, null, 4), 0, null, 12);
    }

    public final GoogleSmartLockManager getGoogleSmartLockManager() {
        GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
        if (googleSmartLockManager == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        return googleSmartLockManager;
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final GoogleSmartLockManager$SmartLockCredentials getSmartLockCredentials() {
        return this.smartLockCredentials;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegistrationFlowRepo.Companion.getINSTANCE().setRegistering(false);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        d0.z.d.m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.googleSmartLockManager = new GoogleSmartLockManager(fragmentActivityRequireActivity, null, 2, null);
        this.smartLockCredentials = GoogleSmartLockManagerKt.toSmartLockCredentials(getMostRecentIntent());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getInviteSettings().trackWithInvite$app_productionGoogleRelease(WidgetAuthLogin.class, WidgetAuthLogin$onViewBound$1.INSTANCE);
        loadCachedLogin();
        getBinding().f2232b.setOnClickListener(new WidgetAuthLogin$onViewBound$2(this));
        TextInputLayout textInputLayout = getBinding().g;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new WidgetAuthLogin$onViewBound$3(this), 1, null);
        getBinding().d.setOnClickListener(new WidgetAuthLogin$onViewBound$4(this));
        getBinding().f.setOnClickListener(new WidgetAuthLogin$onViewBound$5(this));
        getBinding().c.setOnClickListener(new WidgetAuthLogin$onViewBound$6(this));
        getBinding().e.b(this);
        GoogleSmartLockManager$SmartLockCredentials googleSmartLockManager$SmartLockCredentials = this.smartLockCredentials;
        if (googleSmartLockManager$SmartLockCredentials != null) {
            getBinding().e.setText(googleSmartLockManager$SmartLockCredentials.getId());
            TextInputLayout textInputLayout2 = getBinding().g;
            d0.z.d.m.checkNotNullExpressionValue(textInputLayout2, "binding.authLoginPasswordWrap");
            ViewExtensions.setText(textInputLayout2, googleSmartLockManager$SmartLockCredentials.getPassword());
            login$default(this, null, false, 3, null);
        }
        StorePhone phone = storeStream$Companion.getPhone();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{phone}, false, null, null, new WidgetAuthLogin$onViewBound$8(phone), 14, null), this, null, 2, null), WidgetAuthLogin.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthLogin$onViewBound$9(this), 62, (Object) null);
    }

    public final void setGoogleSmartLockManager(GoogleSmartLockManager googleSmartLockManager) {
        d0.z.d.m.checkNotNullParameter(googleSmartLockManager, "<set-?>");
        this.googleSmartLockManager = googleSmartLockManager;
    }

    public final void setSmartLockCredentials(GoogleSmartLockManager$SmartLockCredentials googleSmartLockManager$SmartLockCredentials) {
        this.smartLockCredentials = googleSmartLockManager$SmartLockCredentials;
    }

    public static /* synthetic */ void login$default(WidgetAuthLogin widgetAuthLogin, String str, String str2, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        widgetAuthLogin.login(str, str2, captchaHelper$CaptchaPayload, z2);
    }

    private final void login(String id2, String password, CaptchaHelper$CaptchaPayload captchaPayload, boolean undelete) {
        Context context = getContext();
        if (context != null) {
            d0.z.d.m.checkNotNullExpressionValue(context, "context ?: return");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getAuthentication().login(id2, password, captchaPayload, undelete, GoogleSmartLockManagerKt.hasSmartLockCredentials(getMostRecentIntent()) ? RestAPIParams$AuthLogin$LoginSource.LOGIN_SOURCE_KEYCHAIN_AUTO : null), this, null, 2, null), getBinding().h, 0L, 2, null), context, "REST: login", (Function1) null, new WidgetAuthLogin$login$1(this, id2, password, context), new WidgetAuthLogin$login$2(this, id2), (Function0) null, (Function0) null, 100, (Object) null);
        }
    }
}
