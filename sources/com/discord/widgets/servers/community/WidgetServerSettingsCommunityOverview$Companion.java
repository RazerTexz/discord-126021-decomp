package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview$Companion {
    private WidgetServerSettingsCommunityOverview$Companion() {
    }

    public final void create(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        StoreStream.Companion.getAnalytics().onGuildSettingsPaneViewed("COMMUNITY_OVERVIEW", guildId);
        Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
        j.d(context, WidgetServerSettingsCommunityOverview.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerSettingsCommunityOverview$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
