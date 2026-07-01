package com.discord.widgets.servers.guild_role_subscription.upsell;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet this$0;

    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$onViewCreated$1(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet) {
        this.this$0 = widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsCreatorMonetizationOnboarding$Companion widgetServerSettingsCreatorMonetizationOnboarding$Companion = WidgetServerSettingsCreatorMonetizationOnboarding.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        widgetServerSettingsCreatorMonetizationOnboarding$Companion.launch(contextRequireContext, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.access$getGuildId$p(this.this$0));
        this.this$0.dismiss();
    }
}
