package com.discord.widgets.auth;

import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$captchaLauncher$1 extends o implements Function1<CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$captchaLauncher$1(WidgetOauth2Authorize widgetOauth2Authorize) {
        super(1);
        this.this$0 = widgetOauth2Authorize;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        invoke2(captchaHelper$CaptchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        m.checkNotNullParameter(captchaHelper$CaptchaPayload, "captchaPayload");
        WidgetOauth2Authorize.access$authorizeApplication(this.this$0, captchaHelper$CaptchaPayload);
    }
}
