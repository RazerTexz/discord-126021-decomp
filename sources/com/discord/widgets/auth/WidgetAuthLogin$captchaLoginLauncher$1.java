package com.discord.widgets.auth;

import com.discord.utilities.captcha.CaptchaHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$captchaLoginLauncher$1 extends AbstractC12240o implements Function1<CaptchaHelper.CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$captchaLoginLauncher$1(WidgetAuthLogin widgetAuthLogin) {
        super(1);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.CaptchaPayload captchaPayload) {
        invoke2(captchaPayload);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.CaptchaPayload captchaPayload) {
        C12238m.checkNotNullParameter(captchaPayload, "captchaPayload");
        WidgetAuthLogin.login$default(this.this$0, captchaPayload, false, 2, null);
    }
}
