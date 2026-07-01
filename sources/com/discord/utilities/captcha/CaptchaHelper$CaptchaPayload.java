package com.discord.utilities.captcha;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CaptchaHelper$CaptchaPayload {
    private final String captchaKey;
    private final String captchaRqtoken;

    public CaptchaHelper$CaptchaPayload(String str, String str2) {
        m.checkNotNullParameter(str, "captchaKey");
        this.captchaKey = str;
        this.captchaRqtoken = str2;
    }

    public static /* synthetic */ CaptchaHelper$CaptchaPayload copy$default(CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = captchaHelper$CaptchaPayload.captchaKey;
        }
        if ((i & 2) != 0) {
            str2 = captchaHelper$CaptchaPayload.captchaRqtoken;
        }
        return captchaHelper$CaptchaPayload.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCaptchaKey() {
        return this.captchaKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public final CaptchaHelper$CaptchaPayload copy(String captchaKey, String captchaRqtoken) {
        m.checkNotNullParameter(captchaKey, "captchaKey");
        return new CaptchaHelper$CaptchaPayload(captchaKey, captchaRqtoken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptchaHelper$CaptchaPayload)) {
            return false;
        }
        CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload = (CaptchaHelper$CaptchaPayload) other;
        return m.areEqual(this.captchaKey, captchaHelper$CaptchaPayload.captchaKey) && m.areEqual(this.captchaRqtoken, captchaHelper$CaptchaPayload.captchaRqtoken);
    }

    public final String getCaptchaKey() {
        return this.captchaKey;
    }

    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public int hashCode() {
        String str = this.captchaKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.captchaRqtoken;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CaptchaPayload(captchaKey=");
        sbU.append(this.captchaKey);
        sbU.append(", captchaRqtoken=");
        return a.J(sbU, this.captchaRqtoken, ")");
    }

    public /* synthetic */ CaptchaHelper$CaptchaPayload(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }
}
