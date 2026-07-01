package com.discord.widgets.guilds.join;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildJoinCaptchaBottomSheetBinding;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest$HCaptcha;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest$ReCaptcha;
import com.discord.utilities.captcha.CaptchaService;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet extends AppBottomSheet {
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String NOTICE_NAME = "guild captcha notice";
    private static final String RESULT_EXTRA_CAPTCHA_RQTOKEN = "INTENT_EXTRA_CAPTCHA_RQTOKEN";
    private static final String RESULT_EXTRA_CAPTCHA_TOKEN = "INTENT_EXTRA_CAPTCHA_TOKEN";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: captchaErrorBody$delegate, reason: from kotlin metadata */
    private final Lazy captchaErrorBody;

    /* JADX INFO: renamed from: requestCode$delegate, reason: from kotlin metadata */
    private final Lazy requestCode;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildJoinCaptchaBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildJoinCaptchaBottomSheetBinding;", 0)};
    public static final WidgetGuildJoinCaptchaBottomSheet$Companion Companion = new WidgetGuildJoinCaptchaBottomSheet$Companion(null);

    public WidgetGuildJoinCaptchaBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildJoinCaptchaBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.requestCode = g.lazy(new WidgetGuildJoinCaptchaBottomSheet$requestCode$2(this));
        this.captchaErrorBody = g.lazy(new WidgetGuildJoinCaptchaBottomSheet$captchaErrorBody$2(this));
    }

    public static final /* synthetic */ void access$finishIfCaptchaTokenReceived(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet, Activity activity) {
        widgetGuildJoinCaptchaBottomSheet.finishIfCaptchaTokenReceived(activity);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet) {
        return widgetGuildJoinCaptchaBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ void access$openCaptcha(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet) {
        widgetGuildJoinCaptchaBottomSheet.openCaptcha();
    }

    private final void configureUI() {
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.guildJoinCaptchaTitle");
        b.n(textView, 2131890286, new Object[0], null, 4);
        TextView textView2 = getBinding().f2424b;
        m.checkNotNullExpressionValue(textView2, "binding.guildJoinCaptchaBody");
        b.n(textView2, 2131890285, new Object[0], null, 4);
        MaterialButton materialButton = getBinding().c;
        m.checkNotNullExpressionValue(materialButton, "binding.guildJoinCaptchaButton");
        b.n(materialButton, 2131887818, new Object[0], null, 4);
        getBinding().c.setOnClickListener(new WidgetGuildJoinCaptchaBottomSheet$configureUI$1(this));
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

    private final WidgetGuildJoinCaptchaBottomSheetBinding getBinding() {
        return (WidgetGuildJoinCaptchaBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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
        ObservableExtensionsKt.appSubscribe$default(captchaHelper.tryShowCaptcha(captchaHelper$CaptchaRequest$ReCaptcha), WidgetGuildJoinCaptchaBottomSheet.class, (Context) null, (Function1) null, new WidgetGuildJoinCaptchaBottomSheet$openCaptcha$2(this), (Function0) null, (Function0) null, new WidgetGuildJoinCaptchaBottomSheet$openCaptcha$1(this), 54, (Object) null);
    }

    public static final void show(FragmentManager fragmentManager, String str, CaptchaErrorBody captchaErrorBody) {
        Companion.show(fragmentManager, str, captchaErrorBody);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_join_captcha_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        configureUI();
    }
}
