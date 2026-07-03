package com.discord.widgets.servers.guild_role_subscription.upsell;

import com.discord.analytics.generated.events.impression.TrackImpressionEnableCreatorMonetizationGuildHeaderUpsell;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$loggingConfig$1 */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9490xcea83974 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9490xcea83974(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionEnableCreatorMonetizationGuildHeaderUpsell trackImpressionEnableCreatorMonetizationGuildHeaderUpsell = new TrackImpressionEnableCreatorMonetizationGuildHeaderUpsell();
        trackImpressionEnableCreatorMonetizationGuildHeaderUpsell.mo7508c(new TrackGuild(Long.valueOf(this.this$0.getGuildId()), null, null, null, null, null, null, null, null, null, null, null, 4094));
        return trackImpressionEnableCreatorMonetizationGuildHeaderUpsell;
    }
}
