package com.discord.utilities.captcha;

import b.i.a.f.n.d;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper$showCaptcha$2 implements d {
    public final /* synthetic */ Function1 $errorHandler;

    public CaptchaHelper$showCaptcha$2(Function1 function1) {
        this.$errorHandler = function1;
    }

    @Override // b.i.a.f.n.d
    public final void onFailure(Exception exc) {
        this.$errorHandler.invoke(new CaptchaHelper$Failure(2131887455, "expired"));
    }
}
