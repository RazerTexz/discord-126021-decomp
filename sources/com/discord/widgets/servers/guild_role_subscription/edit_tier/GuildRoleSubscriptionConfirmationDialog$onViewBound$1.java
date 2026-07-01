package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionConfirmationDialog$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionConfirmationDialog this$0;

    public GuildRoleSubscriptionConfirmationDialog$onViewBound$1(GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog) {
        this.this$0 = guildRoleSubscriptionConfirmationDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function0 function0Access$getConfirmCallback$p = GuildRoleSubscriptionConfirmationDialog.access$getConfirmCallback$p(this.this$0);
        if (function0Access$getConfirmCallback$p != null) {
        }
        this.this$0.dismiss();
    }
}
