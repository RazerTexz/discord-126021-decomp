package com.discord.utilities.captcha;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CaptchaHelper$CaptchaRequest$HCaptcha extends CaptchaHelper$CaptchaRequest {
    private final Activity activity;
    private final String rqdata;
    private final String siteKey;

    public /* synthetic */ CaptchaHelper$CaptchaRequest$HCaptcha(String str, Activity activity, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, activity, (i & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ CaptchaHelper$CaptchaRequest$HCaptcha copy$default(CaptchaHelper$CaptchaRequest$HCaptcha captchaHelper$CaptchaRequest$HCaptcha, String str, Activity activity, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = captchaHelper$CaptchaRequest$HCaptcha.siteKey;
        }
        if ((i & 2) != 0) {
            activity = captchaHelper$CaptchaRequest$HCaptcha.activity;
        }
        if ((i & 4) != 0) {
            str2 = captchaHelper$CaptchaRequest$HCaptcha.rqdata;
        }
        return captchaHelper$CaptchaRequest$HCaptcha.copy(str, activity, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSiteKey() {
        return this.siteKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRqdata() {
        return this.rqdata;
    }

    public final CaptchaHelper$CaptchaRequest$HCaptcha copy(String siteKey, Activity activity, String rqdata) {
        m.checkNotNullParameter(siteKey, "siteKey");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        return new CaptchaHelper$CaptchaRequest$HCaptcha(siteKey, activity, rqdata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptchaHelper$CaptchaRequest$HCaptcha)) {
            return false;
        }
        CaptchaHelper$CaptchaRequest$HCaptcha captchaHelper$CaptchaRequest$HCaptcha = (CaptchaHelper$CaptchaRequest$HCaptcha) other;
        return m.areEqual(this.siteKey, captchaHelper$CaptchaRequest$HCaptcha.siteKey) && m.areEqual(this.activity, captchaHelper$CaptchaRequest$HCaptcha.activity) && m.areEqual(this.rqdata, captchaHelper$CaptchaRequest$HCaptcha.rqdata);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final String getRqdata() {
        return this.rqdata;
    }

    public final String getSiteKey() {
        return this.siteKey;
    }

    public int hashCode() {
        String str = this.siteKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Activity activity = this.activity;
        int iHashCode2 = (iHashCode + (activity != null ? activity.hashCode() : 0)) * 31;
        String str2 = this.rqdata;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HCaptcha(siteKey=");
        sbU.append(this.siteKey);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(", rqdata=");
        return a.J(sbU, this.rqdata, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaHelper$CaptchaRequest$HCaptcha(String str, Activity activity, String str2) {
        super(null);
        m.checkNotNullParameter(str, "siteKey");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.siteKey = str;
        this.activity = activity;
        this.rqdata = str2;
    }
}
