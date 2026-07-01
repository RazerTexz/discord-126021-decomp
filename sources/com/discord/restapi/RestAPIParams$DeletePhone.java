package com.discord.restapi;

import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$DeletePhone {
    private final String password;

    public RestAPIParams$DeletePhone(String str) {
        m.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.password = str;
    }
}
