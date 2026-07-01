package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$DisableAccount {
    private final String code;
    private final String password;

    public RestAPIParams$DisableAccount(String str, String str2) {
        m.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.password = str;
        this.code = str2;
    }

    public /* synthetic */ RestAPIParams$DisableAccount(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }
}
