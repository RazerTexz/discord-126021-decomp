package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel$submitTermsAcceptance$$inlined$updateWithViewState$lambda$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms $existing;
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel$submitTermsAcceptance$$inlined$updateWithViewState$lambda$1(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms, ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        super(1);
        this.$existing = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms;
        this.this$0 = serverSettingsCreatorMonetizationOnboardingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel = this.this$0;
        ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState = ServerSettingsCreatorMonetizationOnboardingViewModel.access$requireViewState(serverSettingsCreatorMonetizationOnboardingViewModel);
        if (serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) {
            ServerSettingsCreatorMonetizationOnboardingViewModel.access$updateViewState(serverSettingsCreatorMonetizationOnboardingViewModel, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.copy$default(this.$existing, null, false, null, false, false, 15, null));
        }
    }
}
