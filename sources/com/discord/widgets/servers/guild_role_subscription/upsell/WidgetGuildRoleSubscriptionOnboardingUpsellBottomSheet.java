package com.discord.widgets.servers.guild_role_subscription.upsell;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;", 0)};
    public static final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$Companion Companion = new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$guildId$2(this));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet) {
        return widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet) {
        return widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.getGuildId();
    }

    private final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding getBinding() {
        return (WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_role_subscription_onboarding_upsell_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return new LoggingConfig(false, null, new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$loggingConfig$1(this), 3);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().c.setOnClickListener(new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$onViewCreated$1(this));
        getBinding().f2435b.setOnClickListener(new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$onViewCreated$2(this));
    }
}
