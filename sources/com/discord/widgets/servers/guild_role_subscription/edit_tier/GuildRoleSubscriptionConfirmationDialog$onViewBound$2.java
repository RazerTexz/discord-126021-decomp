package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionConfirmationDialog$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionConfirmationDialog this$0;

    public GuildRoleSubscriptionConfirmationDialog$onViewBound$2(GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog) {
        this.this$0 = guildRoleSubscriptionConfirmationDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
