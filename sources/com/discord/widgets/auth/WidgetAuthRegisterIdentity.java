package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserRegisterPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthRegisterIdentityBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.captcha.WidgetCaptchaKt;
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
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetAuthRegisterIdentity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", 0)};
    private static final String IS_PHONE_MODE = "IS_PHONE_MODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* JADX INFO: renamed from: emailValidationManager$delegate, reason: from kotlin metadata */
    private final Lazy emailValidationManager;
    private PhoneOrEmailInputView.Mode inputMode;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: phoneValidationManager$delegate, reason: from kotlin metadata */
    private final Lazy phoneValidationManager;
    private final ActivityResultLauncher<Intent> phoneVerifyLauncher;
    private boolean shouldValidateInputs;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configurePhoneInput$1 */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class C72281 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C72281() {
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
            WidgetAuthRegisterIdentity.this.handleNext();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureSegmentControl$1 */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class C72291 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C72291() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetAuthRegisterIdentity.this.setInputMode(i == 0 ? PhoneOrEmailInputView.Mode.PHONE : PhoneOrEmailInputView.Mode.EMAIL);
            WidgetAuthRegisterIdentity.this.getBinding().f15714g.setSelectedIndex(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureUI$1 */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class C72301 extends AbstractC12240o implements Function0<PhoneCountryCode> {
        public final /* synthetic */ StorePhone $phoneStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C72301(StorePhone storePhone) {
            super(0);
            this.$phoneStore = storePhone;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PhoneCountryCode invoke() {
            return this.$phoneStore.getCountryCode();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureUI$2 */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class C72312 extends AbstractC12240o implements Function1<PhoneCountryCode, Unit> {
        public C72312() {
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
            WidgetAuthRegisterIdentity.this.getBinding().f15711d.setCountryCode(phoneCountryCode);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class C72331 extends AbstractC12240o implements Function1<ModelInvite, Unit> {
        public static final C72331 INSTANCE = new C72331();

        public C72331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            AnalyticsTracker.INSTANCE.registerViewed(modelInvite);
            RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
            companion.getINSTANCE().setInvite(modelInvite);
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Account Identity", "viewed", null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$registerViaPhone$1 */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class C72341 extends AbstractC12240o implements Function1<Void, TrackNetworkMetadataReceiver> {
        public static final C72341 INSTANCE = new C72341();

        public C72341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(Void r1) {
            return new TrackNetworkActionUserRegisterPhone();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$registerViaPhone$2 */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class C72352 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ String $phone;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C72352(String str) {
            super(1);
            this.$phone = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r13) {
            RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Identity", "success", null, 4, null);
            WidgetAuthPhoneVerify.INSTANCE.launch(WidgetAuthRegisterIdentity.this.requireContext(), WidgetAuthRegisterIdentity.this.phoneVerifyLauncher, WidgetAuthRegisterIdentity.this.getBinding().f15711d.getTextOrEmpty(), C1107b.m216h(WidgetAuthRegisterIdentity.this.requireContext(), C5419R.string.sms_confirmation_title, new Object[0], null, 4), C1107b.m216h(WidgetAuthRegisterIdentity.this.requireContext(), C5419R.string.sms_confirmation_description, new Object[]{this.$phone}, null, 4));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$registerViaPhone$3 */
    /* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
    public static final class C72363 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72363() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            if (!GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled() || !WidgetCaptchaKt.isCaptchaError(error)) {
                RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Account Identity", "response_error", C12145m.listOf("phone"));
                return;
            }
            WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
            Context contextRequireContext = WidgetAuthRegisterIdentity.this.requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = WidgetAuthRegisterIdentity.this.captchaLauncher;
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncher, C12163u.toMutableList((Collection) response.getMessages().keySet()), error);
        }
    }

    public WidgetAuthRegisterIdentity() {
        super(C5419R.layout.widget_auth_register_identity);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthRegisterIdentity$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthRegisterIdentity$binding$2.INSTANCE, null, 2, null);
        this.inputMode = PhoneOrEmailInputView.Mode.PHONE;
        this.shouldValidateInputs = true;
        this.phoneVerifyLauncher = WidgetAuthPhoneVerify.INSTANCE.registerForResult(this, new WidgetAuthRegisterIdentity$phoneVerifyLauncher$1(this));
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetAuthRegisterIdentity$captchaLauncher$1(this));
        this.phoneValidationManager = C12083g.lazy(new WidgetAuthRegisterIdentity$phoneValidationManager$2(this));
        this.emailValidationManager = C12083g.lazy(new WidgetAuthRegisterIdentity$emailValidationManager$2(this));
    }

    private final void configurePhoneInput() {
        getBinding().f15711d.setMode(this.inputMode);
        if (this.inputMode == PhoneOrEmailInputView.Mode.PHONE) {
            getBinding().f15711d.setHint(getString(C5419R.string.form_label_phone_number));
        } else {
            getBinding().f15711d.setHint(getString(C5419R.string.form_label_email));
        }
        getBinding().f15711d.getMainEditText().setImeOptions(6);
        ViewExtensions.setOnImeActionDone$default(getBinding().f15711d.getMainTextInputLayout(), false, new C72281(), 1, null);
    }

    private final void configureSegmentControl() {
        SegmentedControlContainer.m8606b(getBinding().f15714g, 0, 1);
        getBinding().f15714g.setOnSegmentSelectedChangeListener(new C72291());
        PhoneOrEmailInputView.Mode mode = this.inputMode;
        PhoneOrEmailInputView.Mode mode2 = PhoneOrEmailInputView.Mode.PHONE;
        getBinding().f15714g.setSelectedIndex(mode != mode2 ? 1 : 0);
        CardSegment cardSegmentForMode = getCardSegmentForMode(mode2);
        cardSegmentForMode.setText(getString(C5419R.string.phone));
        cardSegmentForMode.setContentDescription(getString(C5419R.string.use_phone));
        CardSegment cardSegmentForMode2 = getCardSegmentForMode(PhoneOrEmailInputView.Mode.EMAIL);
        cardSegmentForMode2.setText(getString(C5419R.string.email));
        cardSegmentForMode2.setContentDescription(getString(C5419R.string.use_email));
    }

    private final void configureUI() {
        getBinding().f15711d.m8600b(this);
        StorePhone phone = StoreStream.INSTANCE.getPhone();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new C72301(phone), 14, null), this, null, 2, null), (Class<?>) WidgetAuthRegisterIdentity.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72312());
        configurePhoneInput();
        configureSegmentControl();
        getBinding().f15711d.requestFocus();
        LinkifiedTextView linkifiedTextView = getBinding().f15712e;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.authRegisterIdentityPolicyLink");
        C1107b.m221m(linkifiedTextView, C5419R.string.register_login_privacy_notice, new Object[]{getString(C5419R.string.privacy_policy_url)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f15709b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthRegisterIdentity.configureUI.3
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
            CardSegment cardSegment = getBinding().f15710c;
            C12238m.checkNotNullExpressionValue(cardSegment, "binding.authRegisterIdentityFirstSegmentCard");
            return cardSegment;
        }
        CardSegment cardSegment2 = getBinding().f15713f;
        C12238m.checkNotNullExpressionValue(cardSegment2, "binding.authRegisterIdentitySecondSegmentCard");
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
        companion.getINSTANCE().setEmail(getBinding().f15711d.getTextOrEmpty());
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Account Identity", "success", null, 4, null);
        C0870j.m157e(requireContext(), WidgetAuthRegisterAccountInformation.class, null, 4);
    }

    private final void registerViaPhone(CaptchaHelper.CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().f15711d.getTextOrEmpty();
        RegistrationFlowRepo.INSTANCE.getINSTANCE().setPhone(textOrEmpty);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthRegisterPhone(new RestAPIParams.AuthRegisterPhone(textOrEmpty, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), C72341.INSTANCE), this, null, 2, null), getBinding().f15715h, 0L, 2, null), (Class<?>) WidgetAuthRegisterIdentity.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72363()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72352(textOrEmpty));
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
        getBinding().f15711d.getMainTextInputLayout().setError(null);
        configurePhoneInput();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
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
                if (!C12238m.areEqual(str, NotificationCompat.CATEGORY_EMAIL) && !C12238m.areEqual(str, "phone")) {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            List<String> list = C12163u.toList(arrayList);
            if (!list.isEmpty()) {
                RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Account Identity", "response_error", list);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        C12238m.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_PHONE_MODE, this.inputMode == PhoneOrEmailInputView.Mode.PHONE);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
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
        companion.getInviteSettings().trackWithInvite$app_productionGoogleRelease(WidgetAuthRegisterIdentity.class, C72331.INSTANCE);
    }
}
