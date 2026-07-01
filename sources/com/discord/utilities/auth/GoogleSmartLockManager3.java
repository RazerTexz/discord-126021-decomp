package com.discord.utilities.auth;

import android.content.Context;
import android.content.Intent;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.widgets.auth.WidgetAuthLogin;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.auth.GoogleSmartLockManagerKt, reason: use source file name */
/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockManager3 {
    public static final void clearSmartLockCredentials(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "$this$clearSmartLockCredentials");
        intent.removeExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID);
        intent.removeExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD);
    }

    public static final GoogleSmartLockManager googleSmartLockManager(Context context) {
        Intrinsics3.checkNotNullParameter(context, "$this$googleSmartLockManager");
        return new GoogleSmartLockManager(context, null, 2, null);
    }

    public static final boolean hasSmartLockCredentials(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "$this$hasSmartLockCredentials");
        return intent.hasExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID);
    }

    public static final GoogleSmartLockManager.SmartLockCredentials toSmartLockCredentials(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "$this$toSmartLockCredentials");
        if (!intent.hasExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID)) {
            return null;
        }
        String stringExtra = intent.getStringExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID);
        String stringExtra2 = intent.getStringExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD);
        if (stringExtra == null || stringExtra2 == null) {
            return null;
        }
        return new GoogleSmartLockManager.SmartLockCredentials(stringExtra, stringExtra2);
    }
}
