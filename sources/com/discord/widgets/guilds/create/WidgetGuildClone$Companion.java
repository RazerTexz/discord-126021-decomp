package com.discord.widgets.guilds.create;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildClone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildClone$Companion {
    private WidgetGuildClone$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetGuildClone$Companion widgetGuildClone$Companion, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        widgetGuildClone$Companion.show(context, str, str2);
    }

    public final void show(Context context, String guildTemplateCode, String location) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intent intentPutExtra = new Intent().putExtra(WidgetGuildCreate.EXTRA_OPTIONS, new WidgetGuildCreate$Options(location, null, false, null, false, 30, null));
        m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(EXTRA_OPTIONS, options)");
        if (guildTemplateCode != null) {
            intentPutExtra.putExtra("guild_template_code", guildTemplateCode);
        }
        j.d(context, WidgetGuildClone.class, intentPutExtra);
    }

    public /* synthetic */ WidgetGuildClone$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
