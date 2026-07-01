package com.discord.widgets.nux;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt$Companion {
    private WidgetNuxChannelPrompt$Companion() {
    }

    public final void launch(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        j.d(context, WidgetNuxChannelPrompt.class, intent);
    }

    public /* synthetic */ WidgetNuxChannelPrompt$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
