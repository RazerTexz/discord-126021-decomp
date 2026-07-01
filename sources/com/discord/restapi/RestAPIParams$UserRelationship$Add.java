package com.discord.restapi;

import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserRelationship$Add {
    private final String captchaKey;
    private final String captchaRqtoken;
    private final int discriminator;
    private final String username;

    public RestAPIParams$UserRelationship$Add(String str, int i, String str2, String str3) {
        m.checkNotNullParameter(str, "username");
        this.username = str;
        this.discriminator = i;
        this.captchaKey = str2;
        this.captchaRqtoken = str3;
    }
}
