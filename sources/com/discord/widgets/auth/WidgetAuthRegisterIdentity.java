package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserRegisterPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetAuthRegisterIdentityBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.discord.widgets.captcha.WidgetCaptcha4;
import d0.LazyJVM;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthRegisterIdentity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", 0)};
    private static final String IS_PHONE_MODE = "IS_PHONE_MODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* JADX INFO: renamed from: emailValidationManager$delegate, reason: from kotlin metadata */
    private final Lazy emailValidationManager;
    private PhoneOrEmailInputView.Mode inputMode;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: phoneValidationManager$delegate, reason: from kotlin metadata */
    private final Lazy phoneValidationManager;
    private final ActivityResultLauncher<Intent> phoneVerifyLauncher;
    private boolean shouldValidateInputs;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configurePhoneInput$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetAuthRegisterIdentity.this.handleNext();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureSegmentControl$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetAuthRegisterIdentity.this.setInputMode(i == 0 ? PhoneOrEmailInputView.Mode.PHONE : PhoneOrEmailInputView.Mode.EMAIL);
            WidgetAuthRegisterIdentity.this.getBinding().g.setSelectedIndex(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<PhoneCountryCode> {
        public final /* synthetic */ StorePhone $phoneStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StorePhone storePhone) {
            super(0);
            this.$phoneStore = storePhone;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PhoneCountryCode invoke() {
            return this.$phoneStore.getCountryCode();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<PhoneCountryCode, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PhoneCountryCode phoneCountryCode) {
            invoke2(phoneCountryCode);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PhoneCountryCode phoneCountryCode) {
            Intrinsics3.checkNotNullParameter(phoneCountryCode, "it");
            WidgetAuthRegisterIdentity.this.getBinding().d.setCountryCode(phoneCountryCode);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelInvite, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            AnalyticsTracker.INSTANCE.registerViewed(modelInvite);
            RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
            companion.getINSTANCE().setInvite(modelInvite);
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Account Identity", "viewed", null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$registerViaPhone$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(Void r1) {
            return new TrackNetworkActionUserRegisterPhone();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$registerViaPhone$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $phone;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$phone = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r13) {
            RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Identity", "success", null, 4, null);
            WidgetAuthPhoneVerify.INSTANCE.launch(WidgetAuthRegisterIdentity.this.requireContext(), WidgetAuthRegisterIdentity.this.phoneVerifyLauncher, WidgetAuthRegisterIdentity.this.getBinding().d.getTextOrEmpty(), FormatUtils.b(WidgetAuthRegisterIdentity.this.requireContext(), R.string.sms_confirmation_title, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(WidgetAuthRegisterIdentity.this.requireContext(), R.string.sms_confirmation_description, new Object[]{this.$phone}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$registerViaPhone$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            if (!GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled() || !WidgetCaptcha4.isCaptchaError(error)) {
                RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Account Identity", "response_error", CollectionsJVM.listOf("phone"));
                return;
            }
            WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
            Context contextRequireContext = WidgetAuthRegisterIdentity.this.requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = WidgetAuthRegisterIdentity.this.captchaLauncher;
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncher, _Collections.toMutableList((Collection) response.getMessages().keySet()), error);
        }
    }

    public WidgetAuthRegisterIdentity() {
        super(R.layout.widget_auth_register_identity);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthRegisterIdentity5.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthRegisterIdentity2.INSTANCE, null, 2, null);
        this.inputMode = PhoneOrEmailInputView.Mode.PHONE;
        this.shouldValidateInputs = true;
        this.phoneVerifyLauncher = WidgetAuthPhoneVerify.INSTANCE.registerForResult(this, new WidgetAuthRegisterIdentity7(this));
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetAuthRegisterIdentity3(this));
        this.phoneValidationManager = LazyJVM.lazy(new WidgetAuthRegisterIdentity6(this));
        this.emailValidationManager = LazyJVM.lazy(new WidgetAuthRegisterIdentity4(this));
    }

    private final void configurePhoneInput() {
        getBinding().d.setMode(this.inputMode);
        if (this.inputMode == PhoneOrEmailInputView.Mode.PHONE) {
            getBinding().d.setHint(getString(R.string.form_label_phone_number));
        } else {
            getBinding().d.setHint(getString(R.string.form_label_email));
        }
        getBinding().d.getMainEditText().setImeOptions(6);
        ViewExtensions.setOnImeActionDone$default(getBinding().d.getMainTextInputLayout(), false, new AnonymousClass1(), 1, null);
    }

    private final void configureSegmentControl() {
        SegmentedControlContainer.b(getBinding().g, 0, 1);
        getBinding().g.setOnSegmentSelectedChangeListener(new AnonymousClass1());
        PhoneOrEmailInputView.Mode mode = this.inputMode;
        PhoneOrEmailInputView.Mode mode2 = PhoneOrEmailInputView.Mode.PHONE;
        getBinding().g.setSelectedIndex(mode != mode2 ? 1 : 0);
        CardSegment cardSegmentForMode = getCardSegmentForMode(mode2);
        cardSegmentForMode.setText(getString(R.string.phone));
        cardSegmentForMode.setContentDescription(getString(R.string.use_phone));
        CardSegment cardSegmentForMode2 = getCardSegmentForMode(PhoneOrEmailInputView.Mode.EMAIL);
        cardSegmentForMode2.setText(getString(R.string.email));
        cardSegmentForMode2.setContentDescription(getString(R.string.use_email));
    }

    private final void configureUI() {
        getBinding().d.b(this);
        StorePhone phone = StoreStream.INSTANCE.getPhone();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new AnonymousClass1(phone), 14, null), this, null, 2, null), (Class<?>) WidgetAuthRegisterIdentity.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        configurePhoneInput();
        configureSegmentControl();
        getBinding().d.requestFocus();
        LinkifiedTextView linkifiedTextView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.authRegisterIdentityPolicyLink");
        FormatUtils.m(linkifiedTextView, R.string.register_login_privacy_notice, new Object[]{getString(R.string.privacy_policy_url)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().f2237b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthRegisterIdentity.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAuthRegisterIdentity.this.handleNext();
            }
        });
    }

    private final WidgetAuthRegisterIdentityBinding getBinding() {
        return (WidgetAuthRegisterIdentityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CardSegment getCardSegmentForMode(PhoneOrEmailInputView.Mode mode) {
        if (mode == PhoneOrEmailInputView.Mode.PHONE) {
            CardSegment cardSegment = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(cardSegment, "binding.authRegisterIdentityFirstSegmentCard");
            return cardSegment;
        }
        CardSegment cardSegment2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(cardSegment2, "binding.authRegisterIdentitySecondSegmentCard");
        return cardSegment2;
    }

    private final ValidationManager getEmailValidationManager() {
        return (ValidationManager) this.emailValidationManager.getValue();
    }

    private final ValidationManager getPhoneValidationManager() {
        return (ValidationManager) this.phoneValidationManager.getValue();
    }

    private final void handleNext() {
        if (this.inputMode == PhoneOrEmailInputView.Mode.EMAIL) {
            if (!this.shouldValidateInputs || ValidationManager.validate$default(getEmailValidationManager(), false, 1, null)) {
                registerViaEmail();
                return;
            } else {
                RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Identity", "input_error", null, 4, null);
                return;
            }
        }
        if (!this.shouldValidateInputs || ValidationManager.validate$default(getPhoneValidationManager(), false, 1, null)) {
            registerViaPhone$default(this, null, 1, null);
        } else {
            RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Identity", "input_error", null, 4, null);
        }
    }

    private final void registerViaEmail() {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        companion.getINSTANCE().setEmail(getBinding().d.getTextOrEmpty());
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Account Identity", "success", null, 4, null);
        AppScreen2.e(requireContext(), WidgetAuthRegisterAccountInformation.class, null, 4);
    }

    private final void registerViaPhone(CaptchaHelper.CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().d.getTextOrEmpty();
        RegistrationFlowRepo.INSTANCE.getINSTANCE().setPhone(textOrEmpty);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthRegisterPhone(new RestAPIParams.AuthRegisterPhone(textOrEmpty, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), AnonymousClass1.INSTANCE), this, null, 2, null), getBinding().h, 0L, 2, null), (Class<?>) WidgetAuthRegisterIdentity.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(textOrEmpty));
    }

    public static /* synthetic */ void registerViaPhone$default(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetAuthRegisterIdentity.registerViaPhone(captchaPayload);
    }

    private final void setInputMode(PhoneOrEmailInputView.Mode newInputMode) {
        if (this.inputMode == newInputMode) {
            return;
        }
        this.inputMode = newInputMode;
        getBinding().d.getMainTextInputLayout().setError(null);
        configurePhoneInput();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        configureUI();
        Map<String, List<String>> errors = RegistrationFlowRepo.INSTANCE.getINSTANCE().getErrors();
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
                if (!Intrinsics3.areEqual(str, NotificationCompat.CATEGORY_EMAIL) && !Intrinsics3.areEqual(str, "phone")) {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            List<String> list = _Collections.toList(arrayList);
            if (!list.isEmpty()) {
                RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Account Identity", "response_error", list);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics3.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_PHONE_MODE, this.inputMode == PhoneOrEmailInputView.Mode.PHONE);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.inputMode = (savedInstanceState == null || savedInstanceState.getBoolean(IS_PHONE_MODE)) ? PhoneOrEmailInputView.Mode.PHONE : PhoneOrEmailInputView.Mode.EMAIL;
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Identity", "submitted", null, 4, null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean z2 = true;
        Experiment userExperiment = companion.getExperiments().getUserExperiment("2021-01_android_registration_flow", true);
        if ((userExperiment != null && userExperiment.getBucket() == 1) || (userExperiment != null && userExperiment.getBucket() == 3)) {
            z2 = false;
        }
        this.shouldValidateInputs = z2;
        configureUI();
        companion.getInviteSettings().trackWithInvite$app_productionGoogleRelease(WidgetAuthRegisterIdentity.class, AnonymousClass1.INSTANCE);
    }
}
