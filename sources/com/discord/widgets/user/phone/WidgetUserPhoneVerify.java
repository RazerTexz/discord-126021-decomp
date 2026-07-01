package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import b.a.d.o;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetUserPhoneVerifyBinding;
import com.discord.restapi.RestAPIParams$VerificationCode;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", 0)};
    public static final WidgetUserPhoneVerify$Companion Companion = new WidgetUserPhoneVerify$Companion(null);
    private static final String INTENT_EXTRA_PHONE_NUMBER = "INTENT_EXTRA_PHONE_NUMBER";
    private static final String INTENT_EXTRA_SOURCE_TYPE = "INTENT_EXTRA_SOURCE_TYPE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;

    public WidgetUserPhoneVerify() {
        super(R$layout.widget_user_phone_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserPhoneVerify$binding$2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.Companion.registerForResult(this, new WidgetUserPhoneVerify$passwordVerifyLauncher$1(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetUserPhoneVerify$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$autofillCode(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        widgetUserPhoneVerify.autofillCode(str);
    }

    public static final /* synthetic */ WidgetUserPhoneVerifyBinding access$getBinding$p(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        return widgetUserPhoneVerify.getBinding();
    }

    public static final /* synthetic */ WidgetUserAccountVerifyBase$Mode access$getMode$p(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        return widgetUserPhoneVerify.getMode();
    }

    public static final /* synthetic */ void access$handleCodeEntered(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        widgetUserPhoneVerify.handleCodeEntered(str);
    }

    public static final /* synthetic */ void access$handleCodeReceived(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        widgetUserPhoneVerify.handleCodeReceived(str);
    }

    public static final /* synthetic */ void access$setMode$p(WidgetUserPhoneVerify widgetUserPhoneVerify, WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode) {
        widgetUserPhoneVerify.setMode(widgetUserAccountVerifyBase$Mode);
    }

    private final void autofillCode(String verificationCode) {
        if (getView() != null) {
            WidgetUserPhoneVerifyBinding binding = getBinding();
            binding.d.setOnCodeEntered(WidgetUserPhoneVerify$autofillCode$1$1.INSTANCE);
            binding.d.setCode(verificationCode);
            binding.d.setOnCodeEntered(new WidgetUserPhoneVerify$autofillCode$1$2(this));
            Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetUserPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserPhoneVerify$autofillCode$2(this, verificationCode), 62, (Object) null);
        }
    }

    private final WidgetUserPhoneVerifyBinding getBinding() {
        return (WidgetUserPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleCodeEntered(String verificationCode) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE_NUMBER);
        if (stringExtra != null) {
            m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…A_PHONE_NUMBER) ?: return");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.Companion.getApi().phoneVerificationsVerify(new RestAPIParams$VerificationCode(stringExtra, verificationCode)), WidgetUserPhoneVerify$handleCodeEntered$1.INSTANCE), false, 1, null), getBinding().c, 0L, 2, null), this, null, 2, null).k(o.h(new WidgetUserPhoneVerify$handleCodeEntered$2(this), getContext(), new WidgetUserPhoneVerify$handleCodeEntered$3(this)));
        }
    }

    private final void handleCodeReceived(String phoneToken) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_SOURCE_TYPE);
        if (stringExtra != null) {
            m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…RA_SOURCE_TYPE) ?: return");
            WidgetUserPasswordVerify.Companion.launchUpdatePhoneNumber(requireContext(), this.passwordVerifyLauncher, phoneToken, stringExtra);
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetUserPhoneVerifyBinding binding = getBinding();
        binding.d.setOnCodeEntered(new WidgetUserPhoneVerify$onViewBound$1$1(this));
        ImageView imageView = binding.f2688b;
        m.checkNotNullExpressionValue(imageView, "closeButton");
        imageView.setVisibility(isForced() ? 8 : 0);
        binding.f2688b.setOnClickListener(new WidgetUserPhoneVerify$onViewBound$$inlined$with$lambda$1(this));
        if (GrowthTeamFeatures.INSTANCE.isAndroidSmsAutofillEnabled()) {
            SmsListener.Companion.startSmsListener(new WidgetUserPhoneVerify$onViewBound$2(this));
        }
    }
}
