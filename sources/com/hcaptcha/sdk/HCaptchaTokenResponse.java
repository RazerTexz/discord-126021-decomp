package com.hcaptcha.sdk;

import b.d.b.a.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class HCaptchaTokenResponse {
    public final String a;

    public HCaptchaTokenResponse(String str) {
        this.a = str;
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
        String str = this.a;
        String str2 = hCaptchaTokenResponse.a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.a;
        return (str == null ? 43 : str.hashCode()) + 59;
    }

    public String toString() {
        return a.J(a.U("HCaptchaTokenResponse(tokenResult="), this.a, ")");
    }
}
