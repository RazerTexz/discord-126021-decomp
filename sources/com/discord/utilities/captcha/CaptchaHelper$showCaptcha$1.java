package com.discord.utilities.captcha;

import b.i.a.f.n.e;
import com.google.android.gms.safetynet.SafetyNetApi$RecaptchaTokenResponse;
import com.google.android.gms.safetynet.SafetyNetApi$a;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper$showCaptcha$1<TResult> implements e<SafetyNetApi$RecaptchaTokenResponse> {
    public final /* synthetic */ Function1 $onSuccess;

    public CaptchaHelper$showCaptcha$1(Function1 function1) {
        this.$onSuccess = function1;
    }

    @Override // b.i.a.f.n.e
    public /* bridge */ /* synthetic */ void onSuccess(SafetyNetApi$RecaptchaTokenResponse safetyNetApi$RecaptchaTokenResponse) {
        onSuccess2(safetyNetApi$RecaptchaTokenResponse);
    }

    /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
    public final void onSuccess2(SafetyNetApi$RecaptchaTokenResponse safetyNetApi$RecaptchaTokenResponse) {
        m.checkNotNullExpressionValue(safetyNetApi$RecaptchaTokenResponse, "it");
        String strC = ((SafetyNetApi$a) safetyNetApi$RecaptchaTokenResponse.a).C();
        m.checkNotNullExpressionValue(strC, "userResponseToken");
        if (strC.length() == 0) {
            return;
        }
        this.$onSuccess.invoke("android:" + strC);
    }
}
