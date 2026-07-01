package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign$setupMemberColor$2 implements View$OnClickListener {
    public final /* synthetic */ int $currentColor;
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDesign this$0;

    public WidgetGuildRoleSubscriptionTierDesign$setupMemberColor$2(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign, int i) {
        this.this$0 = widgetGuildRoleSubscriptionTierDesign;
        this.$currentColor = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildRoleSubscriptionTierDesign.access$launchColorPicker(this.this$0, this.$currentColor);
    }
}
