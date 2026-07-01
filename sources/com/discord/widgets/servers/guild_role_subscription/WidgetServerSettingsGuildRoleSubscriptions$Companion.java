package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions$Companion {
    private WidgetServerSettingsGuildRoleSubscriptions$Companion() {
    }

    public final void launch(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID", guildId);
        j.d(context, WidgetServerSettingsGuildRoleSubscriptions.class, intent);
    }

    public /* synthetic */ WidgetServerSettingsGuildRoleSubscriptions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
