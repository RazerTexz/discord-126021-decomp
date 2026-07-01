package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel$createRequestToEnableMonetization$$inlined$updateWithViewState$lambda$2 extends o implements Function1<CreatorMonetizationEnableRequest, Unit> {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel$createRequestToEnableMonetization$$inlined$updateWithViewState$lambda$2(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        super(1);
        this.this$0 = serverSettingsCreatorMonetizationOnboardingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CreatorMonetizationEnableRequest creatorMonetizationEnableRequest) {
        invoke2(creatorMonetizationEnableRequest);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CreatorMonetizationEnableRequest creatorMonetizationEnableRequest) {
        ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel = this.this$0;
        ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState = ServerSettingsCreatorMonetizationOnboardingViewModel.access$requireViewState(serverSettingsCreatorMonetizationOnboardingViewModel);
        if (serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) {
            ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest = (ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState;
            ServerSettingsCreatorMonetizationOnboardingViewModel.access$updateViewState(serverSettingsCreatorMonetizationOnboardingViewModel, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.copy$default(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest, CreatorMonetizationEligibilityRequirements.a(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.getRequirements(), 0L, creatorMonetizationEnableRequest, false, false, false, false, null, false, false, false, null, false, null, 0, 0, 32765), false, false, 2, null));
        }
    }
}
