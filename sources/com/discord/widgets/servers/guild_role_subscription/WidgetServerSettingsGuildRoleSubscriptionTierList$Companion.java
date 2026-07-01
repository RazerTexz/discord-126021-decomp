package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionTierList$Companion {
    private WidgetServerSettingsGuildRoleSubscriptionTierList$Companion() {
    }

    public final void launch(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        j.d(context, WidgetServerSettingsGuildRoleSubscriptionTierList.class, intent);
    }

    public /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionTierList$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
