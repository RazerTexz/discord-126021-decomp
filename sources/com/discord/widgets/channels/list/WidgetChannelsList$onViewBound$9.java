package com.discord.widgets.channels.list;

import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$9 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$9(WidgetChannelsList widgetChannelsList) {
        super(0);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Long lAccess$getSelectedGuildId$p = WidgetChannelsList.access$getSelectedGuildId$p(this.this$0);
        if (lAccess$getSelectedGuildId$p != null) {
            WidgetGuildRoleSubscriptionEntryPoint.Companion.launch(this.this$0.requireContext(), lAccess$getSelectedGuildId$p.longValue(), "Role Subscriptions Tab");
        }
    }
}
