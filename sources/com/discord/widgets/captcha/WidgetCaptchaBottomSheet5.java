package com.discord.widgets.captcha;

import com.discord.utilities.captcha.CaptchaErrorBody;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$captchaErrorBody$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet5 extends Lambda implements Function0<CaptchaErrorBody> {
    public final /* synthetic */ WidgetCaptchaBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCaptchaBottomSheet5(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        super(0);
        this.this$0 = widgetCaptchaBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CaptchaErrorBody invoke() {
        Serializable serializable = this.this$0.getArgumentsOrDefault().getSerializable("INTENT_EXTRA_CAPTCHA_ERROR_BODY");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.utilities.captcha.CaptchaErrorBody");
        return (CaptchaErrorBody) serializable;
    }
}
