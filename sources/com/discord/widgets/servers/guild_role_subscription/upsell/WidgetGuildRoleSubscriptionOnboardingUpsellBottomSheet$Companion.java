package com.discord.widgets.servers.guild_role_subscription.upsell;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$Companion {
    private WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long guildId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet = new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet();
        widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId))));
        widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.show(fragmentManager, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
