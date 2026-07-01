package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import androidx.core.os.BundleKt;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$Companion {
    private WidgetGuildRoleSubscriptionTierBenefits$Companion() {
    }

    public static /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits newInstance$default(WidgetGuildRoleSubscriptionTierBenefits$Companion widgetGuildRoleSubscriptionTierBenefits$Companion, long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return widgetGuildRoleSubscriptionTierBenefits$Companion.newInstance(j, guildRoleSubscriptionTierBenefitListType, z2);
    }

    public final WidgetGuildRoleSubscriptionTierBenefits newInstance(long guildId, GuildRoleSubscriptionTierBenefitListType benefitListType, boolean hideHeader) {
        m.checkNotNullParameter(benefitListType, "benefitListType");
        WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits = new WidgetGuildRoleSubscriptionTierBenefits();
        widgetGuildRoleSubscriptionTierBenefits.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), o.to(WidgetGuildRoleSubscriptionPlanDetails.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader)), o.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, benefitListType)));
        return widgetGuildRoleSubscriptionTierBenefits;
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
