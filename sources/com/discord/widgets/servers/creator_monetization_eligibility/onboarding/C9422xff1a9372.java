package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ScrollView;
import com.discord.C5419R;
import com.discord.databinding.C5473x4f85106c;
import com.discord.views.LoadingButton;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsBinding$2 */
/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9422xff1a9372 extends AbstractC12240o implements Function0<C5473x4f85106c> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9422xff1a9372(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(0);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C5473x4f85106c invoke() {
        View viewInflate = this.this$0.getBinding().f17599c.inflate();
        int i = C5419R.id.accept_terms_button;
        LoadingButton loadingButton = (LoadingButton) viewInflate.findViewById(C5419R.id.accept_terms_button);
        if (loadingButton != null) {
            i = C5419R.id.accept_terms_checkbox;
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(C5419R.id.accept_terms_checkbox);
            if (checkBox != null) {
                ScrollView scrollView = (ScrollView) viewInflate;
                i = C5419R.id.only_guild_owner_notice;
                ViewStub viewStub = (ViewStub) viewInflate.findViewById(C5419R.id.only_guild_owner_notice);
                if (viewStub != null) {
                    return new C5473x4f85106c(scrollView, loadingButton, checkBox, scrollView, viewStub);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
