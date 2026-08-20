package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$createRequestToEnableMonetization$$inlined$updateWithViewState$lambda$1 */
/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9415xdae06f44 extends AbstractC12240o implements Function1<Error, Unit> {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9415xdae06f44(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        super(1);
        this.this$0 = serverSettingsCreatorMonetizationOnboardingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        C12238m.checkNotNullParameter(error, "it");
        ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel = this.this$0;
        ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewStateAccess$requireViewState = ServerSettingsCreatorMonetizationOnboardingViewModel.access$requireViewState(serverSettingsCreatorMonetizationOnboardingViewModel);
        if (viewStateAccess$requireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) {
            serverSettingsCreatorMonetizationOnboardingViewModel.updateViewState(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest.copy$default((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) viewStateAccess$requireViewState, null, false, false, 3, null));
        }
    }
}
