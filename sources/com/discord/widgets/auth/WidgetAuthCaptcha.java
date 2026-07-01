package com.discord.widgets.auth;

import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.widgets.captcha.WidgetCaptcha;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetAuthCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthCaptcha extends WidgetCaptcha {
    public static final WidgetAuthCaptcha$Companion Companion = new WidgetAuthCaptcha$Companion(null);
    private static final String EXTRA_CAPTCHA_ERROR_BODY = "EXTRA_CAPTCHA_ERROR_BODY";
    private static final String RESULT_EXTRA_RQTOKEN = "RESULT_EXTRA_RQTOKEN";
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    @Override // com.discord.widgets.captcha.WidgetCaptcha
    public void trackTransition(String action, List<String> details) {
        m.checkNotNullParameter(action, "action");
        RegistrationFlowRepo.Companion.getINSTANCE().trackTransition("Captcha", action, details);
    }
}
