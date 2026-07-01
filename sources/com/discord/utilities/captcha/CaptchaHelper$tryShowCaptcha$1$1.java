package com.discord.utilities.captcha;

import b.j.a.f.c;
import com.hcaptcha.sdk.HCaptchaTokenResponse;
import d0.z.d.m;
import rx.Emitter;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper$tryShowCaptcha$1$1<TResult> implements c<HCaptchaTokenResponse> {
    public final /* synthetic */ Emitter $emitter;

    public CaptchaHelper$tryShowCaptcha$1$1(Emitter emitter) {
        this.$emitter = emitter;
    }

    @Override // b.j.a.f.c
    public /* bridge */ /* synthetic */ void onSuccess(HCaptchaTokenResponse hCaptchaTokenResponse) {
        onSuccess2(hCaptchaTokenResponse);
    }

    /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
    public final void onSuccess2(HCaptchaTokenResponse hCaptchaTokenResponse) {
        Emitter emitter = this.$emitter;
        m.checkNotNullExpressionValue(hCaptchaTokenResponse, "hCaptchaTokenResponse");
        emitter.onNext(hCaptchaTokenResponse.a);
        this.$emitter.onCompleted();
    }
}
