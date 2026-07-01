package com.discord.widgets.guild_role_subscriptions.tier.create;

import androidx.core.os.BundleKt;
import d0.o;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails$Companion {
    private WidgetGuildRoleSubscriptionTierDetails$Companion() {
    }

    public static /* synthetic */ WidgetGuildRoleSubscriptionTierDetails newInstance$default(WidgetGuildRoleSubscriptionTierDetails$Companion widgetGuildRoleSubscriptionTierDetails$Companion, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return widgetGuildRoleSubscriptionTierDetails$Companion.newInstance(z2);
    }

    public final WidgetGuildRoleSubscriptionTierDetails newInstance(boolean isEditMode) {
        WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails = new WidgetGuildRoleSubscriptionTierDetails();
        widgetGuildRoleSubscriptionTierDetails.setArguments(BundleKt.bundleOf(o.to("INTENT_IS_EDIT_MODE", Boolean.valueOf(isEditMode))));
        return widgetGuildRoleSubscriptionTierDetails;
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionTierDetails$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
