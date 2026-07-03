package com.discord.widgets.servers.guild_role_subscription.upsell;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet = new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet();
            widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId))));
            widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.show(fragmentManager, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$guildId$2(this));
    }

    private final WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding getBinding() {
        return (WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_role_subscription_onboarding_upsell_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return new LoggingConfig(false, null, new C9490xcea83974(this), 3);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f16926c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerSettingsCreatorMonetizationOnboarding.Companion companion = WidgetServerSettingsCreatorMonetizationOnboarding.INSTANCE;
                Context contextRequireContext = WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launch(contextRequireContext, WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.this.getGuildId());
                WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.this.dismiss();
            }
        });
        getBinding().f16925b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.this.dismiss();
            }
        });
    }
}
