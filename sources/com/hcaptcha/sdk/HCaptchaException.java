package com.hcaptcha.sdk;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class HCaptchaException extends Exception {
    private final HCaptchaError hCaptchaError;

    public HCaptchaException(HCaptchaError hCaptchaError) {
        this.hCaptchaError = hCaptchaError;
    }

    public HCaptchaError a() {
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
        StringBuilder sbU = outline.U("HCaptchaException(hCaptchaError=");
        sbU.append(this.hCaptchaError);
        sbU.append(")");
        return sbU.toString();
    }
}
