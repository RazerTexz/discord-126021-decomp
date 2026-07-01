package com.discord.utilities.captcha;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Emitter;

/* JADX INFO: renamed from: com.discord.utilities.captcha.CaptchaHelper$tryShowCaptcha$1$errorHandler$1, reason: use source file name */
/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper3 extends Lambda implements Function1<CaptchaHelper.Failure, Unit> {
    public final /* synthetic */ Emitter $emitter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaHelper3(Emitter emitter) {
        super(1);
        this.$emitter = emitter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.Failure failure) {
        invoke2(failure);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.Failure failure) {
        Intrinsics3.checkNotNullParameter(failure, "it");
        AnalyticsTracker.INSTANCE.captchaFailed(failure.getReasonCode());
        this.$emitter.onError(failure);
    }
}
