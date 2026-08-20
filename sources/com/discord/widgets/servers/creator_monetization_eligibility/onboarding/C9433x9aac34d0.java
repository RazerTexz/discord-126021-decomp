package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.analytics.generated.events.impression.TrackImpressionEnableCreatorMonetizationAcceptTermsLanding;
import com.discord.analytics.generated.events.impression.TrackImpressionEnableCreatorMonetizationCreateRequestLanding;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.science.AnalyticsSchema;
import com.discord.app.LoggingConfig;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1 */
/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9433x9aac34d0 extends AbstractC12240o implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState, LoggingConfig> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
        public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            super(0);
            this.$state = viewState;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AnalyticsSchema invoke() {
            TrackImpressionEnableCreatorMonetizationCreateRequestLanding trackImpressionEnableCreatorMonetizationCreateRequestLanding = new TrackImpressionEnableCreatorMonetizationCreateRequestLanding(Boolean.valueOf(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) this.$state).getRequirements().getCanApply()), Boolean.valueOf(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) this.$state).isApplicationPending()), AnalyticsFormattedMonetizationRequirements.INSTANCE.toAnalyticsFormat(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) this.$state).getRequirements()).toJson());
            trackImpressionEnableCreatorMonetizationCreateRequestLanding.mo7508c(new TrackGuild(Long.valueOf(C9433x9aac34d0.this.this$0.getGuildId()), null, null, null, null, null, null, null, null, null, null, null, 4094));
            return trackImpressionEnableCreatorMonetizationCreateRequestLanding;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class AnonymousClass2 extends AbstractC12240o implements Function0<AnalyticsSchema> {
        public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            super(0);
            this.$state = viewState;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AnalyticsSchema invoke() {
            TrackImpressionEnableCreatorMonetizationAcceptTermsLanding trackImpressionEnableCreatorMonetizationAcceptTermsLanding = new TrackImpressionEnableCreatorMonetizationAcceptTermsLanding(String.valueOf(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms) this.$state).getLatestRequest().getId()));
            trackImpressionEnableCreatorMonetizationAcceptTermsLanding.mo7508c(new TrackGuild(Long.valueOf(C9433x9aac34d0.this.this$0.getGuildId()), null, null, null, null, null, null, null, null, null, null, null, 4094));
            return trackImpressionEnableCreatorMonetizationAcceptTermsLanding;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9433x9aac34d0(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(1);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    @Override // kotlin.jvm.functions.Function1
    public final LoggingConfig invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
        LoggingConfig loggingConfig;
        C12238m.checkNotNullParameter(viewState, "state");
        if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) {
            loggingConfig = new LoggingConfig(false, null, new AnonymousClass1(viewState), 3);
        } else {
            if (!(viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms)) {
                return null;
            }
            loggingConfig = new LoggingConfig(false, null, new AnonymousClass2(viewState), 3);
        }
        return loggingConfig;
    }
}
