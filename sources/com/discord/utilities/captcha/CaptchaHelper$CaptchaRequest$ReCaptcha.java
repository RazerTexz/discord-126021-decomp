package com.discord.utilities.captcha;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CaptchaHelper$CaptchaRequest$ReCaptcha extends CaptchaHelper$CaptchaRequest {
    private final Activity activity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaHelper$CaptchaRequest$ReCaptcha(Activity activity) {
        super(null);
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.activity = activity;
    }

    public static /* synthetic */ CaptchaHelper$CaptchaRequest$ReCaptcha copy$default(CaptchaHelper$CaptchaRequest$ReCaptcha captchaHelper$CaptchaRequest$ReCaptcha, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            activity = captchaHelper$CaptchaRequest$ReCaptcha.activity;
        }
        return captchaHelper$CaptchaRequest$ReCaptcha.copy(activity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    public final CaptchaHelper$CaptchaRequest$ReCaptcha copy(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        return new CaptchaHelper$CaptchaRequest$ReCaptcha(activity);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CaptchaHelper$CaptchaRequest$ReCaptcha) && m.areEqual(this.activity, ((CaptchaHelper$CaptchaRequest$ReCaptcha) other).activity);
        }
        return true;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public int hashCode() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ReCaptcha(activity=");
        sbU.append(this.activity);
        sbU.append(")");
        return sbU.toString();
    }
}
