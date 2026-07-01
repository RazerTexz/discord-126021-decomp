package com.hcaptcha.sdk;

import androidx.annotation.NonNull;
import b.g.a.a.f0;
import com.adjust.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public enum HCaptchaSize implements Serializable {
    INVISIBLE("invisible"),
    NORMAL(Constants.NORMAL),
    COMPACT("compact");

    private final String size;

    HCaptchaSize(String str) {
        this.size = str;
    }

    public String getSize() {
        return this.size;
    }

    @Override // java.lang.Enum
    @NonNull
    @f0
    public String toString() {
        return this.size;
    }
}
