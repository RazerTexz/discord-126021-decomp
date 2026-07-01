package com.discord.widgets.captcha;

import com.discord.app.AppActivity;
import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet$openCaptcha$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetCaptchaBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCaptchaBottomSheet$openCaptcha$1(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        super(1);
        this.this$0 = widgetCaptchaBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        CaptchaHelper.INSTANCE.setCaptchaToken(str);
        WidgetCaptchaBottomSheet.access$setCaptchaPassed$p(this.this$0, true);
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            WidgetCaptchaBottomSheet.access$finishIfCaptchaTokenReceived(this.this$0, appActivity);
        }
    }
}
