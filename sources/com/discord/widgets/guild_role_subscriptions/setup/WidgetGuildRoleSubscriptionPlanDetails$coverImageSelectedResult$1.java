package com.discord.widgets.guild_role_subscriptions.setup;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanDetails$coverImageSelectedResult$1<T> implements Action1<String> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanDetails this$0;

    public WidgetGuildRoleSubscriptionPlanDetails$coverImageSelectedResult$1(WidgetGuildRoleSubscriptionPlanDetails widgetGuildRoleSubscriptionPlanDetails) {
        this.this$0 = widgetGuildRoleSubscriptionPlanDetails;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetGuildRoleSubscriptionPlanDetails.access$getViewModel$p(this.this$0).updateCoverImage(str);
    }
}
