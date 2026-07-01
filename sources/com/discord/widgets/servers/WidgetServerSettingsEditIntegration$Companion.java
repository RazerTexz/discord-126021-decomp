package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$Companion {
    private WidgetServerSettingsEditIntegration$Companion() {
    }

    public final void launch(long guildId, long integrationId, Context context) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        intent.putExtra("INTENT_EXTRA_INTEGRATION_ID", integrationId);
        j.d(context, WidgetServerSettingsEditIntegration.class, intent);
    }

    public /* synthetic */ WidgetServerSettingsEditIntegration$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
