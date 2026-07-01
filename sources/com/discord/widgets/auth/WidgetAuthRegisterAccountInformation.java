package com.discord.widgets.auth;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthRegisterAccountInformationBinding;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.auth.RegistrationFlowRepo$Companion;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.time.TimeUtils$UTCFormat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.home.HomeConfig;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthRegisterAccountInformation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthRegisterAccountInformationBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> birthdayLauncher;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private boolean isConsentRequired;
    private final LoggingConfig loggingConfig;
    private boolean shouldShowAgeGate;
    private boolean shouldValidateInputs;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    public WidgetAuthRegisterAccountInformation() {
        super(R$layout.widget_auth_register_account_information);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthRegisterAccountInformation$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthRegisterAccountInformation$binding$2.INSTANCE, null, 2, null);
        this.shouldValidateInputs = true;
        this.shouldShowAgeGate = true;
        this.captchaLauncher = WidgetAuthCaptcha.Companion.registerForResult(this, new WidgetAuthRegisterAccountInformation$captchaLauncher$1(this));
        this.birthdayLauncher = WidgetAuthBirthday.Companion.registerForResult(this, new WidgetAuthRegisterAccountInformation$birthdayLauncher$1(this));
        this.validationManager = g.lazy(new WidgetAuthRegisterAccountInformation$validationManager$2(this));
    }

    public static final /* synthetic */ WidgetAuthRegisterAccountInformationBinding access$getBinding$p(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        return widgetAuthRegisterAccountInformation.getBinding();
    }

    public static final /* synthetic */ void access$handleError(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation, Error error) {
        widgetAuthRegisterAccountInformation.handleError(error);
    }

    public static final /* synthetic */ boolean access$isConsentRequired$p(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        return widgetAuthRegisterAccountInformation.isConsentRequired;
    }

    public static final /* synthetic */ void access$register(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetAuthRegisterAccountInformation.register(captchaHelper$CaptchaPayload);
    }

    public static final /* synthetic */ void access$setConsentRequired$p(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation, boolean z2) {
        widgetAuthRegisterAccountInformation.isConsentRequired = z2;
    }

    private final void configureUI() {
        getBinding().e.requestFocus();
        if (this.isConsentRequired) {
            TextInputLayout textInputLayout = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationPasswordWrap");
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                editText.setImeOptions(6);
            }
        } else {
            TextInputLayout textInputLayout2 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
            ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new WidgetAuthRegisterAccountInformation$configureUI$1(this), 1, null);
        }
        getBinding().c.setOnClickListener(new WidgetAuthRegisterAccountInformation$configureUI$2(this));
        if (RegistrationFlowRepo.Companion.getINSTANCE().getBirthday() == null && this.shouldShowAgeGate) {
            getBinding().c.setText(getText(2131893214));
        } else {
            getBinding().c.setText(getText(2131894730));
        }
    }

    private final WidgetAuthRegisterAccountInformationBinding getBinding() {
        return (WidgetAuthRegisterAccountInformationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleError(Error error) {
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        m.checkNotNullExpressionValue(messages, "error.response.messages");
        if (messages.containsKey(BirthdayHelper.DATE_OF_BIRTH_KEY)) {
            RegistrationFlowRepo.Companion.getINSTANCE().trackTransition("Account Information", "response_error", d0.t.m.listOf(BirthdayHelper.DATE_OF_BIRTH_KEY));
            error.setShowErrorToasts(false);
            Error$Response response2 = error.getResponse();
            m.checkNotNullExpressionValue(response2, "error.response");
            Map<String, List<String>> messages2 = response2.getMessages();
            m.checkNotNullExpressionValue(messages2, "error.response.messages");
            List<String> listEmptyList = messages2.get(BirthdayHelper.DATE_OF_BIRTH_KEY);
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            m.checkNotNullExpressionValue(listEmptyList, "error.response.messages\n…IRTH_KEY) { emptyList() }");
            StoreStream.Companion.getAuthentication().setAgeGateError(u.joinToString$default(listEmptyList, "\n", null, null, 0, null, null, 62, null));
            j.b(requireContext(), false, new Intent().putExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG", new HomeConfig(null, null, true, 3, null)));
            return;
        }
        Error$Response response3 = error.getResponse();
        m.checkNotNullExpressionValue(response3, "error.response");
        if (response3.getMessages().isEmpty()) {
            RegistrationFlowRepo instance = RegistrationFlowRepo.Companion.getINSTANCE();
            Error$Response response4 = error.getResponse();
            m.checkNotNullExpressionValue(response4, "error.response");
            instance.trackTransition("Register", "response_error", n.listOf((Object[]) new String[]{"connection_error", error.getType().toString(), String.valueOf(response4.getCode())}));
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Error$Response response5 = error.getResponse();
        m.checkNotNullExpressionValue(response5, "error.response");
        Map<String, List<String>> messages3 = response5.getMessages();
        m.checkNotNullExpressionValue(messages3, "error.response.messages");
        List<String> mutableList = u.toMutableList((Collection) validationManager.setErrors(messages3));
        Error$Response response6 = error.getResponse();
        m.checkNotNullExpressionValue(response6, "error.response");
        List<String> mutableList2 = u.toMutableList((Collection) response6.getMessages().keySet());
        RegistrationFlowRepo$Companion registrationFlowRepo$Companion = RegistrationFlowRepo.Companion;
        RegistrationFlowRepo instance2 = registrationFlowRepo$Companion.getINSTANCE();
        Error$Response response7 = error.getResponse();
        m.checkNotNullExpressionValue(response7, "error.response");
        instance2.setErrors(response7.getMessages());
        WidgetAuthCaptcha.Companion.processErrorsForCaptcha(requireContext(), this.captchaLauncher, mutableList, error);
        if (mutableList.contains(NotificationCompat.CATEGORY_EMAIL)) {
            requireActivity().onBackPressed();
            mutableList.remove(NotificationCompat.CATEGORY_EMAIL);
            mutableList2.remove(NotificationCompat.CATEGORY_EMAIL);
        }
        registrationFlowRepo$Companion.getINSTANCE().trackTransition("Account Information", "response_error", mutableList2);
        error.setShowErrorToasts(!mutableList.isEmpty());
    }

    private final boolean isConsented() {
        if (this.isConsentRequired) {
            MaterialCheckBox materialCheckBox = getBinding().f;
            m.checkNotNullExpressionValue(materialCheckBox, "binding.authTosOptIn");
            if (!materialCheckBox.isChecked()) {
                return false;
            }
        }
        return true;
    }

    private final void register(CaptchaHelper$CaptchaPayload captchaPayload) {
        if (this.shouldValidateInputs && !ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Account Information", "input_error", null, 4, null);
            return;
        }
        RegistrationFlowRepo$Companion registrationFlowRepo$Companion = RegistrationFlowRepo.Companion;
        if (registrationFlowRepo$Companion.getINSTANCE().getBirthday() == null && this.shouldShowAgeGate) {
            RegistrationFlowRepo.trackTransition$default(registrationFlowRepo$Companion.getINSTANCE(), "Account Information", "success", null, 4, null);
            AnalyticsTracker.openModal$default("Enter Your Birthday", "Register", null, 4, null);
            WidgetAuthBirthday.Companion.launch(requireContext(), this.birthdayLauncher);
            return;
        }
        String uTCDateTime = registrationFlowRepo$Companion.getINSTANCE().getBirthday() != null ? TimeUtils.toUTCDateTime(registrationFlowRepo$Companion.getINSTANCE().getBirthday(), TimeUtils$UTCFormat.SHORT) : null;
        getBinding().c.setIsLoading(true);
        StoreAuthentication authentication = StoreStream.Companion.getAuthentication();
        TextInputLayout textInputLayout = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationUsernameWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        String email = registrationFlowRepo$Companion.getINSTANCE().getEmail();
        String phoneToken = registrationFlowRepo$Companion.getINSTANCE().getPhoneToken();
        TextInputLayout textInputLayout2 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(authentication.register(textOrEmpty, email, phoneToken, ViewExtensions.getTextOrEmpty(textInputLayout2), captchaPayload, isConsented(), uTCDateTime), this, null, 2, null), WidgetAuthRegisterAccountInformation.class, getContext(), (Function1) null, new WidgetAuthRegisterAccountInformation$register$2(this), (Function0) null, (Function0) null, WidgetAuthRegisterAccountInformation$register$1.INSTANCE, 52, (Object) null);
    }

    public static /* synthetic */ void register$default(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetAuthRegisterAccountInformation.register(captchaHelper$CaptchaPayload);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RegistrationFlowRepo$Companion registrationFlowRepo$Companion = RegistrationFlowRepo.Companion;
        RegistrationFlowRepo.trackTransition$default(registrationFlowRepo$Companion.getINSTANCE(), "Account Information", "submitted", null, 4, null);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Experiment userExperiment = storeStream$Companion.getExperiments().getUserExperiment("2021-01_android_registration_flow", true);
        this.shouldValidateInputs = (userExperiment == null || userExperiment.getBucket() != 1) && (userExperiment == null || userExperiment.getBucket() != 3);
        boolean z2 = (userExperiment == null || userExperiment.getBucket() != 2) && (userExperiment == null || userExperiment.getBucket() != 3);
        this.shouldShowAgeGate = z2;
        if (!z2) {
            this.isConsentRequired = storeStream$Companion.getAuthentication().isConsentRequired();
        } else {
            this.isConsentRequired = false;
            LinkifiedTextView linkifiedTextView = getBinding().f2236b;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.authPolicyLinks");
            linkifiedTextView.setVisibility(8);
        }
        MaterialCheckBox materialCheckBox = getBinding().f;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.authTosOptIn");
        materialCheckBox.setVisibility(this.isConsentRequired ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().f2236b;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.authPolicyLinks");
        b.n(linkifiedTextView2, this.isConsentRequired ? 2131896293 : 2131896290, new Object[]{getString(2131896289), getString(2131894539)}, null, 4);
        getBinding().c.setIsLoading(false);
        RegistrationFlowRepo.trackTransition$default(registrationFlowRepo$Companion.getINSTANCE(), "Account Information", "viewed", null, 4, null);
        TextInputLayout textInputLayout = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationUsernameWrap");
        ViewExtensions.setText(textInputLayout, registrationFlowRepo$Companion.getINSTANCE().getUsername());
        TextInputLayout textInputLayout2 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
        ViewExtensions.setText(textInputLayout2, registrationFlowRepo$Companion.getINSTANCE().getPassword());
        TextInputLayout textInputLayout3 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.authRegisterAccountInformationUsernameWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout3, this, new WidgetAuthRegisterAccountInformation$onViewBound$1(this));
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.authRegisterAccountInformationPasswordWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout4, this, new WidgetAuthRegisterAccountInformation$onViewBound$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Map<String, List<String>> errors = RegistrationFlowRepo.Companion.getINSTANCE().getErrors();
        if (errors != null) {
            getValidationManager().setErrors(errors);
            Set<String> setKeySet = errors.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setKeySet.iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String str = (String) next;
                if (!m.areEqual(str, "username") && !m.areEqual(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD)) {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            List<String> list = u.toList(arrayList);
            if (!list.isEmpty()) {
                RegistrationFlowRepo.Companion.getINSTANCE().trackTransition("Account Information", "response_error", list);
            }
        }
        configureUI();
    }
}
