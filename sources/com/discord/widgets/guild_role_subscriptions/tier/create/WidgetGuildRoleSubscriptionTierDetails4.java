package com.discord.widgets.guild_role_subscriptions.tier.create;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails4 extends Lambda implements Function0<GuildRoleSubscriptionTierViewModel> {
    public static final WidgetGuildRoleSubscriptionTierDetails4 INSTANCE = new WidgetGuildRoleSubscriptionTierDetails4();

    public WidgetGuildRoleSubscriptionTierDetails4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierViewModel invoke() {
        return new GuildRoleSubscriptionTierViewModel();
    }
}
