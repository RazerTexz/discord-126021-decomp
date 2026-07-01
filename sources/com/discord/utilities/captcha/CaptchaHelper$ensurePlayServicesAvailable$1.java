package com.discord.utilities.captcha;

import b.i.a.f.n.e;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper$ensurePlayServicesAvailable$1<TResult> implements e<Void> {
    public final /* synthetic */ Function0 $onReady;

    public CaptchaHelper$ensurePlayServicesAvailable$1(Function0 function0) {
        this.$onReady = function0;
    }

    @Override // b.i.a.f.n.e
    public /* bridge */ /* synthetic */ void onSuccess(Void r1) {
        onSuccess2(r1);
    }

    /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
    public final void onSuccess2(Void r1) {
        this.$onReady.invoke();
    }
}
