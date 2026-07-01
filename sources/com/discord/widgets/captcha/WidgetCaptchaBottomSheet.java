package com.discord.widgets.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCaptchaBottomSheetBinding;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest$HCaptcha;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest$ReCaptcha;
import com.discord.utilities.captcha.CaptchaService;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.google.android.material.button.MaterialButton;
import d0.e0.c;
import d0.g;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet extends AppBottomSheet {
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String NOTICE_NAME = "captcha notice";
    private static final String RESULT_EXTRA_CAPTCHA_RQTOKEN = "INTENT_EXTRA_CAPTCHA_RQTOKEN";
    private static final String RESULT_EXTRA_CAPTCHA_TOKEN = "INTENT_EXTRA_CAPTCHA_TOKEN";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: captchaErrorBody$delegate, reason: from kotlin metadata */
    private final Lazy captchaErrorBody;
    private boolean captchaPassed;
    private Function0<Unit> onCaptchaAttemptFailed;

    /* JADX INFO: renamed from: requestCode$delegate, reason: from kotlin metadata */
    private final Lazy requestCode;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCaptchaBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", 0)};
    public static final WidgetCaptchaBottomSheet$Companion Companion = new WidgetCaptchaBottomSheet$Companion(null);
    private static final List<c<? extends AppFragment>> resolvableFragments = n.listOf((Object[]) new c[]{a0.getOrCreateKotlinClass(WidgetTabsHost.class), a0.getOrCreateKotlinClass(WidgetIncomingShare.class)});

    public WidgetCaptchaBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCaptchaBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.requestCode = g.lazy(new WidgetCaptchaBottomSheet$requestCode$2(this));
        this.captchaErrorBody = g.lazy(new WidgetCaptchaBottomSheet$captchaErrorBody$2(this));
    }

    public static final /* synthetic */ void access$finishIfCaptchaTokenReceived(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet, Activity activity) {
        widgetCaptchaBottomSheet.finishIfCaptchaTokenReceived(activity);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        return widgetCaptchaBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ boolean access$getCaptchaPassed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        return widgetCaptchaBottomSheet.captchaPassed;
    }

    public static final /* synthetic */ Function0 access$getOnCaptchaAttemptFailed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        return widgetCaptchaBottomSheet.onCaptchaAttemptFailed;
    }

    public static final /* synthetic */ List access$getResolvableFragments$cp() {
        return resolvableFragments;
    }

    public static final /* synthetic */ void access$openCaptcha(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        widgetCaptchaBottomSheet.openCaptcha();
    }

    public static final /* synthetic */ void access$setCaptchaPassed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet, boolean z2) {
        widgetCaptchaBottomSheet.captchaPassed = z2;
    }

    public static final /* synthetic */ void access$setOnCaptchaAttemptFailed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet, Function0 function0) {
        widgetCaptchaBottomSheet.onCaptchaAttemptFailed = function0;
    }

    private final void configureUI() {
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.captchaTitle");
        b.n(textView, 2131889614, new Object[0], null, 4);
        TextView textView2 = getBinding().f2251b;
        m.checkNotNullExpressionValue(textView2, "binding.captchaBody");
        b.n(textView2, 2131889613, new Object[0], null, 4);
        MaterialButton materialButton = getBinding().c;
        m.checkNotNullExpressionValue(materialButton, "binding.captchaButton");
        b.n(materialButton, 2131887818, new Object[0], null, 4);
        getBinding().c.setOnClickListener(new WidgetCaptchaBottomSheet$configureUI$1(this));
    }

    private final void finishIfCaptchaTokenReceived(Activity activity) {
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        String captchaToken = captchaHelper.getCaptchaToken();
        if (captchaToken != null) {
            String captchaRqtoken = captchaHelper.getCaptchaRqtoken();
            captchaHelper.setCaptchaToken(null);
            captchaHelper.setCaptchaRqtoken(null);
            String requestCode = getRequestCode();
            Bundle bundle = new Bundle();
            bundle.putString(RESULT_EXTRA_CAPTCHA_TOKEN, captchaToken);
            bundle.putString(RESULT_EXTRA_CAPTCHA_RQTOKEN, captchaRqtoken);
            FragmentKt.setFragmentResult(this, requestCode, bundle);
            dismiss();
        }
    }

    private final WidgetCaptchaBottomSheetBinding getBinding() {
        return (WidgetCaptchaBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CaptchaErrorBody getCaptchaErrorBody() {
        return (CaptchaErrorBody) this.captchaErrorBody.getValue();
    }

    private final String getRequestCode() {
        return (String) this.requestCode.getValue();
    }

    private final void openCaptcha() {
        CaptchaHelper$CaptchaRequest captchaHelper$CaptchaRequest$ReCaptcha;
        String captchaSitekey = getCaptchaErrorBody().getCaptchaSitekey();
        CaptchaService captchaService = getCaptchaErrorBody().getCaptchaService();
        String captchaRqdata = getCaptchaErrorBody().getCaptchaRqdata();
        String captchaRqtoken = getCaptchaErrorBody().getCaptchaRqtoken();
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        captchaHelper.setCaptchaRqtoken(captchaRqtoken);
        if (captchaSitekey == null || captchaService != CaptchaService.HCAPTCHA) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            captchaHelper$CaptchaRequest$ReCaptcha = new CaptchaHelper$CaptchaRequest$ReCaptcha(fragmentActivityRequireActivity);
        } else {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            captchaHelper$CaptchaRequest$ReCaptcha = new CaptchaHelper$CaptchaRequest$HCaptcha(captchaSitekey, fragmentActivityRequireActivity2, captchaRqdata);
        }
        ObservableExtensionsKt.appSubscribe$default(captchaHelper.tryShowCaptcha(captchaHelper$CaptchaRequest$ReCaptcha), WidgetCaptchaBottomSheet.class, (Context) null, (Function1) null, new WidgetCaptchaBottomSheet$openCaptcha$2(this), (Function0) null, (Function0) null, new WidgetCaptchaBottomSheet$openCaptcha$1(this), 54, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_captcha_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Function0<Unit> function0;
        m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.captchaPassed || (function0 = this.onCaptchaAttemptFailed) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        configureUI();
    }
}
