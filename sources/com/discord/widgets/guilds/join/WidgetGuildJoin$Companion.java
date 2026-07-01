package com.discord.widgets.guilds.join;

import android.content.Context;
import b.a.d.j;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoin$Companion {
    private WidgetGuildJoin$Companion() {
    }

    public final void show(Context context, String location) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        AnalyticsTracker.openModal$default("Join Guild", location, null, 4, null);
        j.e(context, WidgetGuildJoin$ToolbarButton.class, null, 4);
    }

    public /* synthetic */ WidgetGuildJoin$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
