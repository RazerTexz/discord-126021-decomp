package com.discord.widgets.guild_role_subscriptions.setup;

import androidx.core.os.BundleKt;
import d0.o;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanDetails$Companion {
    private WidgetGuildRoleSubscriptionPlanDetails$Companion() {
    }

    public static /* synthetic */ WidgetGuildRoleSubscriptionPlanDetails newInstance$default(WidgetGuildRoleSubscriptionPlanDetails$Companion widgetGuildRoleSubscriptionPlanDetails$Companion, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return widgetGuildRoleSubscriptionPlanDetails$Companion.newInstance(z2);
    }

    public final WidgetGuildRoleSubscriptionPlanDetails newInstance(boolean hideHeader) {
        WidgetGuildRoleSubscriptionPlanDetails widgetGuildRoleSubscriptionPlanDetails = new WidgetGuildRoleSubscriptionPlanDetails();
        widgetGuildRoleSubscriptionPlanDetails.setArguments(BundleKt.bundleOf(o.to(WidgetGuildRoleSubscriptionPlanDetails.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader))));
        return widgetGuildRoleSubscriptionPlanDetails;
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionPlanDetails$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
