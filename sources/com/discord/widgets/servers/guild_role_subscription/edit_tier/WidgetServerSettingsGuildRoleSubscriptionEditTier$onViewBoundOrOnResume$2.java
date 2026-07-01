package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel$ViewState;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$2 extends o implements Function1<GuildRoleSubscriptionTierViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$2(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        super(1);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        invoke2(guildRoleSubscriptionTierViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getViewModel$p(this.this$0).onTierUpdated(guildRoleSubscriptionTierViewModel$ViewState.getGuildRoleSubscriptionTier());
    }
}
