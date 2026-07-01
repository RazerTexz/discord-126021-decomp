package com.discord.restapi;

import b.d.b.a.a;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$VerificationPhoneCode {
    private final String password;
    private final String phoneToken;
    private final String source;

    public RestAPIParams$VerificationPhoneCode(String str, String str2, String str3) {
        a.q0(str, "phoneToken", str2, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, str3, "source");
        this.phoneToken = str;
        this.password = str2;
        this.source = str3;
    }
}
