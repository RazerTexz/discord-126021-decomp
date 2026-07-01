package com.discord.widgets.guild_role_subscriptions.entrypoint;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPoint$configureUI$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetGuildRoleSubscriptionEntryPoint this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionEntryPoint$configureUI$1(WidgetGuildRoleSubscriptionEntryPoint widgetGuildRoleSubscriptionEntryPoint, WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState widgetGuildRoleSubscriptionEntryPointViewModel$ViewState) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionEntryPoint;
        this.$viewState = widgetGuildRoleSubscriptionEntryPointViewModel$ViewState;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("serverName", ((WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid) this.$viewState).getGuild().getName());
        renderContext.a("serverNameHook", new WidgetGuildRoleSubscriptionEntryPoint$configureUI$1$1(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
