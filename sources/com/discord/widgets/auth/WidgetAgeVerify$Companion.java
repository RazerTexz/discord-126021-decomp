package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b.a.d.j;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify$Companion {
    private WidgetAgeVerify$Companion() {
    }

    public static /* synthetic */ void start$default(WidgetAgeVerify$Companion widgetAgeVerify$Companion, Context context, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        widgetAgeVerify$Companion.start(context, z2);
    }

    public final void start(Context context, boolean isNSFWChannel) {
        m.checkNotNullParameter(context, "context");
        AnalyticsTracker.openModal$default("Age Gate", "", null, 4, null);
        Bundle bundle = new Bundle();
        bundle.putBoolean("INTENT_EXTRA_NSFW_CHANNEL", isNSFWChannel);
        j.d(context, WidgetAgeVerify.class, new Intent().putExtras(bundle));
    }

    public /* synthetic */ WidgetAgeVerify$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
