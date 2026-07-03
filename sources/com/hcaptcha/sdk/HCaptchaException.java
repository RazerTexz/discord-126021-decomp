package com.hcaptcha.sdk;

import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public class HCaptchaException extends Exception {
    private final HCaptchaError hCaptchaError;

    public HCaptchaException(HCaptchaError hCaptchaError) {
        this.hCaptchaError = hCaptchaError;
    }

    /* JADX INFO: renamed from: a */
    public HCaptchaError m9265a() {
        return this.hCaptchaError;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HCaptchaException)) {
            return false;
        }
        HCaptchaException hCaptchaException = (HCaptchaException) obj;
        Objects.requireNonNull(hCaptchaException);
        if (!super.equals(obj)) {
            return false;
        }
        HCaptchaError hCaptchaError = this.hCaptchaError;
        HCaptchaError hCaptchaError2 = hCaptchaException.hCaptchaError;
        return hCaptchaError != null ? hCaptchaError.equals(hCaptchaError2) : hCaptchaError2 == null;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        return this.hCaptchaError.getMessage();
    }

    public int hashCode() {
        int iHashCode = super.hashCode();
        HCaptchaError hCaptchaError = this.hCaptchaError;
        return (iHashCode * 59) + (hCaptchaError == null ? 43 : hCaptchaError.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("HCaptchaException(hCaptchaError=");
        sbM833U.append(this.hCaptchaError);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
