package com.discord.widgets.captcha;

import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.captcha.WidgetCaptchaKt, reason: use source file name */
/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptcha4 {
    public static final boolean isCaptchaError(Error error) {
        Intrinsics3.checkNotNullParameter(error, "$this$isCaptchaError");
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "response");
        return response.getMessages().keySet().contains(CaptchaHelper.CAPTCHA_KEY);
    }
}
