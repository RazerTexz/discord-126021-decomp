package com.discord.widgets.guild_role_subscriptions.tier.create;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1 */
/* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8486x4ace8fa1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ List $steps$inlined;
    public final /* synthetic */ WidgetCreateGuildRoleSubscriptionTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8486x4ace8fa1(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, List list) {
        super(0);
        this.this$0 = widgetCreateGuildRoleSubscriptionTier;
        this.$steps$inlined = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.requireActivity().finish();
    }
}
