package com.discord.restapi;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserInfo {
    public static final RestAPIParams$UserInfo$Companion Companion = new RestAPIParams$UserInfo$Companion(null);
    private final String avatar;
    private final String code;
    private final String dateOfBirth;
    private final String discriminator;
    private final String email;
    private final String emailToken;
    private final Integer flags;
    private final String newPassword;
    private final String password;
    private final String pushProvider;
    private final String pushToken;
    private final String username;

    public RestAPIParams$UserInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public RestAPIParams$UserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10) {
        this.avatar = str;
        this.email = str2;
        this.emailToken = str3;
        this.password = str4;
        this.newPassword = str5;
        this.username = str6;
        this.pushToken = str7;
        this.code = str8;
        this.discriminator = str9;
        this.flags = num;
        this.dateOfBirth = str10;
        this.pushProvider = "gcm";
    }

    public static final RestAPIParams$UserInfo createForEmail(CharSequence charSequence, CharSequence charSequence2) {
        return Companion.createForEmail(charSequence, charSequence2);
    }

    public /* synthetic */ RestAPIParams$UserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : num, (i & 1024) == 0 ? str10 : null);
    }
}
