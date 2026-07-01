package com.discord.widgets.auth;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$anim;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams$VerificationCode;
import com.discord.restapi.RestAPIParams$VerificationCodeResend;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import rx.Observable;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0)};
    public static final WidgetAuthPhoneVerify$Companion Companion = new WidgetAuthPhoneVerify$Companion(null);
    private static final String INTENT_EXTRA_PHONE = "INTENT_EXTRA_PHONE";
    private static final String INTENT_EXTRA_SUBTITLE = "INTENT_EXTRA_SUBTITLE";
    private static final String INTENT_EXTRA_TITLE = "INTENT_EXTRA_TITLE";
    private static final int RESULT_BACK_TO_EMAIL = 2;
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean ignoreAutopaste;
    private final LoggingConfig loggingConfig;
    private String phone;

    public WidgetAuthPhoneVerify() {
        super(R$layout.widget_auth_phone_verify);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthPhoneVerify$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthPhoneVerify$binding$2.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    public static final /* synthetic */ void access$bailoutToEmail(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        widgetAuthPhoneVerify.bailoutToEmail();
    }

    public static final /* synthetic */ void access$evaluateCode(WidgetAuthPhoneVerify widgetAuthPhoneVerify, String str) {
        widgetAuthPhoneVerify.evaluateCode(str);
    }

    public static final /* synthetic */ WidgetAuthPhoneVerifyBinding access$getBinding$p(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        return widgetAuthPhoneVerify.getBinding();
    }

    public static final /* synthetic */ void access$inputCode(WidgetAuthPhoneVerify widgetAuthPhoneVerify, String str) {
        widgetAuthPhoneVerify.inputCode(str);
    }

    public static final /* synthetic */ void access$resendCode(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        widgetAuthPhoneVerify.resendCode();
    }

    public static final /* synthetic */ void access$tryPasteCodeFromClipboard(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        widgetAuthPhoneVerify.tryPasteCodeFromClipboard();
    }

    private final void bailoutToEmail() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(2);
        }
        AppTransitionActivity.j = true;
        AppActivity appActivity2 = getAppActivity();
        if (appActivity2 != null) {
            appActivity2.overridePendingTransition(R$anim.activity_slide_horizontal_open_in, R$anim.activity_slide_horizontal_close_out);
        }
        AppActivity appActivity3 = getAppActivity();
        if (appActivity3 != null) {
            appActivity3.finish();
        }
    }

    private final void evaluateCode(String code) {
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Phone Verification", "submitted", null, 4, null);
        RestAPI api = RestAPI.Companion.getApi();
        String str = this.phone;
        if (str == null) {
            m.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(api.phoneVerificationsVerify(new RestAPIParams$VerificationCode(str, code)), WidgetAuthPhoneVerify$evaluateCode$1.INSTANCE), false, 1, null), this, null, 2, null), getBinding().g, 0L, 2, null), WidgetAuthPhoneVerify.class, getContext(), (Function1) null, new WidgetAuthPhoneVerify$evaluateCode$3(this), (Function0) null, (Function0) null, new WidgetAuthPhoneVerify$evaluateCode$2(this), 52, (Object) null);
    }

    private final WidgetAuthPhoneVerifyBinding getBinding() {
        return (WidgetAuthPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void inputCode(String code) {
        if (getView() != null) {
            getBinding().c.setOnCodeEntered(WidgetAuthPhoneVerify$inputCode$1.INSTANCE);
            getBinding().c.setCode(code);
            getBinding().c.setOnCodeEntered(new WidgetAuthPhoneVerify$inputCode$2(this));
            Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetAuthPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthPhoneVerify$inputCode$3(this), 62, (Object) null);
        }
    }

    private final void resendCode() {
        RestAPI api = RestAPI.Companion.getApi();
        String str = this.phone;
        if (str == null) {
            m.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.phoneVerificationsResend(new RestAPIParams$VerificationCodeResend(str)), false, 1, null), this, null, 2, null), getBinding().g, 0L, 2, null), WidgetAuthPhoneVerify.class, getContext(), (Function1) null, new WidgetAuthPhoneVerify$resendCode$2(this), (Function0) null, (Function0) null, new WidgetAuthPhoneVerify$resendCode$1(this), 52, (Object) null);
    }

    private final void tryPasteCodeFromClipboard() {
        ClipData primaryClip;
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            m.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                m.checkNotNullExpressionValue(charSequenceCoerceToText, "clipData.getItemAt(0).coerceToText(context)");
                String strReplace = new Regex(" ").replace(charSequenceCoerceToText, "");
                if (strReplace.length() == 6 && TextUtils.isDigitsOnly(strReplace)) {
                    inputCode(strReplace);
                }
            }
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        m.checkNotNullParameter(item, "item");
        if (item.getItemId() != 2131364379) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View$OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu$ContextMenuInfo menuInfo) {
        m.checkNotNullParameter(menu, "menu");
        m.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(R$menu.menu_code_verification, menu);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SmsListener.Companion.stopSmsListener();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ignoreAutopaste) {
            this.ignoreAutopaste = false;
            return;
        }
        k kVar = new k(Unit.a);
        m.checkNotNullExpressionValue(kVar, "Observable\n          .just(Unit)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(kVar, this, null, 2, null), WidgetAuthPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthPhoneVerify$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.phone = stringExtra;
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Phone Verification", "viewed", null, 4, null);
        CharSequence charSequenceExtra = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_TITLE);
        if (charSequenceExtra == null) {
            charSequenceExtra = "";
        }
        m.checkNotNullExpressionValue(charSequenceExtra, "mostRecentIntent.getChar…INTENT_EXTRA_TITLE) ?: \"\"");
        CharSequence charSequenceExtra2 = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_SUBTITLE);
        if (charSequenceExtra2 == null) {
            charSequenceExtra2 = "";
        }
        m.checkNotNullExpressionValue(charSequenceExtra2, "mostRecentIntent.getChar…ENT_EXTRA_SUBTITLE) ?: \"\"");
        if (!m.areEqual(charSequenceExtra, "")) {
            TextView textView = getBinding().f;
            m.checkNotNullExpressionValue(textView, "binding.authPhoneVerifyTitle");
            textView.setText(charSequenceExtra);
        }
        if (!m.areEqual(charSequenceExtra2, "")) {
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.authPhoneVerifySubtitle");
            textView2.setText(charSequenceExtra2);
        }
        getBinding().d.setOnClickListener(new WidgetAuthPhoneVerify$onViewBound$1(this));
        Experiment userExperiment = StoreStream.Companion.getExperiments().getUserExperiment("2021-06_reg_bailout_to_email_android", true);
        if (userExperiment != null && userExperiment.getBucket() == 1) {
            TextView textView3 = getBinding().f2235b;
            m.checkNotNullExpressionValue(textView3, "binding.authPhoneBailout");
            textView3.setVisibility(0);
            getBinding().f2235b.setOnClickListener(new WidgetAuthPhoneVerify$onViewBound$2(this));
        }
        getBinding().c.setOnCodeEntered(new WidgetAuthPhoneVerify$onViewBound$3(this));
        registerForContextMenu(getBinding().c);
        SmsListener.Companion.startSmsListener(new WidgetAuthPhoneVerify$onViewBound$4(this));
    }
}
