package com.discord.widgets.search;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$Companion {
    private WidgetSearch$Companion() {
    }

    private final void launch(long targetId, int targetType, Context context) {
        Intent intentPutExtra = new Intent().putExtra(WidgetSearch.INTENT_EXTRA_TARGET_ID, targetId).putExtra(WidgetSearch.INTENT_EXTRA_TARGET_TYPE, targetType);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_TARGET_TYPE, targetType)");
        j.d(context, WidgetSearch.class, intentPutExtra);
    }

    public final void launchForChannel(long channelId, Context context) {
        m.checkNotNullParameter(context, "context");
        launch(channelId, 1, context);
    }

    public final void launchForGuild(long guildId, Context context) {
        m.checkNotNullParameter(context, "context");
        launch(guildId, 0, context);
    }

    public /* synthetic */ WidgetSearch$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
