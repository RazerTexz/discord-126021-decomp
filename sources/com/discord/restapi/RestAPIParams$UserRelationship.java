package com.discord.restapi;


/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserRelationship {
    private final String captchaKey;
    private final String captchaRqtoken;
    private final String friendToken;
    private final Integer type;

    public RestAPIParams$UserRelationship(Integer num, String str, String str2, String str3) {
        this.type = num;
        this.friendToken = str;
        this.captchaKey = str2;
        this.captchaRqtoken = str3;
    }
}
