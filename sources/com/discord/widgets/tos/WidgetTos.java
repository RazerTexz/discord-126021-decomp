package com.discord.widgets.tos;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosBinding;
import com.discord.restapi.RestAPIParams$UserAgreements;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetTos.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTos extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetTos.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosBinding;", 0)};
    public static final WidgetTos$Companion Companion = new WidgetTos$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: isAcknowledgement$delegate, reason: from kotlin metadata */
    private final Lazy isAcknowledgement;

    public WidgetTos() {
        super(R$layout.widget_tos);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTos$binding$2.INSTANCE, null, 2, null);
        this.isAcknowledgement = g.lazy(new WidgetTos$isAcknowledgement$2(this));
    }

    private final void configureAcknowledgementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        TextView textView = binding.h;
        m.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        b.n(textView, 2131896283, new Object[]{DateUtils.formatDateTime(requireContext(), 1648454400000L, 4)}, null, 4);
        TextView textView2 = binding.g;
        m.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        b.n(textView2, 2131896284, new Object[0], null, 4);
    }

    private final void configureAgreementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        binding.f2674b.setOnClickListener(new WidgetTos$configureAgreementUI$$inlined$with$lambda$1(this));
        TextView textView = binding.h;
        m.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        b.n(textView, 2131896285, new Object[0], null, 4);
        TextView textView2 = binding.g;
        m.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        b.n(textView2, 2131896286, new Object[0], null, 4);
        MaterialButton materialButton = binding.f2674b;
        m.checkNotNullExpressionValue(materialButton, "alertTosAckContinue");
        b.n(materialButton, 2131889794, new Object[0], null, 4);
    }

    private final void configureCommonTosModalUI() {
        MaterialButton materialButton = getBinding().f2674b;
        m.checkNotNullExpressionValue(materialButton, "binding.alertTosAckContinue");
        b.n(materialButton, 2131889794, new Object[0], null, 4);
        getBinding().f2674b.setOnClickListener(new WidgetTos$configureCommonTosModalUI$1(this, isAcknowledgement() ? RestAPIParams$UserAgreements.Companion.acknowledge() : RestAPIParams$UserAgreements.Companion.agree()));
    }

    private final void configureCommonUI() {
        WidgetTosBinding binding = getBinding();
        LinkifiedTextView linkifiedTextView = binding.f;
        m.checkNotNullExpressionValue(linkifiedTextView, "alertTosTermsOfService");
        b.n(linkifiedTextView, 2131896288, new Object[]{getString(2131896289)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = binding.e;
        m.checkNotNullExpressionValue(linkifiedTextView2, "alertTosPrivacyPolicy");
        b.n(linkifiedTextView2, 2131894538, new Object[]{getString(2131894539)}, null, 4);
        LinkifiedTextView linkifiedTextView3 = binding.d;
        m.checkNotNullExpressionValue(linkifiedTextView3, "alertTosCommunityGuidelines");
        b.n(linkifiedTextView3, 2131887811, new Object[]{getString(2131887812)}, null, 4);
        LinkifiedTextView linkifiedTextView4 = binding.c;
        m.checkNotNullExpressionValue(linkifiedTextView4, "alertTosBlogPost");
        b.n(linkifiedTextView4, 2131887266, new Object[]{getString(2131892013)}, null, 4);
    }

    private final void configureUI() {
        configureCommonUI();
        if (isAcknowledgement()) {
            configureAcknowledgementUI();
        } else {
            configureAgreementUI();
        }
    }

    private final WidgetTosBinding getBinding() {
        return (WidgetTosBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final boolean isAcknowledgement() {
        return ((Boolean) this.isAcknowledgement.getValue()).booleanValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setOnBackPressed$default(this, WidgetTos$onViewBound$1.INSTANCE, 0, 2, null);
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_settings_logout, WidgetTos$onViewBound$2.INSTANCE, null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        configureUI();
    }
}
