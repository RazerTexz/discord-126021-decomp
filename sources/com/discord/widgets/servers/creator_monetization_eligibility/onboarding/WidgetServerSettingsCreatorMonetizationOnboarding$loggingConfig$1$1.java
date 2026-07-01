package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.analytics.generated.events.impression.TrackImpressionEnableCreatorMonetizationCreateRequestLanding;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1$1 extends o implements Function0<AnalyticsSchema> {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState $state;
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1$1(WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1 widgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewState) {
        super(0);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1;
        this.$state = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionEnableCreatorMonetizationCreateRequestLanding trackImpressionEnableCreatorMonetizationCreateRequestLanding = new TrackImpressionEnableCreatorMonetizationCreateRequestLanding(Boolean.valueOf(((ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) this.$state).getRequirements().getCanApply()), Boolean.valueOf(((ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) this.$state).isApplicationPending()), AnalyticsFormattedMonetizationRequirements.Companion.toAnalyticsFormat(((ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) this.$state).getRequirements()).toJson());
        trackImpressionEnableCreatorMonetizationCreateRequestLanding.c(new TrackGuild(Long.valueOf(WidgetServerSettingsCreatorMonetizationOnboarding.access$getGuildId$p(this.this$0.this$0)), null, null, null, null, null, null, null, null, null, null, null, 4094));
        return trackImpressionEnableCreatorMonetizationCreateRequestLanding;
    }
}
