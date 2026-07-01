package com.discord.utilities.captcha;

import b.j.a.f.a;
import com.hcaptcha.sdk.HCaptchaError;
import com.hcaptcha.sdk.HCaptchaException;
import d0.z.d.m;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import rx.Emitter;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper$tryShowCaptcha$1$2 implements a {
    public final /* synthetic */ Emitter $emitter;
    public final /* synthetic */ Function1 $errorHandler;

    public CaptchaHelper$tryShowCaptcha$1$2(Emitter emitter, Function1 function1) {
        this.$emitter = emitter;
        this.$errorHandler = function1;
    }

    @Override // b.j.a.f.a
    public final void onFailure(HCaptchaException hCaptchaException) {
        m.checkNotNullExpressionValue(hCaptchaException, "hCaptchaException");
        if (hCaptchaException.a() == HCaptchaError.CHALLENGE_CLOSED) {
            this.$emitter.onCompleted();
            return;
        }
        String strName = hCaptchaException.a().name();
        Locale locale = Locale.ROOT;
        m.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strName.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        this.$errorHandler.invoke(new CaptchaHelper$Failure(2131887455, lowerCase));
    }
}
