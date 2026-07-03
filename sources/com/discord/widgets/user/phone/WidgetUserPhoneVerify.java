package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetUserPhoneVerifyBinding;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_PHONE_NUMBER = "INTENT_EXTRA_PHONE_NUMBER";
    private static final String INTENT_EXTRA_SOURCE_TYPE = "INTENT_EXTRA_SOURCE_TYPE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;

    /* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, WidgetUserAccountVerifyBase.Mode mode, String phoneNumber, String source) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(launcher, "launcher");
            C12238m.checkNotNullParameter(mode, "mode");
            C12238m.checkNotNullParameter(source, "source");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, true, false);
            if (mode == WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS) {
                launchIntent.addFlags(BasicMeasure.EXACTLY);
            }
            launchIntent.putExtra(WidgetUserPhoneVerify.INTENT_EXTRA_PHONE_NUMBER, phoneNumber);
            launchIntent.putExtra(WidgetUserPhoneVerify.INTENT_EXTRA_SOURCE_TYPE, source);
            C0870j.f524g.m160f(context, launcher, WidgetUserPhoneVerify.class, launchIntent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function0<Unit> callback) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.user.phone.WidgetUserPhoneVerify$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() == -1) {
                        callback.invoke();
                    }
                }
            });
            C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$autofillCode$2 */
    /* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
    public static final class C102682 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ String $verificationCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C102682(String str) {
            super(1);
            this.$verificationCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetUserPhoneVerify.this.handleCodeEntered(this.$verificationCode);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$handleCodeEntered$1 */
    /* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
    public static final class C102691 extends AbstractC12240o implements Function1<ModelPhoneVerificationToken, TrackNetworkMetadataReceiver> {
        public static final C102691 INSTANCE = new C102691();

        public C102691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return new TrackNetworkActionUserVerifyPhone();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
    public static final /* synthetic */ class C102722 extends C12236k implements Function1<String, Unit> {
        public C102722(WidgetUserPhoneVerify widgetUserPhoneVerify) {
            super(1, widgetUserPhoneVerify, WidgetUserPhoneVerify.class, "autofillCode", "autofillCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "p1");
            ((WidgetUserPhoneVerify) this.receiver).autofillCode(str);
        }
    }

    public WidgetUserPhoneVerify() {
        super(C5419R.layout.widget_user_phone_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserPhoneVerify$binding$2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetUserPhoneVerify$passwordVerifyLauncher$1(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetUserPhoneVerify$loggingConfig$1.INSTANCE, 3);
    }

    private final void autofillCode(String verificationCode) {
        if (getView() != null) {
            WidgetUserPhoneVerifyBinding binding = getBinding();
            binding.f18358d.setOnCodeEntered(WidgetUserPhoneVerify$autofillCode$1$1.INSTANCE);
            binding.f18358d.setCode(verificationCode);
            binding.f18358d.setOnCodeEntered(new WidgetUserPhoneVerify$autofillCode$1$2(this));
            Observable<Long> observableM11068d0 = Observable.m11068d0(500L, TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) WidgetUserPhoneVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C102682(verificationCode));
        }
    }

    private final WidgetUserPhoneVerifyBinding getBinding() {
        return (WidgetUserPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleCodeEntered(String verificationCode) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE_NUMBER);
        if (stringExtra != null) {
            C12238m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…A_PHONE_NUMBER) ?: return");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().phoneVerificationsVerify(new RestAPIParams.VerificationCode(stringExtra, verificationCode)), C102691.INSTANCE), false, 1, null), getBinding().f18357c, 0L, 2, null), this, null, 2, null).m11108k(C0879o.m181h(new Action1<ModelPhoneVerificationToken>() { // from class: com.discord.widgets.user.phone.WidgetUserPhoneVerify.handleCodeEntered.2
                @Override // p658rx.functions.Action1
                public final void call(ModelPhoneVerificationToken modelPhoneVerificationToken) {
                    WidgetUserPhoneVerify.this.handleCodeReceived(modelPhoneVerificationToken.getToken());
                }
            }, getContext(), new Action1<Error>() { // from class: com.discord.widgets.user.phone.WidgetUserPhoneVerify.handleCodeEntered.3
                @Override // p658rx.functions.Action1
                public final void call(Error error) {
                    WidgetUserPhoneVerify.this.getBinding().f18358d.m8538b();
                }
            }));
        }
    }

    private final void handleCodeReceived(String phoneToken) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_SOURCE_TYPE);
        if (stringExtra != null) {
            C12238m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…RA_SOURCE_TYPE) ?: return");
            WidgetUserPasswordVerify.INSTANCE.launchUpdatePhoneNumber(requireContext(), this.passwordVerifyLauncher, phoneToken, stringExtra);
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetUserPhoneVerifyBinding binding = getBinding();
        binding.f18358d.setOnCodeEntered(new WidgetUserPhoneVerify$onViewBound$1$1(this));
        ImageView imageView = binding.f18356b;
        C12238m.checkNotNullExpressionValue(imageView, "closeButton");
        imageView.setVisibility(isForced() ? 8 : 0);
        binding.f18356b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.phone.WidgetUserPhoneVerify$onViewBound$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = this.this$0.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.onBackPressed();
                }
            }
        });
        if (GrowthTeamFeatures.INSTANCE.isAndroidSmsAutofillEnabled()) {
            SmsListener.INSTANCE.startSmsListener(new C102722(this));
        }
    }
}
