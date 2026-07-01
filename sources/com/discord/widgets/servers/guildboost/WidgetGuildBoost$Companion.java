package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$Companion {
    private WidgetGuildBoost$Companion() {
    }

    public final void create(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("GUILD_ID", guildId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
        j.d(context, WidgetGuildBoost.class, intentPutExtra);
    }

    public /* synthetic */ WidgetGuildBoost$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
