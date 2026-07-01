package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType$Guild;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    public WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$1(this), new EmojiPickerContextType$Guild(WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(this.this$0)), new WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$2(this));
    }
}
