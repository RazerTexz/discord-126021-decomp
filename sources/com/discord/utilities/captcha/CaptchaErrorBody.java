package com.discord.utilities.captcha;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: CaptchaErrorBody.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CaptchaErrorBody implements Serializable {
    public static final CaptchaErrorBody$Companion Companion = new CaptchaErrorBody$Companion(null);
    private final List<String> captchaKey;
    private final String captchaRqdata;
    private final String captchaRqtoken;
    private final CaptchaService captchaService;
    private final String captchaSitekey;

    public CaptchaErrorBody(List<String> list, String str, CaptchaService captchaService, String str2, String str3) {
        this.captchaKey = list;
        this.captchaSitekey = str;
        this.captchaService = captchaService;
        this.captchaRqdata = str2;
        this.captchaRqtoken = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CaptchaErrorBody copy$default(CaptchaErrorBody captchaErrorBody, List list, String str, CaptchaService captchaService, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = captchaErrorBody.captchaKey;
        }
        if ((i & 2) != 0) {
            str = captchaErrorBody.captchaSitekey;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            captchaService = captchaErrorBody.captchaService;
        }
        CaptchaService captchaService2 = captchaService;
        if ((i & 8) != 0) {
            str2 = captchaErrorBody.captchaRqdata;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = captchaErrorBody.captchaRqtoken;
        }
        return captchaErrorBody.copy(list, str4, captchaService2, str5, str3);
    }

    public final List<String> component1() {
        return this.captchaKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCaptchaSitekey() {
        return this.captchaSitekey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CaptchaService getCaptchaService() {
        return this.captchaService;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCaptchaRqdata() {
        return this.captchaRqdata;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public final CaptchaErrorBody copy(List<String> captchaKey, String captchaSitekey, CaptchaService captchaService, String captchaRqdata, String captchaRqtoken) {
        return new CaptchaErrorBody(captchaKey, captchaSitekey, captchaService, captchaRqdata, captchaRqtoken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptchaErrorBody)) {
            return false;
        }
        CaptchaErrorBody captchaErrorBody = (CaptchaErrorBody) other;
        return m.areEqual(this.captchaKey, captchaErrorBody.captchaKey) && m.areEqual(this.captchaSitekey, captchaErrorBody.captchaSitekey) && m.areEqual(this.captchaService, captchaErrorBody.captchaService) && m.areEqual(this.captchaRqdata, captchaErrorBody.captchaRqdata) && m.areEqual(this.captchaRqtoken, captchaErrorBody.captchaRqtoken);
    }

    public final List<String> getCaptchaKey() {
        return this.captchaKey;
    }

    public final String getCaptchaRqdata() {
        return this.captchaRqdata;
    }

    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public final CaptchaService getCaptchaService() {
        return this.captchaService;
    }

    public final String getCaptchaSitekey() {
        return this.captchaSitekey;
    }

    public int hashCode() {
        List<String> list = this.captchaKey;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.captchaSitekey;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        CaptchaService captchaService = this.captchaService;
        int iHashCode3 = (iHashCode2 + (captchaService != null ? captchaService.hashCode() : 0)) * 31;
        String str2 = this.captchaRqdata;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.captchaRqtoken;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CaptchaErrorBody(captchaKey=");
        sbU.append(this.captchaKey);
        sbU.append(", captchaSitekey=");
        sbU.append(this.captchaSitekey);
        sbU.append(", captchaService=");
        sbU.append(this.captchaService);
        sbU.append(", captchaRqdata=");
        sbU.append(this.captchaRqdata);
        sbU.append(", captchaRqtoken=");
        return a.J(sbU, this.captchaRqtoken, ")");
    }
}
