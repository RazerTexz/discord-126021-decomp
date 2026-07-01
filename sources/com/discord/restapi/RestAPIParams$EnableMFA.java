package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$EnableMFA {
    private final String code;
    private final String password;
    private final String secret;

    public RestAPIParams$EnableMFA(String str, String str2, String str3) {
        a.q0(str, ModelAuditLogEntry.CHANGE_KEY_CODE, str2, "secret", str3, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.code = str;
        this.secret = str2;
        this.password = str3;
    }
}
