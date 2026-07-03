package com.discord.widgets.guild_role_subscriptions.setup;

import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup$createTierViewModel$2 extends AbstractC12240o implements Function0<GuildRoleSubscriptionTierViewModel> {
    public static final WidgetGuildRoleSubscriptionPlanSetup$createTierViewModel$2 INSTANCE = new WidgetGuildRoleSubscriptionPlanSetup$createTierViewModel$2();

    public WidgetGuildRoleSubscriptionPlanSetup$createTierViewModel$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierViewModel invoke() {
        return new GuildRoleSubscriptionTierViewModel();
    }
}
