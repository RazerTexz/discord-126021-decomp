package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember$Companion {
    private WidgetServerSettingsEditMember$Companion() {
    }

    public final void launch(long guildId, long userId, Context context) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        intent.putExtra("INTENT_EXTRA_USER_ID", userId);
        j.d(context, WidgetServerSettingsEditMember.class, intent);
    }

    public /* synthetic */ WidgetServerSettingsEditMember$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
