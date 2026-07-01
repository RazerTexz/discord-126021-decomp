package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    public WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$2(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionConfirmationDialog$Companion guildRoleSubscriptionConfirmationDialog$Companion = GuildRoleSubscriptionConfirmationDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.getString(2131890533);
        m.checkNotNullExpressionValue(string, "getString(R.string.guild…ublish_tier_dialog_title)");
        String string2 = this.this$0.getString(2131890532);
        m.checkNotNullExpressionValue(string2, "getString(R.string.guild…_tier_dialog_description)");
        String string3 = this.this$0.getString(2131890531);
        m.checkNotNullExpressionValue(string3, "getString(R.string.guild…ription_publish_tier_cta)");
        guildRoleSubscriptionConfirmationDialog$Companion.show(parentFragmentManager, string, string2, string3, false, new WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$2$1(this));
    }
}
