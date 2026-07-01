package com.discord.widgets.captcha;

import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptchaKt {
    public static final boolean isCaptchaError(Error error) {
        m.checkNotNullParameter(error, "$this$isCaptchaError");
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "response");
        return response.getMessages().keySet().contains(CaptchaHelper.CAPTCHA_KEY);
    }
}
