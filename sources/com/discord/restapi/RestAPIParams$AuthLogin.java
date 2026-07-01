package com.discord.restapi;

import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$AuthLogin {
    private final String captchaKey;
    private final String captchaRqtoken;
    private final String login;
    private final String loginSource;
    private final String password;
    private final Boolean undelete;

    public RestAPIParams$AuthLogin(String str, String str2, String str3, String str4, Boolean bool, String str5) {
        this.login = str;
        this.password = str2;
        this.captchaKey = str3;
        this.captchaRqtoken = str4;
        this.undelete = bool;
        this.loginSource = str5;
    }
}
