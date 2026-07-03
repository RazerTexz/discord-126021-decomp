package com.discord.api.auth.mfa;

import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GetBackupCodesSendVerificationKeyRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GetBackupCodesSendVerificationKeyRequestBody {
    private final String password;

    public GetBackupCodesSendVerificationKeyRequestBody(String str) {
        C12238m.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.password = str;
    }
}
