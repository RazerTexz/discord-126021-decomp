package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    public WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionConfirmationDialog$Companion guildRoleSubscriptionConfirmationDialog$Companion = GuildRoleSubscriptionConfirmationDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.getString(2131890657);
        m.checkNotNullExpressionValue(string, "getString(R.string.guild…elete_confirmation_title)");
        String string2 = this.this$0.getString(2131890657);
        m.checkNotNullExpressionValue(string2, "getString(R.string.guild…elete_confirmation_title)");
        String string3 = this.this$0.getString(2131890658);
        m.checkNotNullExpressionValue(string3, "getString(R.string.guild…cription_tier_delete_cta)");
        guildRoleSubscriptionConfirmationDialog$Companion.show(parentFragmentManager, string, string2, string3, true, new WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3$1(this));
    }
}
