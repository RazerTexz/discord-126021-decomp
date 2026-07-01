package com.discord.widgets.stage.start;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetModeratorStartStage$Companion {
    private WidgetModeratorStartStage$Companion() {
    }

    public final void launch(Context context, long channelId, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        j.d(context, WidgetModeratorStartStage.class, intent);
    }

    public /* synthetic */ WidgetModeratorStartStage$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
