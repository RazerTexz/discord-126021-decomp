package com.discord.widgets.auth;

import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation$captchaLauncher$1 extends o implements Function1<CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterAccountInformation$captchaLauncher$1(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        super(1);
        this.this$0 = widgetAuthRegisterAccountInformation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        invoke2(captchaHelper$CaptchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        m.checkNotNullParameter(captchaHelper$CaptchaPayload, "captchaPayload");
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Captcha", "success", null, 4, null);
        WidgetAuthRegisterAccountInformation.access$register(this.this$0, captchaHelper$CaptchaPayload);
    }
}
