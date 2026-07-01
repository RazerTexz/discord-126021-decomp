package com.discord.restapi;

import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$VerificationCodeResend {
    private final String phone;

    public RestAPIParams$VerificationCodeResend(String str) {
        m.checkNotNullParameter(str, "phone");
        this.phone = str;
    }
}
