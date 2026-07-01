package com.hcaptcha.sdk;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public enum HCaptchaError implements Serializable {
    NETWORK_ERROR(7, "No internet connection"),
    SESSION_TIMEOUT(15, "Session Timeout"),
    CHALLENGE_CLOSED(30, "Challenge Closed"),
    RATE_LIMITED(31, "Rate Limited"),
    ERROR(29, "Unknown error");

    private final int errorId;
    private final String message;

    HCaptchaError(int i, String str) {
        this.errorId = i;
        this.message = str;
    }

    @NonNull
    public static HCaptchaError fromId(int i) {
        HCaptchaError[] hCaptchaErrorArrValues = values();
        for (int i2 = 0; i2 < 5; i2++) {
            HCaptchaError hCaptchaError = hCaptchaErrorArrValues[i2];
            if (hCaptchaError.errorId == i) {
                return hCaptchaError;
            }
        }
        throw new RuntimeException(outline.q("Unsupported error id: ", i));
    }

    public int getErrorId() {
        return this.errorId;
    }

    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.message;
    }
}
