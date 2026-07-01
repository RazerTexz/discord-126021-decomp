package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import j0.k.b;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$3$1<T, R> implements b<MeUser, Boolean> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$3$1 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$3$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        return Boolean.valueOf(meUser.isVerified());
    }
}
