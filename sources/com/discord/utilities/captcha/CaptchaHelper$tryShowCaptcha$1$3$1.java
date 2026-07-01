package com.discord.utilities.captcha;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper$tryShowCaptcha$1$3$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ CaptchaHelper$tryShowCaptcha$1$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaHelper$tryShowCaptcha$1$3$1(CaptchaHelper$tryShowCaptcha$1$3 captchaHelper$tryShowCaptcha$1$3) {
        super(1);
        this.this$0 = captchaHelper$tryShowCaptcha$1$3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "token");
        this.this$0.$emitter.onNext(str);
        this.this$0.$emitter.onCompleted();
    }
}
