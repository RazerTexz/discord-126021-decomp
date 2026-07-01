package com.discord.widgets.guild_role_subscriptions.setup;

import androidx.core.os.BundleKt;
import d0.o;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanFormat$Companion {
    private WidgetGuildRoleSubscriptionPlanFormat$Companion() {
    }

    public static /* synthetic */ WidgetGuildRoleSubscriptionPlanFormat newInstance$default(WidgetGuildRoleSubscriptionPlanFormat$Companion widgetGuildRoleSubscriptionPlanFormat$Companion, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return widgetGuildRoleSubscriptionPlanFormat$Companion.newInstance(z2);
    }

    public final WidgetGuildRoleSubscriptionPlanFormat newInstance(boolean hideHeader) {
        WidgetGuildRoleSubscriptionPlanFormat widgetGuildRoleSubscriptionPlanFormat = new WidgetGuildRoleSubscriptionPlanFormat();
        widgetGuildRoleSubscriptionPlanFormat.setArguments(BundleKt.bundleOf(o.to("INTENT_EXTRA_HIDE_HEADER", Boolean.valueOf(hideHeader))));
        return widgetGuildRoleSubscriptionPlanFormat;
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionPlanFormat$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
