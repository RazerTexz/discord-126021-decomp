package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions$Companion {
    private WidgetServerSettingsEmptyGuildRoleSubscriptions$Companion() {
    }

    public final void launch(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        j.d(context, WidgetServerSettingsEmptyGuildRoleSubscriptions.class, intent);
    }

    public /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
