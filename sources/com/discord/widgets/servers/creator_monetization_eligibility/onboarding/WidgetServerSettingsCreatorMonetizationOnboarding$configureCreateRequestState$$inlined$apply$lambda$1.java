package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest $viewState$inlined;
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    public WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$$inlined$apply$lambda$1(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) {
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
        this.$viewState$inlined = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsCreatorMonetizationOnboarding.access$getViewModel$p(this.this$0).createRequestToEnableMonetization();
    }
}
