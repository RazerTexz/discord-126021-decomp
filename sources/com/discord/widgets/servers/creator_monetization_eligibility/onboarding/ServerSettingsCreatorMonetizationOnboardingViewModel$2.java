package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel$2 extends o implements Function1<Pair<? extends ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState, ? extends ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState>, Unit> {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel$2(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        super(1);
        this.this$0 = serverSettingsCreatorMonetizationOnboardingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState, ? extends ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState> pair) {
        invoke2((Pair<ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState, ? extends ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState, ? extends ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState> pair) {
        ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState serverSettingsCreatorMonetizationOnboardingViewModel$StoreStateComponent1 = pair.component1();
        ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsStateComponent2 = pair.component2();
        ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsCreatorMonetizationOnboardingViewModel$StoreStateComponent1, "storeState");
        m.checkNotNullExpressionValue(serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsStateComponent2, "requirements");
        ServerSettingsCreatorMonetizationOnboardingViewModel.access$handleStoreState(serverSettingsCreatorMonetizationOnboardingViewModel, serverSettingsCreatorMonetizationOnboardingViewModel$StoreStateComponent1, serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsStateComponent2);
    }
}
