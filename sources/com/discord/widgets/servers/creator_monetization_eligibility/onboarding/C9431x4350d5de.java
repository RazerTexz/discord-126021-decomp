package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.C5474x305cfbd8;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.creator_monetization_eligibility.EligibilityChecklistView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$createRequestBinding$2 */
/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9431x4350d5de extends AbstractC12240o implements Function0<C5474x305cfbd8> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9431x4350d5de(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(0);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C5474x305cfbd8 invoke() {
        View viewInflate = this.this$0.getBinding().f17600d.inflate();
        int i = C5419R.id.application_pending_button;
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.application_pending_button);
        if (materialButton != null) {
            i = C5419R.id.apply_button;
            LoadingButton loadingButton = (LoadingButton) viewInflate.findViewById(C5419R.id.apply_button);
            if (loadingButton != null) {
                i = C5419R.id.eligibility_checklist;
                EligibilityChecklistView eligibilityChecklistView = (EligibilityChecklistView) viewInflate.findViewById(C5419R.id.eligibility_checklist);
                if (eligibilityChecklistView != null) {
                    i = C5419R.id.eligibility_checklist_header_indicator;
                    ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.eligibility_checklist_header_indicator);
                    if (imageView != null) {
                        i = C5419R.id.eligibility_checklist_title;
                        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.eligibility_checklist_title);
                        if (textView != null) {
                            i = C5419R.id.only_guild_owner_notice;
                            ViewStub viewStub = (ViewStub) viewInflate.findViewById(C5419R.id.only_guild_owner_notice);
                            if (viewStub != null) {
                                i = C5419R.id.request_rejected_notice;
                                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.request_rejected_notice);
                                if (textView2 != null) {
                                    i = C5419R.id.requirements_description;
                                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(C5419R.id.requirements_description);
                                    if (linkifiedTextView != null) {
                                        return new C5474x305cfbd8((ScrollView) viewInflate, materialButton, loadingButton, eligibilityChecklistView, imageView, textView, viewStub, textView2, linkifiedTextView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
