package com.discord.widgets.guild_role_subscriptions.tier.create;

import androidx.core.os.BundleKt;
import d0.o;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign$Companion {
    private WidgetGuildRoleSubscriptionTierDesign$Companion() {
    }

    public static /* synthetic */ WidgetGuildRoleSubscriptionTierDesign newInstance$default(WidgetGuildRoleSubscriptionTierDesign$Companion widgetGuildRoleSubscriptionTierDesign$Companion, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return widgetGuildRoleSubscriptionTierDesign$Companion.newInstance(z2);
    }

    public final WidgetGuildRoleSubscriptionTierDesign newInstance(boolean hideHeader) {
        WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign = new WidgetGuildRoleSubscriptionTierDesign();
        widgetGuildRoleSubscriptionTierDesign.setArguments(BundleKt.bundleOf(o.to("INTENT_EXTRA_HIDE_HEADER", Boolean.valueOf(hideHeader))));
        return widgetGuildRoleSubscriptionTierDesign;
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionTierDesign$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
