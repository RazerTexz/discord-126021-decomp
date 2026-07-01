package com.discord.widgets.captcha;

import com.discord.utilities.captcha.CaptchaHelper$Failure;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptcha$onViewBound$1$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetCaptcha$onViewBound$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCaptcha$onViewBound$1$2(WidgetCaptcha$onViewBound$1 widgetCaptcha$onViewBound$1) {
        super(1);
        this.this$0 = widgetCaptcha$onViewBound$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetCaptcha.trackTransition$default(this.this$0.this$0, "submitted", null, 2, null);
        this.this$0.this$0.trackTransition("response_error", d0.t.m.listOf("captcha"));
        Throwable throwable = error.getThrowable();
        if (!(throwable instanceof CaptchaHelper$Failure)) {
            throwable = null;
        }
        CaptchaHelper$Failure captchaHelper$Failure = (CaptchaHelper$Failure) throwable;
        if (captchaHelper$Failure != null) {
            b.a.d.m.g(this.this$0.this$0.getAppActivity(), captchaHelper$Failure.getErrorStringId(), 0, null, 12);
        }
    }
}
