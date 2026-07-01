package com.discord.utilities.captcha;

import android.app.Activity;
import b.i.a.f.e.h.a$g;
import b.i.a.f.h.o.l;
import b.i.a.f.k.a;
import com.google.android.gms.safetynet.SafetyNetClient;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Emitter;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper$tryShowCaptcha$1$3 extends o implements Function0<Unit> {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ Emitter $emitter;
    public final /* synthetic */ Function1 $errorHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaHelper$tryShowCaptcha$1$3(Activity activity, Emitter emitter, Function1 function1) {
        super(0);
        this.$activity = activity;
        this.$emitter = emitter;
        this.$errorHandler = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        Activity activity = this.$activity;
        a$g<l> a_g = a.a;
        SafetyNetClient safetyNetClient = new SafetyNetClient(activity);
        m.checkNotNullExpressionValue(safetyNetClient, "SafetyNet\n              …     .getClient(activity)");
        CaptchaHelper.access$showCaptcha(captchaHelper, safetyNetClient, new CaptchaHelper$tryShowCaptcha$1$3$1(this), this.$errorHandler);
    }
}
