package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$Companion {
    private WidgetServerSettingsEditRole$Companion() {
    }

    public final void launch(long guildId, long roleId, Context context) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        intent.putExtra("INTENT_EXTRA_ROLE_ID", roleId);
        j.d(context, WidgetServerSettingsEditRole.class, intent);
    }

    public /* synthetic */ WidgetServerSettingsEditRole$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
