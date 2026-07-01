package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserAccountVerify$Companion {
    private WidgetUserAccountVerify$Companion() {
    }

    public final void launch(Context context, RequiredAction action) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(action, "action");
        Intent launchIntent = WidgetUserAccountVerifyBase.Companion.getLaunchIntent(WidgetUserAccountVerifyBase$Mode.FORCED, action == RequiredAction.REQUIRE_VERIFIED_PHONE || action == RequiredAction.REQUIRE_VERIFIED_EMAIL || action == RequiredAction.REQUIRE_CAPTCHA, action == RequiredAction.REQUIRE_VERIFIED_EMAIL);
        AnalyticsTracker.openModal$default("Suspicious Activity", "", null, 4, null);
        j.d(context, WidgetUserAccountVerify.class, launchIntent);
    }

    public /* synthetic */ WidgetUserAccountVerify$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
