package com.discord.widgets.auth;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthLoginBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManagerKt;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetAuthLogin.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLoginBinding;", 0)};
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
    private GoogleSmartLockManager.SmartLockCredentials smartLockCredentials;
    private final ActivityResultLauncher<Intent> undeleteAccountLauncher;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$forgotPassword$1 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class C71821 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ String $login;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71821(String str) {
            super(1);
            this.$login = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetAuthLogin.this.showEmailSentToast(this.$login);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$forgotPassword$2 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class C71832 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $login;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71832(String str) {
            super(1);
            this.$login = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            if (response.getCode() != 70007) {
                ValidationManager validationManager = WidgetAuthLogin.this.getValidationManager();
                Error.Response response2 = error.getResponse();
                C12238m.checkNotNullExpressionValue(response2, "error.response");
                Map<String, List<String>> messages = response2.getMessages();
                C12238m.checkNotNullExpressionValue(messages, "error.response.messages");
                List<String> mutableList = C12163u.toMutableList((Collection) validationManager.setErrors(messages));
                WidgetAuthCaptcha.INSTANCE.processErrorsForCaptcha(WidgetAuthLogin.this.requireContext(), WidgetAuthLogin.this.captchaForgotPasswordLauncher, mutableList, error);
                error.setShowErrorToasts(!mutableList.isEmpty());
                return;
            }
            WidgetAuthPhoneVerify.Companion companion = WidgetAuthPhoneVerify.INSTANCE;
            Context contextRequireContext = WidgetAuthLogin.this.requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = WidgetAuthLogin.this.phoneVerifyPasswordLauncher;
            String str = this.$login;
            String string = WidgetAuthLogin.this.getString(C5419R.string.password_recovery_verify_phone_title);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.passw…overy_verify_phone_title)");
            String string2 = WidgetAuthLogin.this.getString(C5419R.string.password_recovery_verify_phone_subtitle);
            C12238m.checkNotNullExpressionValue(string2, "getString(R.string.passw…ry_verify_phone_subtitle)");
            companion.launch(contextRequireContext, activityResultLauncher, str, string, string2);
            error.setShowErrorToasts(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$login$1 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class C71841 extends AbstractC12240o implements Function1<ModelLoginResult, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $id;
        public final /* synthetic */ String $password;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71841(String str, String str2, Context context) {
            super(1);
            this.$id = str;
            this.$password = str2;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
            invoke2(modelLoginResult);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLoginResult modelLoginResult) {
            C12238m.checkNotNullParameter(modelLoginResult, "it");
            WidgetAuthLogin.this.onLoginSuccess(this.$id, this.$password);
            if (!modelLoginResult.getMfa()) {
                AnalyticsTracker.INSTANCE.loginAttempt(true);
                return;
            }
            WidgetAuthMfa.Companion companion = WidgetAuthMfa.INSTANCE;
            Context context = this.$context;
            String ticket = modelLoginResult.getTicket();
            C12238m.checkNotNull(ticket);
            companion.start(context, ticket);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$login$2 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class C71852 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71852(String str) {
            super(1);
            this.$id = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            WidgetAuthLogin.this.handleError(error, this.$id);
            AnalyticsTracker.INSTANCE.loginAttempt(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class C71861 extends AbstractC12240o implements Function1<ModelInvite, Unit> {
        public static final C71861 INSTANCE = new C71861();

        public C71861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            AnalyticsTracker.INSTANCE.loginViewed(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class C71883 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C71883() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            WidgetAuthLogin.login$default(WidgetAuthLogin.this, null, false, 3, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$8 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class C71928 extends AbstractC12240o implements Function0<PhoneCountryCode> {
        public final /* synthetic */ StorePhone $phoneStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71928(StorePhone storePhone) {
            super(0);
            this.$phoneStore = storePhone;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PhoneCountryCode invoke() {
            return this.$phoneStore.getCountryCode();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$9 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class C71939 extends AbstractC12240o implements Function1<PhoneCountryCode, Unit> {
        public C71939() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PhoneCountryCode phoneCountryCode) {
            invoke2(phoneCountryCode);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PhoneCountryCode phoneCountryCode) {
            C12238m.checkNotNullParameter(phoneCountryCode, "it");
            WidgetAuthLogin.this.getBinding().f15684e.setCountryCode(phoneCountryCode);
        }
    }

    public WidgetAuthLogin() {
        super(C5419R.layout.widget_auth_login);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthLogin$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthLogin$binding$2.INSTANCE, null, 2, null);
        WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
        this.captchaForgotPasswordLauncher = companion.registerForResult(this, new WidgetAuthLogin$captchaForgotPasswordLauncher$1(this));
        this.captchaLoginLauncher = companion.registerForResult(this, new WidgetAuthLogin$captchaLoginLauncher$1(this));
        WidgetAuthPhoneVerify.Companion companion2 = WidgetAuthPhoneVerify.INSTANCE;
        this.phoneVerifyLoginLauncher = companion2.registerForResult(this, new WidgetAuthLogin$phoneVerifyLoginLauncher$1(this));
        this.phoneVerifyPasswordLauncher = companion2.registerForResult(this, new WidgetAuthLogin$phoneVerifyPasswordLauncher$1(this));
        this.undeleteAccountLauncher = WidgetAuthUndeleteAccount.INSTANCE.registerForResult(this, new WidgetAuthLogin$undeleteAccountLauncher$1(this));
        this.validationManager = C12083g.lazy(new WidgetAuthLogin$validationManager$2(this));
    }

    private final void forgotPassword(CaptchaHelper.CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().f15684e.getTextOrEmpty();
        if (textOrEmpty.length() == 0) {
            C0876m.m169g(getContext(), C5419R.string.login_required, 0, null, 12);
        } else {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.m8518ui(StoreStream.INSTANCE.getAuthentication().forgotPassword(textOrEmpty, captchaPayload)), getBinding().f15687h, 0L, 2, null), (117 & 1) != 0 ? null : getContext(), "REST: forgotPassword", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C71821(textOrEmpty), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : new C71832(textOrEmpty)), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
        }
    }

    public static /* synthetic */ void forgotPassword$default(WidgetAuthLogin widgetAuthLogin, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetAuthLogin.forgotPassword(captchaPayload);
    }

    private final WidgetAuthLoginBinding getBinding() {
        return (WidgetAuthLoginBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleError(Error error, String login) {
        Error.Response response = error.getResponse();
        C12238m.checkNotNullExpressionValue(response, "error.response");
        boolean z2 = response.getCode() == 20011;
        boolean z3 = response.getCode() == 20013;
        boolean z4 = response.getCode() == 70007;
        if (response.getCode() == 50035) {
            if (login == null || this.smartLockCredentials == null) {
                return;
            }
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                C12238m.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onSmartLockCredentialsFailed();
            GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
            if (googleSmartLockManager2 == null) {
                C12238m.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager2.deleteCredentials(login);
            this.smartLockCredentials = null;
            GoogleSmartLockManagerKt.clearSmartLockCredentials(getMostRecentIntent());
            return;
        }
        if (z2) {
            WidgetAuthUndeleteAccount.INSTANCE.launch(requireContext(), this.undeleteAccountLauncher, false);
            return;
        }
        if (z3) {
            WidgetAuthUndeleteAccount.INSTANCE.launch(requireContext(), this.undeleteAccountLauncher, true);
            return;
        }
        if (z4) {
            WidgetAuthPhoneVerify.Companion companion = WidgetAuthPhoneVerify.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.phoneVerifyLoginLauncher;
            String textOrEmpty = getBinding().f15684e.getTextOrEmpty();
            String string = getString(C5419R.string.phone_ip_authorization_title);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.phone_ip_authorization_title)");
            String string2 = getString(C5419R.string.phone_ip_authorization_subtitle);
            C12238m.checkNotNullExpressionValue(string2, "getString(R.string.phone…p_authorization_subtitle)");
            companion.launch(contextRequireContext, activityResultLauncher, textOrEmpty, string, string2);
            return;
        }
        Error.Response response2 = error.getResponse();
        C12238m.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getMessages().isEmpty()) {
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Map<String, List<String>> messages = response.getMessages();
        C12238m.checkNotNullExpressionValue(messages, "errorResponse.messages");
        List<String> mutableList = C12163u.toMutableList((Collection) validationManager.setErrors(messages));
        WidgetAuthCaptcha.INSTANCE.processErrorsForCaptcha(requireContext(), this.captchaLoginLauncher, mutableList, error);
        error.setShowErrorToasts(!mutableList.isEmpty());
    }

    public static /* synthetic */ void handleError$default(WidgetAuthLogin widgetAuthLogin, Error error, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        widgetAuthLogin.handleError(error, str);
    }

    private final void loadCachedLogin() {
        String savedLogin = StoreStream.INSTANCE.getAuthentication().getSavedLogin();
        if (savedLogin == null || !(!C12103t.isBlank(savedLogin))) {
            getBinding().f15684e.requestFocus();
        } else {
            getBinding().f15684e.setText(savedLogin);
            getBinding().f15686g.requestFocus();
        }
    }

    private final void login(CaptchaHelper.CaptchaPayload captchaPayload, boolean undelete) {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            String textOrEmpty = getBinding().f15684e.getTextOrEmpty();
            TextInputLayout textInputLayout = getBinding().f15686g;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
            login(textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout), captchaPayload, undelete);
        }
    }

    public static /* synthetic */ void login$default(WidgetAuthLogin widgetAuthLogin, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        widgetAuthLogin.login(captchaPayload, z2);
    }

    private final void onLoginSuccess(String id2, String password) {
        if (GoogleSmartLockManagerKt.hasSmartLockCredentials(getMostRecentIntent())) {
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                C12238m.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onLoginWithSmartLockSuccess();
        }
        GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
        if (googleSmartLockManager2 == null) {
            C12238m.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        googleSmartLockManager2.saveCredentials(id2, password);
    }

    private final void showEmailSentToast(String email) {
        C0876m.m170h(getContext(), C1107b.m216h(requireContext(), C5419R.string.email_verification_instructions_body, new Object[]{email}, null, 4), 0, null, 12);
    }

    public final GoogleSmartLockManager getGoogleSmartLockManager() {
        GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
        if (googleSmartLockManager == null) {
            C12238m.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        return googleSmartLockManager;
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final GoogleSmartLockManager.SmartLockCredentials getSmartLockCredentials() {
        return this.smartLockCredentials;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegistrationFlowRepo.INSTANCE.getINSTANCE().setRegistering(false);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.googleSmartLockManager = new GoogleSmartLockManager(fragmentActivityRequireActivity, null, 2, null);
        this.smartLockCredentials = GoogleSmartLockManagerKt.toSmartLockCredentials(getMostRecentIntent());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getInviteSettings().trackWithInvite$app_productionGoogleRelease(WidgetAuthLogin.class, C71861.INSTANCE);
        loadCachedLogin();
        getBinding().f15681b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthLogin.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetAuthLogin.login$default(WidgetAuthLogin.this, null, false, 3, null);
            }
        });
        TextInputLayout textInputLayout = getBinding().f15686g;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C71883(), 1, null);
        getBinding().f15683d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthLogin.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetAuthLogin.forgotPassword$default(WidgetAuthLogin.this, null, 1, null);
            }
        });
        getBinding().f15685f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthLogin.onViewBound.5

            /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$5$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetAuthLogin.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    C12238m.checkNotNullParameter(view, "it");
                    try {
                        view.getContext().startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
                    } catch (ActivityNotFoundException unused) {
                        C0876m.m169g(view.getContext(), C5419R.string.password_manager_open_settings_error, 0, null, 12);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(WidgetAuthLogin.this.requireContext()).setTitle(C5419R.string.password_manager).setMessage(C5419R.string.password_manager_info_android).setPositiveButton(C5419R.string.password_manager_open_settings, AnonymousClass1.INSTANCE), C5419R.string.cancel, (Function1) null, 2, (Object) null);
                FragmentManager parentFragmentManager = WidgetAuthLogin.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                negativeButton$default.show(parentFragmentManager);
            }
        });
        getBinding().f15682c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthLogin.onViewBound.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AppFragment.hideKeyboard$default(WidgetAuthLogin.this, null, 1, null);
            }
        });
        getBinding().f15684e.m8600b(this);
        GoogleSmartLockManager.SmartLockCredentials smartLockCredentials = this.smartLockCredentials;
        if (smartLockCredentials != null) {
            getBinding().f15684e.setText(smartLockCredentials.getId());
            TextInputLayout textInputLayout2 = getBinding().f15686g;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.authLoginPasswordWrap");
            ViewExtensions.setText(textInputLayout2, smartLockCredentials.getPassword());
            login$default(this, null, false, 3, null);
        }
        StorePhone phone = companion.getPhone();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new C71928(phone), 14, null), this, null, 2, null), (Class<?>) WidgetAuthLogin.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71939());
    }

    public final void setGoogleSmartLockManager(GoogleSmartLockManager googleSmartLockManager) {
        C12238m.checkNotNullParameter(googleSmartLockManager, "<set-?>");
        this.googleSmartLockManager = googleSmartLockManager;
    }

    public final void setSmartLockCredentials(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
        this.smartLockCredentials = smartLockCredentials;
    }

    public static /* synthetic */ void login$default(WidgetAuthLogin widgetAuthLogin, String str, String str2, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            captchaPayload = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        widgetAuthLogin.login(str, str2, captchaPayload, z2);
    }

    private final void login(String id2, String password, CaptchaHelper.CaptchaPayload captchaPayload, boolean undelete) {
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getAuthentication().login(id2, password, captchaPayload, undelete, GoogleSmartLockManagerKt.hasSmartLockCredentials(getMostRecentIntent()) ? RestAPIParams.AuthLogin.LoginSource.LOGIN_SOURCE_KEYCHAIN_AUTO : null), this, null, 2, null), getBinding().f15687h, 0L, 2, null), (117 & 1) != 0 ? null : context, "REST: login", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C71841(id2, password, context), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : new C71852(id2)), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
        }
    }
}
