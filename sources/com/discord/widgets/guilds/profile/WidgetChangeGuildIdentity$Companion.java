package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$Companion {
    private WidgetChangeGuildIdentity$Companion() {
    }

    public final void launch(long guildId, String source, Context context) {
        m.checkNotNullParameter(source, "source");
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId).putExtra("com.discord.intent.extra.EXTRA_SOURCE", source);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…nts.EXTRA_SOURCE, source)");
        j.d(context, WidgetChangeGuildIdentity.class, intentPutExtra);
    }

    public /* synthetic */ WidgetChangeGuildIdentity$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
