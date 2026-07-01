package com.discord.utilities.platform;

import com.discord.api.activity.ActivityPlatform;
import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.g0.w;
import d0.z.d.m;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Platform$Companion {
    private Platform$Companion() {
    }

    public final Platform from(ActivityPlatform activityPlatform) {
        if (activityPlatform != null) {
            int iOrdinal = activityPlatform.ordinal();
            if (iOrdinal == 1) {
                return Platform.XBOX;
            }
            if (iOrdinal == 4) {
                return Platform.SAMSUNG;
            }
            if (iOrdinal == 5) {
                return Platform.SPOTIFY;
            }
            if (iOrdinal == 6) {
                return Platform.PLAYSTATION;
            }
            if (iOrdinal == 7) {
                return Platform.PLAYSTATION;
            }
        }
        return Platform.NONE;
    }

    public /* synthetic */ Platform$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Platform from(String platformName) {
        m.checkNotNullParameter(platformName, "platformName");
        try {
            String string = w.trim(platformName).toString();
            Locale locale = Locale.ENGLISH;
            m.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = string.toUpperCase(locale);
            m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return Platform.valueOf(upperCase);
        } catch (Exception unused) {
            return Platform.NONE;
        }
    }

    public final Platform from(ConnectedAccount connectedAccount) {
        m.checkNotNullParameter(connectedAccount, "connectedAccount");
        return from(connectedAccount.getType());
    }
}
