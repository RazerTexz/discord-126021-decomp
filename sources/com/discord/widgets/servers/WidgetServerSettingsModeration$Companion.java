package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsModeration$Companion {
    private WidgetServerSettingsModeration$Companion() {
    }

    public final void launch(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        StoreStream.Companion.getAnalytics().onGuildSettingsPaneViewed("MODERATION", guildId);
        Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
        j.d(context, WidgetServerSettingsModeration.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerSettingsModeration$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
