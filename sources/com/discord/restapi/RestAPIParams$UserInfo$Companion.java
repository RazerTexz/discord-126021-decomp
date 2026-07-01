package com.discord.restapi;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserInfo$Companion {
    private RestAPIParams$UserInfo$Companion() {
    }

    public final RestAPIParams$UserInfo createForEmail(CharSequence email, CharSequence password) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        return new RestAPIParams$UserInfo(null, email.toString(), null, password.toString(), null, null, null, null, null, null, null, 2037, null);
    }

    public /* synthetic */ RestAPIParams$UserInfo$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
