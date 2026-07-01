package com.discord.widgets.captcha;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCaptchaBinding;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest$HCaptcha;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest$ReCaptcha;
import com.discord.utilities.captcha.CaptchaService;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import java.io.Serializable;
import java.util.List;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetCaptcha extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCaptcha.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCaptchaBinding;", 0)};
    public static final WidgetCaptcha$Companion Companion = new WidgetCaptcha$Companion(null);
    private static final String EXTRA_CAPTCHA_ERROR_BODY = "EXTRA_CAPTCHA_ERROR_BODY";
    private static final String RESULT_EXTRA_RQTOKEN = "RESULT_EXTRA_RQTOKEN";
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetCaptcha() {
        super(R$layout.widget_captcha);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCaptcha$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$finishIfCaptchaTokenReceived(WidgetCaptcha widgetCaptcha, Activity activity) {
        widgetCaptcha.finishIfCaptchaTokenReceived(activity);
    }

    private final void finishIfCaptchaTokenReceived(Activity activity) {
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        String captchaToken = captchaHelper.getCaptchaToken();
        if (captchaToken != null) {
            String captchaRqtoken = captchaHelper.getCaptchaRqtoken();
            captchaHelper.setCaptchaToken(null);
            captchaHelper.setCaptchaRqtoken(null);
            trackTransition$default(this, "submitted", null, 2, null);
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_TOKEN, captchaToken);
            intent.putExtra(RESULT_EXTRA_RQTOKEN, captchaRqtoken);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    private final WidgetCaptchaBinding getBinding() {
        return (WidgetCaptchaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackTransition$default(WidgetCaptcha widgetCaptcha, String str, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackTransition");
        }
        if ((i & 2) != 0) {
            list = null;
        }
        widgetCaptcha.trackTransition(str, list);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        finishIfCaptchaTokenReceived(requireAppActivity());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        CaptchaHelper$CaptchaRequest captchaHelper$CaptchaRequest$ReCaptcha;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(EXTRA_CAPTCHA_ERROR_BODY);
        if (!(serializableExtra instanceof CaptchaErrorBody)) {
            serializableExtra = null;
        }
        CaptchaErrorBody captchaErrorBody = (CaptchaErrorBody) serializableExtra;
        String captchaSitekey = captchaErrorBody != null ? captchaErrorBody.getCaptchaSitekey() : null;
        CaptchaService captchaService = captchaErrorBody != null ? captchaErrorBody.getCaptchaService() : null;
        String captchaRqdata = captchaErrorBody != null ? captchaErrorBody.getCaptchaRqdata() : null;
        CaptchaHelper.INSTANCE.setCaptchaRqtoken(captchaErrorBody != null ? captchaErrorBody.getCaptchaRqtoken() : null);
        if (captchaSitekey == null || captchaService != CaptchaService.HCAPTCHA) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            captchaHelper$CaptchaRequest$ReCaptcha = new CaptchaHelper$CaptchaRequest$ReCaptcha(fragmentActivityRequireActivity);
        } else {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            captchaHelper$CaptchaRequest$ReCaptcha = new CaptchaHelper$CaptchaRequest$HCaptcha(captchaSitekey, fragmentActivityRequireActivity2, captchaRqdata);
        }
        String string = captchaHelper$CaptchaRequest$ReCaptcha instanceof CaptchaHelper$CaptchaRequest$HCaptcha ? getString(2131897064) : getString(2131897067);
        m.checkNotNullExpressionValue(string, "when (captchaRequest) {\n…erify_by_recaptcha)\n    }");
        getBinding().d.setTitle(string);
        trackTransition$default(this, "viewed", null, 2, null);
        getBinding().c.setOnClickListener(new WidgetCaptcha$onViewBound$1(this, captchaHelper$CaptchaRequest$ReCaptcha));
        getBinding().f2250b.setOnClickListener(new WidgetCaptcha$onViewBound$2(this));
    }

    public void trackTransition(String action, List<String> details) {
        m.checkNotNullParameter(action, "action");
    }
}
