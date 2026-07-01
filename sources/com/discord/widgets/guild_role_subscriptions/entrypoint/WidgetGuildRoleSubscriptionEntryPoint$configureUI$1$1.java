package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPoint$configureUI$1$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionEntryPoint$configureUI$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionEntryPoint$configureUI$1$1(WidgetGuildRoleSubscriptionEntryPoint$configureUI$1 widgetGuildRoleSubscriptionEntryPoint$configureUI$1) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionEntryPoint$configureUI$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(this.this$0.this$0.getContext(), 2130969970)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
