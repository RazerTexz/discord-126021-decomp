package com.discord.widgets.guild_role_subscriptions.setup;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup$onViewBound$2<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanSetup this$0;

    public WidgetGuildRoleSubscriptionPlanSetup$onViewBound$2(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        this.this$0 = widgetGuildRoleSubscriptionPlanSetup;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        WidgetGuildRoleSubscriptionPlanSetup.access$getSetupViewModel$p(this.this$0).goToPreviousStep();
        return Boolean.TRUE;
    }
}
