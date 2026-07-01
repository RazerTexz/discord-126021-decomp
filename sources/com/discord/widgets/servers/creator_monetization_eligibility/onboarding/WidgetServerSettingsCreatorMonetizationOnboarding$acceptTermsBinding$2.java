package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ScrollView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding;
import com.discord.views.LoadingButton;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsBinding$2 extends Lambda implements Function0<WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsBinding$2(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(0);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding invoke() {
        View viewInflate = this.this$0.getBinding().c.inflate();
        int i = R.id.accept_terms_button;
        LoadingButton loadingButton = (LoadingButton) viewInflate.findViewById(R.id.accept_terms_button);
        if (loadingButton != null) {
            i = R.id.accept_terms_checkbox;
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.accept_terms_checkbox);
            if (checkBox != null) {
                ScrollView scrollView = (ScrollView) viewInflate;
                i = R.id.only_guild_owner_notice;
                ViewStub viewStub = (ViewStub) viewInflate.findViewById(R.id.only_guild_owner_notice);
                if (viewStub != null) {
                    return new WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding(scrollView, loadingButton, checkBox, scrollView, viewStub);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
