package com.discord.widgets.auth;

import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation$captchaLauncher$1 extends AbstractC12240o implements Function1<CaptchaHelper.CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterAccountInformation$captchaLauncher$1(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        super(1);
        this.this$0 = widgetAuthRegisterAccountInformation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.CaptchaPayload captchaPayload) {
        invoke2(captchaPayload);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.CaptchaPayload captchaPayload) {
        C12238m.checkNotNullParameter(captchaPayload, "captchaPayload");
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Captcha", "success", null, 4, null);
        this.this$0.register(captchaPayload);
    }
}
