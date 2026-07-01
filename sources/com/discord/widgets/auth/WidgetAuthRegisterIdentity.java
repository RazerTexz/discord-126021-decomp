package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthRegisterIdentityBinding;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams$AuthRegisterPhone;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.auth.RegistrationFlowRepo$Companion;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.phone.PhoneOrEmailInputView$Mode;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import d0.g;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthRegisterIdentity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", 0)};
    public static final WidgetAuthRegisterIdentity$Companion Companion = new WidgetAuthRegisterIdentity$Companion(null);
    private static final String IS_PHONE_MODE = "IS_PHONE_MODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* JADX INFO: renamed from: emailValidationManager$delegate, reason: from kotlin metadata */
    private final Lazy emailValidationManager;
    private PhoneOrEmailInputView$Mode inputMode;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: phoneValidationManager$delegate, reason: from kotlin metadata */
    private final Lazy phoneValidationManager;
    private final ActivityResultLauncher<Intent> phoneVerifyLauncher;
    private boolean shouldValidateInputs;

    public WidgetAuthRegisterIdentity() {
        super(R$layout.widget_auth_register_identity);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthRegisterIdentity$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthRegisterIdentity$binding$2.INSTANCE, null, 2, null);
        this.inputMode = PhoneOrEmailInputView$Mode.PHONE;
        this.shouldValidateInputs = true;
        this.phoneVerifyLauncher = WidgetAuthPhoneVerify.Companion.registerForResult(this, new WidgetAuthRegisterIdentity$phoneVerifyLauncher$1(this));
        this.captchaLauncher = WidgetAuthCaptcha.Companion.registerForResult(this, new WidgetAuthRegisterIdentity$captchaLauncher$1(this));
        this.phoneValidationManager = g.lazy(new WidgetAuthRegisterIdentity$phoneValidationManager$2(this));
        this.emailValidationManager = g.lazy(new WidgetAuthRegisterIdentity$emailValidationManager$2(this));
    }

    public static final /* synthetic */ WidgetAuthRegisterIdentityBinding access$getBinding$p(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        return widgetAuthRegisterIdentity.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCaptchaLauncher$p(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        return widgetAuthRegisterIdentity.captchaLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPhoneVerifyLauncher$p(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        return widgetAuthRegisterIdentity.phoneVerifyLauncher;
    }

    public static final /* synthetic */ void access$handleNext(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        widgetAuthRegisterIdentity.handleNext();
    }

    public static final /* synthetic */ void access$registerViaPhone(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetAuthRegisterIdentity.registerViaPhone(captchaHelper$CaptchaPayload);
    }

    public static final /* synthetic */ void access$setInputMode(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity, PhoneOrEmailInputView$Mode phoneOrEmailInputView$Mode) {
        widgetAuthRegisterIdentity.setInputMode(phoneOrEmailInputView$Mode);
    }

    private final void configurePhoneInput() {
        getBinding().d.setMode(this.inputMode);
        if (this.inputMode == PhoneOrEmailInputView$Mode.PHONE) {
            getBinding().d.setHint(getString(2131889241));
        } else {
            getBinding().d.setHint(getString(2131889166));
        }
        getBinding().d.getMainEditText().setImeOptions(6);
        ViewExtensions.setOnImeActionDone$default(getBinding().d.getMainTextInputLayout(), false, new WidgetAuthRegisterIdentity$configurePhoneInput$1(this), 1, null);
    }

    private final void configureSegmentControl() {
        SegmentedControlContainer.b(getBinding().g, 0, 1);
        getBinding().g.setOnSegmentSelectedChangeListener(new WidgetAuthRegisterIdentity$configureSegmentControl$1(this));
        PhoneOrEmailInputView$Mode phoneOrEmailInputView$Mode = this.inputMode;
        PhoneOrEmailInputView$Mode phoneOrEmailInputView$Mode2 = PhoneOrEmailInputView$Mode.PHONE;
        getBinding().g.setSelectedIndex(phoneOrEmailInputView$Mode != phoneOrEmailInputView$Mode2 ? 1 : 0);
        CardSegment cardSegmentForMode = getCardSegmentForMode(phoneOrEmailInputView$Mode2);
        cardSegmentForMode.setText(getString(2131893780));
        cardSegmentForMode.setContentDescription(getString(2131896704));
        CardSegment cardSegmentForMode2 = getCardSegmentForMode(PhoneOrEmailInputView$Mode.EMAIL);
        cardSegmentForMode2.setText(getString(2131888655));
        cardSegmentForMode2.setContentDescription(getString(2131896698));
    }

    private final void configureUI() {
        getBinding().d.b(this);
        StorePhone phone = StoreStream.Companion.getPhone();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{phone}, false, null, null, new WidgetAuthRegisterIdentity$configureUI$1(phone), 14, null), this, null, 2, null), WidgetAuthRegisterIdentity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthRegisterIdentity$configureUI$2(this), 62, (Object) null);
        configurePhoneInput();
        configureSegmentControl();
        getBinding().d.requestFocus();
        LinkifiedTextView linkifiedTextView = getBinding().e;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.authRegisterIdentityPolicyLink");
        b.n(linkifiedTextView, 2131894731, new Object[]{getString(2131894539)}, null, 4);
        getBinding().f2237b.setOnClickListener(new WidgetAuthRegisterIdentity$configureUI$3(this));
    }

    private final WidgetAuthRegisterIdentityBinding getBinding() {
        return (WidgetAuthRegisterIdentityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CardSegment getCardSegmentForMode(PhoneOrEmailInputView$Mode mode) {
        if (mode == PhoneOrEmailInputView$Mode.PHONE) {
            CardSegment cardSegment = getBinding().c;
            m.checkNotNullExpressionValue(cardSegment, "binding.authRegisterIdentityFirstSegmentCard");
            return cardSegment;
        }
        CardSegment cardSegment2 = getBinding().f;
        m.checkNotNullExpressionValue(cardSegment2, "binding.authRegisterIdentitySecondSegmentCard");
        return cardSegment2;
    }

    private final ValidationManager getEmailValidationManager() {
        return (ValidationManager) this.emailValidationManager.getValue();
    }

    private final ValidationManager getPhoneValidationManager() {
        return (ValidationManager) this.phoneValidationManager.getValue();
    }

    private final void handleNext() {
        if (this.inputMode == PhoneOrEmailInputView$Mode.EMAIL) {
            if (!this.shouldValidateInputs || ValidationManager.validate$default(getEmailValidationManager(), false, 1, null)) {
                registerViaEmail();
                return;
            } else {
                RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Account Identity", "input_error", null, 4, null);
                return;
            }
        }
        if (!this.shouldValidateInputs || ValidationManager.validate$default(getPhoneValidationManager(), false, 1, null)) {
            registerViaPhone$default(this, null, 1, null);
        } else {
            RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Account Identity", "input_error", null, 4, null);
        }
    }

    private final void registerViaEmail() {
        RegistrationFlowRepo$Companion registrationFlowRepo$Companion = RegistrationFlowRepo.Companion;
        registrationFlowRepo$Companion.getINSTANCE().setEmail(getBinding().d.getTextOrEmpty());
        RegistrationFlowRepo.trackTransition$default(registrationFlowRepo$Companion.getINSTANCE(), "Account Identity", "success", null, 4, null);
        j.e(requireContext(), WidgetAuthRegisterAccountInformation.class, null, 4);
    }

    private final void registerViaPhone(CaptchaHelper$CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().d.getTextOrEmpty();
        RegistrationFlowRepo.Companion.getINSTANCE().setPhone(textOrEmpty);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().postAuthRegisterPhone(new RestAPIParams$AuthRegisterPhone(textOrEmpty, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), WidgetAuthRegisterIdentity$registerViaPhone$1.INSTANCE), this, null, 2, null), getBinding().h, 0L, 2, null), WidgetAuthRegisterIdentity.class, getContext(), (Function1) null, new WidgetAuthRegisterIdentity$registerViaPhone$3(this), (Function0) null, (Function0) null, new WidgetAuthRegisterIdentity$registerViaPhone$2(this, textOrEmpty), 52, (Object) null);
    }

    public static /* synthetic */ void registerViaPhone$default(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetAuthRegisterIdentity.registerViaPhone(captchaHelper$CaptchaPayload);
    }

    private final void setInputMode(PhoneOrEmailInputView$Mode newInputMode) {
        if (this.inputMode == newInputMode) {
            return;
        }
        this.inputMode = newInputMode;
        getBinding().d.getMainTextInputLayout().setError(null);
        configurePhoneInput();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        configureUI();
        Map<String, List<String>> errors = RegistrationFlowRepo.Companion.getINSTANCE().getErrors();
        if (errors != null) {
            getEmailValidationManager().setErrors(errors);
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
                if (!m.areEqual(str, NotificationCompat.CATEGORY_EMAIL) && !m.areEqual(str, "phone")) {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            List<String> list = u.toList(arrayList);
            if (!list.isEmpty()) {
                RegistrationFlowRepo.Companion.getINSTANCE().trackTransition("Account Identity", "response_error", list);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        m.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_PHONE_MODE, this.inputMode == PhoneOrEmailInputView$Mode.PHONE);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.inputMode = (savedInstanceState == null || savedInstanceState.getBoolean(IS_PHONE_MODE)) ? PhoneOrEmailInputView$Mode.PHONE : PhoneOrEmailInputView$Mode.EMAIL;
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Account Identity", "submitted", null, 4, null);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        boolean z2 = true;
        Experiment userExperiment = storeStream$Companion.getExperiments().getUserExperiment("2021-01_android_registration_flow", true);
        if ((userExperiment != null && userExperiment.getBucket() == 1) || (userExperiment != null && userExperiment.getBucket() == 3)) {
            z2 = false;
        }
        this.shouldValidateInputs = z2;
        configureUI();
        storeStream$Companion.getInviteSettings().trackWithInvite$app_productionGoogleRelease(WidgetAuthRegisterIdentity.class, WidgetAuthRegisterIdentity$onViewCreated$1.INSTANCE);
    }
}
