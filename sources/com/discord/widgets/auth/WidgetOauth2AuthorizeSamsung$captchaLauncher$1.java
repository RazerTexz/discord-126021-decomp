package com.discord.widgets.auth;

import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung$captchaLauncher$1 extends o implements Function1<CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung$captchaLauncher$1(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        super(1);
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        invoke2(captchaHelper$CaptchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        m.checkNotNullParameter(captchaHelper$CaptchaPayload, "captchaPayload");
        String strAccess$getSamsungAuthCode$p = WidgetOauth2AuthorizeSamsung.access$getSamsungAuthCode$p(this.this$0);
        if (strAccess$getSamsungAuthCode$p != null) {
            WidgetOauth2AuthorizeSamsung.access$authorizeForSamsung(this.this$0, strAccess$getSamsungAuthCode$p, captchaHelper$CaptchaPayload);
        } else {
            WidgetOauth2AuthorizeSamsung$Companion.logW$default(WidgetOauth2AuthorizeSamsung.Companion, "auth code not set", null, 2, null);
        }
    }
}
