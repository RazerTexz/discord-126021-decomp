package com.discord.widgets.servers.settings.members;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers$Companion {
    private WidgetServerSettingsMembers$Companion() {
    }

    public final void create(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("GUILD_ID", guildId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
        j.d(context, WidgetServerSettingsMembers.class, intentPutExtra);
        StoreStream.Companion.getAnalytics().onGuildSettingsPaneViewed("MEMBERS", guildId);
    }

    public /* synthetic */ WidgetServerSettingsMembers$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
