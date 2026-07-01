package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup$Companion {
    private WidgetGuildRoleSubscriptionPlanSetup$Companion() {
    }

    public final void launch(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        j.d(context, WidgetGuildRoleSubscriptionPlanSetup.class, intent);
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionPlanSetup$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
