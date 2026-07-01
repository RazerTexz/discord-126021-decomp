package com.discord.api.auth;

import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: OAuthScope.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OAuthScope$Email extends OAuthScope {
    public static final OAuthScope$Email INSTANCE = new OAuthScope$Email();

    public OAuthScope$Email() {
        super(NotificationCompat.CATEGORY_EMAIL, null);
    }
}
