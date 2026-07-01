package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.app.LoggingConfig;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1 extends o implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState, LoggingConfig> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(1);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LoggingConfig invoke(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewState) {
        return invoke2(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LoggingConfig invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewState) {
        LoggingConfig loggingConfig;
        m.checkNotNullParameter(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState, "state");
        if (serverSettingsCreatorMonetizationOnboardingViewModel$ViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) {
            loggingConfig = new LoggingConfig(false, null, new WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1$1(this, serverSettingsCreatorMonetizationOnboardingViewModel$ViewState), 3);
        } else {
            if (!(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms)) {
                return null;
            }
            loggingConfig = new LoggingConfig(false, null, new WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1$2(this, serverSettingsCreatorMonetizationOnboardingViewModel$ViewState), 3);
        }
        return loggingConfig;
    }
}
