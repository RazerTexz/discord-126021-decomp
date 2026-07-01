package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$Companion {
    private WidgetServerSettingsOverview$Companion() {
    }

    public static /* synthetic */ void create$default(WidgetServerSettingsOverview$Companion widgetServerSettingsOverview$Companion, Context context, long j, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        widgetServerSettingsOverview$Companion.create(context, j, z2);
    }

    public final void create(Context context, long guildId, boolean openAvatarPicker) {
        m.checkNotNullParameter(context, "context");
        StoreStream.Companion.getAnalytics().onGuildSettingsPaneViewed("OVERVIEW", guildId);
        Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId).putExtra("INTENT_EXTRA_OPEN_AVATAR_PICKER", openAvatarPicker);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…PICKER, openAvatarPicker)");
        j.d(context, WidgetServerSettingsOverview.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerSettingsOverview$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
