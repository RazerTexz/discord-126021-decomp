package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCreatorMonetizationOnboarding$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsCreatorMonetizationOnboardingBinding> {
    public static final WidgetServerSettingsCreatorMonetizationOnboarding$binding$2 INSTANCE = new WidgetServerSettingsCreatorMonetizationOnboarding$binding$2();

    public WidgetServerSettingsCreatorMonetizationOnboarding$binding$2() {
        super(1, WidgetServerSettingsCreatorMonetizationOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsCreatorMonetizationOnboardingBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.error_notice_text;
        TextView textView = (TextView) view.findViewById(C5419R.id.error_notice_text);
        if (textView != null) {
            i = C5419R.id.onboarding_accept_terms;
            ViewStub viewStub = (ViewStub) view.findViewById(C5419R.id.onboarding_accept_terms);
            if (viewStub != null) {
                i = C5419R.id.onboarding_create_request;
                ViewStub viewStub2 = (ViewStub) view.findViewById(C5419R.id.onboarding_create_request);
                if (viewStub2 != null) {
                    i = C5419R.id.view_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.view_flipper);
                    if (appViewFlipper != null) {
                        return new WidgetServerSettingsCreatorMonetizationOnboardingBinding((CoordinatorLayout) view, textView, viewStub, viewStub2, appViewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
