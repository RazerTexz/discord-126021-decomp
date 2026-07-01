package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Companion {
    private WidgetServerSettingsEmojis$Companion() {
    }

    public final void create(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        StoreStream.Companion.getAnalytics().onGuildSettingsPaneViewed("EMOJIS", guildId);
        j.d(context, WidgetServerSettingsEmojis.class, new Intent().putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId));
    }

    public /* synthetic */ WidgetServerSettingsEmojis$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
