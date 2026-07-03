package com.discord.widgets.captcha;

import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptchaKt {
    public static final boolean isCaptchaError(Error error) {
        C12238m.checkNotNullParameter(error, "$this$isCaptchaError");
        Error.Response response = error.getResponse();
        C12238m.checkNotNullExpressionValue(response, "response");
        return response.getMessages().keySet().contains(CaptchaHelper.CAPTCHA_KEY);
    }
}
