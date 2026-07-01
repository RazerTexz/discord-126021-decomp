package com.discord.widgets.servers.auditlog;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog$Companion {
    private WidgetServerSettingsAuditLog$Companion() {
    }

    public final void create(Context context, long guildId, String guildName) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(guildName, "guildName");
        StoreStream.Companion.getAnalytics().onGuildSettingsPaneViewed("AUDIT_LOG", guildId);
        Intent intentPutExtra = new Intent().putExtra("GUILD_ID", guildId).putExtra("GUILD_NAME", guildName);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_GUILD_NAME, guildName)");
        j.d(context, WidgetServerSettingsAuditLog.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerSettingsAuditLog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
