package com.discord.widgets.user.account;

import android.content.Intent;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserAccountVerifyBase.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserAccountVerifyBase$Companion {
    private WidgetUserAccountVerifyBase$Companion() {
    }

    public final Intent getLaunchIntent(WidgetUserAccountVerifyBase$Mode mode, boolean phoneAllowed, boolean emailAllowed) {
        m.checkNotNullParameter(mode, "mode");
        Intent intent = new Intent();
        intent.putExtra("INTENT_PHONE_ALLOWED", phoneAllowed);
        intent.putExtra("INTENT_EMAIL_ALLOWED", emailAllowed);
        intent.putExtra("INTENT_MODE", mode.ordinal());
        return intent;
    }

    public /* synthetic */ WidgetUserAccountVerifyBase$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
