package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCreatorMonetizationOnboarding$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsCreatorMonetizationOnboardingBinding> {
    public static final WidgetServerSettingsCreatorMonetizationOnboarding$binding$2 INSTANCE = new WidgetServerSettingsCreatorMonetizationOnboarding$binding$2();

    public WidgetServerSettingsCreatorMonetizationOnboarding$binding$2() {
        super(1, WidgetServerSettingsCreatorMonetizationOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsCreatorMonetizationOnboardingBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.error_notice_text;
        TextView textView = (TextView) view.findViewById(R.id.error_notice_text);
        if (textView != null) {
            i = R.id.onboarding_accept_terms;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.onboarding_accept_terms);
            if (viewStub != null) {
                i = R.id.onboarding_create_request;
                ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.onboarding_create_request);
                if (viewStub2 != null) {
                    i = R.id.view_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.view_flipper);
                    if (appViewFlipper != null) {
                        return new WidgetServerSettingsCreatorMonetizationOnboardingBinding((CoordinatorLayout) view, textView, viewStub, viewStub2, appViewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
