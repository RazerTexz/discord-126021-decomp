package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.app.AppFragment;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$createChannelLauncher$1 extends o implements Function3<Long, String, Integer, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit$createChannelLauncher$1(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(3);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, String str, Integer num) {
        invoke(l.longValue(), str, num.intValue());
        return Unit.a;
    }

    public final void invoke(long j, String str, int i) {
        m.checkNotNullParameter(str, "channelName");
        WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(this.this$0).updateChannel(j, str, Integer.valueOf(i));
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
    }
}
