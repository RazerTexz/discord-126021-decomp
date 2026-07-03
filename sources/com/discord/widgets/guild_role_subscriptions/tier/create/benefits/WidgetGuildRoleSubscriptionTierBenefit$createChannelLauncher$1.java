package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.app.AppFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$createChannelLauncher$1 extends AbstractC12240o implements Function3<Long, String, Integer, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit$createChannelLauncher$1(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(3);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, String str, Integer num) {
        invoke(l.longValue(), str, num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(long j, String str, int i) {
        C12238m.checkNotNullParameter(str, "channelName");
        this.this$0.getViewModel().updateChannel(j, str, Integer.valueOf(i));
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
    }
}
