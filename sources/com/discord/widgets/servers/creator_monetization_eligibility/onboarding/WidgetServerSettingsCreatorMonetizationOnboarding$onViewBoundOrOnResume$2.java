package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$2 extends o implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel$Event, Unit> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$2(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(1);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel$Event serverSettingsCreatorMonetizationOnboardingViewModel$Event) {
        invoke2(serverSettingsCreatorMonetizationOnboardingViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel$Event serverSettingsCreatorMonetizationOnboardingViewModel$Event) {
        m.checkNotNullParameter(serverSettingsCreatorMonetizationOnboardingViewModel$Event, "it");
        WidgetServerSettingsCreatorMonetizationOnboarding.access$handleEvent(this.this$0, serverSettingsCreatorMonetizationOnboardingViewModel$Event);
    }
}
