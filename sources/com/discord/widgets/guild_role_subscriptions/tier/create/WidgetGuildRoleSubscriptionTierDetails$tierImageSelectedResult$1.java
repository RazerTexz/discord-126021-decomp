package com.discord.widgets.guild_role_subscriptions.tier.create;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails$tierImageSelectedResult$1<T> implements Action1<String> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDetails this$0;

    public WidgetGuildRoleSubscriptionTierDetails$tierImageSelectedResult$1(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails) {
        this.this$0 = widgetGuildRoleSubscriptionTierDetails;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetGuildRoleSubscriptionTierDetails.access$getViewModel$p(this.this$0).updateImage(str);
    }
}
