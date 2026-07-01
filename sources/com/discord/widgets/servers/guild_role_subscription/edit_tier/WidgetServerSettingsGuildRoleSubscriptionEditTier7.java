package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$tierViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier7 extends Lambda implements Function0<GuildRoleSubscriptionTierViewModel> {
    public static final WidgetServerSettingsGuildRoleSubscriptionEditTier7 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionEditTier7();

    public WidgetServerSettingsGuildRoleSubscriptionEditTier7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierViewModel invoke() {
        return new GuildRoleSubscriptionTierViewModel();
    }
}
