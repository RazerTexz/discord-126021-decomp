package com.discord.widgets.guild_role_subscriptions.tier.create;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier$onViewBound$2<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetCreateGuildRoleSubscriptionTier this$0;

    public WidgetCreateGuildRoleSubscriptionTier$onViewBound$2(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        this.this$0 = widgetCreateGuildRoleSubscriptionTier;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        WidgetCreateGuildRoleSubscriptionTier.access$getCreateTierViewModel$p(this.this$0).goToPreviousStep();
        return Boolean.TRUE;
    }
}
