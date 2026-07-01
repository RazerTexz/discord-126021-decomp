package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Companion {
    private WidgetServerSettingsBans$Companion() {
    }

    public final void create(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        StoreStream.Companion.getAnalytics().onGuildSettingsPaneViewed("BANS", guildId);
        Intent intentPutExtra = new Intent().putExtra("GUILD_ID", guildId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
        j.d(context, WidgetServerSettingsBans.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerSettingsBans$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
