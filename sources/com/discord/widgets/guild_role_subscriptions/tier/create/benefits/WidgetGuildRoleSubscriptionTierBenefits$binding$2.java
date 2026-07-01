package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitsBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionTierBenefits$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionTierBenefitsBinding> {
    public static final WidgetGuildRoleSubscriptionTierBenefits$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionTierBenefits$binding$2();

    public WidgetGuildRoleSubscriptionTierBenefits$binding$2() {
        super(1, WidgetGuildRoleSubscriptionTierBenefitsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionTierBenefitsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_tier_all_channels;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(R.id.guild_role_subscription_tier_all_channels);
        if (materialRadioButton != null) {
            i = R.id.guild_role_subscription_tier_benefits_divider;
            View viewFindViewById = view.findViewById(R.id.guild_role_subscription_tier_benefits_divider);
            if (viewFindViewById != null) {
                i = R.id.guild_role_subscription_tier_benefits_sub_title;
                TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_tier_benefits_sub_title);
                if (textView != null) {
                    i = R.id.guild_role_subscription_tier_benefits_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.guild_role_subscription_tier_benefits_title);
                    if (textView2 != null) {
                        i = R.id.guild_role_subscription_tier_channel_benefit_setting;
                        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.guild_role_subscription_tier_channel_benefit_setting);
                        if (radioGroup != null) {
                            i = R.id.guild_role_subscription_tier_manual_channels;
                            MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view.findViewById(R.id.guild_role_subscription_tier_manual_channels);
                            if (materialRadioButton2 != null) {
                                i = R.id.subscription_tier_benefits_recycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.subscription_tier_benefits_recycler);
                                if (recyclerView != null) {
                                    return new WidgetGuildRoleSubscriptionTierBenefitsBinding((LinearLayout) view, materialRadioButton, viewFindViewById, textView, textView2, radioGroup, materialRadioButton2, recyclerView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
