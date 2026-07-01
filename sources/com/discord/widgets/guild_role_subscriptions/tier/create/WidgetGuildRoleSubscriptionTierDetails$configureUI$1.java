package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDetails this$0;

    public WidgetGuildRoleSubscriptionTierDetails$configureUI$1(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails) {
        this.this$0 = widgetGuildRoleSubscriptionTierDetails;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetPriceTierPickerBottomSheet.Companion.launch(this.this$0, "REQUEST_KEY_PRICE_TIER_PICKER");
    }
}
