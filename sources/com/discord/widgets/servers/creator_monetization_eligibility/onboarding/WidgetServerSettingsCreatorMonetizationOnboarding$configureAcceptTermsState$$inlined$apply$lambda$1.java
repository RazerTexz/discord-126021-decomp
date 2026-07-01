package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.ScrollView;
import com.discord.utilities.view.extensions.ScrollViewExtensionsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$1 implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms $viewState$inlined;
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    public WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$1(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) {
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
        this.$viewState$inlined = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        WidgetServerSettingsCreatorMonetizationOnboarding.access$getViewModel$p(this.this$0).setHasAcceptedTerms(z2);
        if (z2) {
            ScrollView scrollView = WidgetServerSettingsCreatorMonetizationOnboarding.access$getAcceptTermsBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(scrollView, "acceptTermsBinding.acceptTermsScrollView");
            ScrollViewExtensionsKt.flashScrollBars(scrollView);
        }
    }
}
