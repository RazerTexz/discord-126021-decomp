package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.channels.WidgetCreateChannel$Companion;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$2(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetCreateChannel$Companion.launch$default(WidgetCreateChannel.Companion, this.this$0.requireContext(), WidgetGuildRoleSubscriptionTierBenefit.access$getCreateChannelLauncher$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(this.this$0), 0, null, true, true, true, true, 24, null);
    }
}
