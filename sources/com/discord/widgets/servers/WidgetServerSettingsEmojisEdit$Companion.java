package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojisEdit$Companion {
    private WidgetServerSettingsEmojisEdit$Companion() {
    }

    public final void create(Context context, long guildId, long emojiId, String alias) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(alias, "alias");
        Intent intentPutExtra = new Intent().putExtra("EXTRA_GUILD_ID", guildId).putExtra("EXTRA_EMOJI_ID", emojiId).putExtra("EXTRA_EMOJI_ALIAS", alias);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…EXTRA_EMOJI_ALIAS, alias)");
        j.d(context, WidgetServerSettingsEmojisEdit.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerSettingsEmojisEdit$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
