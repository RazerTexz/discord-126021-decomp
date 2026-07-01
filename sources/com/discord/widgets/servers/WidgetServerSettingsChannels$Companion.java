package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.AutocompleteTypes;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$Companion {
    private WidgetServerSettingsChannels$Companion() {
    }

    public final void show(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        StoreStream.Companion.getAnalytics().onGuildSettingsPaneViewed(AutocompleteTypes.CHANNELS, guildId);
        Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
        j.d(context, WidgetServerSettingsChannels.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerSettingsChannels$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
