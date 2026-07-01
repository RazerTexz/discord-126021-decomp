package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$1 extends o implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$1(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(1);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewState) {
        invoke2(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewState) {
        WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState, "it");
        WidgetServerSettingsCreatorMonetizationOnboarding.access$configureUI(widgetServerSettingsCreatorMonetizationOnboarding, serverSettingsCreatorMonetizationOnboardingViewModel$ViewState);
        this.this$0.getAppLogger().b();
    }
}
