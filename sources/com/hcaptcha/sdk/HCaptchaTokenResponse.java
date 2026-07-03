package com.hcaptcha.sdk;

import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public class HCaptchaTokenResponse {

    /* JADX INFO: renamed from: a */
    public final String f21692a;

    public HCaptchaTokenResponse(String str) {
        this.f21692a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HCaptchaTokenResponse)) {
            return false;
        }
        HCaptchaTokenResponse hCaptchaTokenResponse = (HCaptchaTokenResponse) obj;
        Objects.requireNonNull(hCaptchaTokenResponse);
        String str = this.f21692a;
        String str2 = hCaptchaTokenResponse.f21692a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f21692a;
        return (str == null ? 43 : str.hashCode()) + 59;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("HCaptchaTokenResponse(tokenResult="), this.f21692a, ")");
    }
}
