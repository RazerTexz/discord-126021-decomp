package com.discord.restapi;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$AuthRegister {
    private final String captchaKey;
    private final String captchaRqtoken;
    private final boolean consent;
    private final String dateOfBirth;
    private final String email;
    private final String fingerprint;
    private final String guildTemplateCode;
    private final String invite;
    private final String password;
    private final String phoneToken;
    private final String username;

    public RestAPIParams$AuthRegister(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10) {
        this.fingerprint = str;
        this.username = str2;
        this.email = str3;
        this.phoneToken = str4;
        this.password = str5;
        this.captchaKey = str6;
        this.captchaRqtoken = str7;
        this.invite = str8;
        this.guildTemplateCode = str9;
        this.consent = z2;
        this.dateOfBirth = str10;
    }

    public /* synthetic */ RestAPIParams$AuthRegister(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, z2, (i & 1024) != 0 ? null : str10);
    }
}
