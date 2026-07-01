package com.discord.restapi;

import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$AuthRegisterPhone {
    private final String captchaKey;
    private final String captchaRqtoken;
    private final String phone;

    public RestAPIParams$AuthRegisterPhone(String str, String str2, String str3) {
        m.checkNotNullParameter(str, "phone");
        this.phone = str;
        this.captchaKey = str2;
        this.captchaRqtoken = str3;
    }
}
