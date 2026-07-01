package com.discord.widgets.servers.auditlog;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Companion {
    private WidgetServerSettingsAuditLogFilter$Companion() {
    }

    public final void show(Context context, long guildId, int filterType) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("ARG_GUILD_ID", guildId).putExtra("ARG_FILTER_TYPE", filterType);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_FILTER_TYPE, filterType)");
        j.d(context, WidgetServerSettingsAuditLogFilter.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerSettingsAuditLogFilter$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
