package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionTierBenefit$binding$2 extends k implements Function1<View, WidgetGuildRoleSubscriptionTierBenefitBinding> {
    public static final WidgetGuildRoleSubscriptionTierBenefit$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionTierBenefit$binding$2();

    public WidgetGuildRoleSubscriptionTierBenefit$binding$2() {
        super(1, WidgetGuildRoleSubscriptionTierBenefitBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionTierBenefitBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionTierBenefitBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_role_subscription_benefit_channel_label;
        TextView textView = (TextView) view.findViewById(R$id.guild_role_subscription_benefit_channel_label);
        if (textView != null) {
            i = R$id.guild_role_subscription_intangible_benefit_name;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R$id.guild_role_subscription_intangible_benefit_name);
            if (textInputEditText != null) {
                i = R$id.guild_role_subscription_intangible_benefit_name_label;
                TextView textView2 = (TextView) view.findViewById(R$id.guild_role_subscription_intangible_benefit_name_label);
                if (textView2 != null) {
                    i = R$id.guild_role_subscription_intangible_benefit_name_layout;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.guild_role_subscription_intangible_benefit_name_layout);
                    if (textInputLayout != null) {
                        i = R$id.guild_role_subscription_tier_benefit_app_bar_layout;
                        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R$id.guild_role_subscription_tier_benefit_app_bar_layout);
                        if (appBarLayout != null) {
                            i = R$id.guild_role_subscription_tier_benefit_cancel;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.guild_role_subscription_tier_benefit_cancel);
                            if (materialButton != null) {
                                i = R$id.guild_role_subscription_tier_benefit_description;
                                TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R$id.guild_role_subscription_tier_benefit_description);
                                if (textInputLayout2 != null) {
                                    i = R$id.guild_role_subscription_tier_benefit_description_edit_text;
                                    TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(R$id.guild_role_subscription_tier_benefit_description_edit_text);
                                    if (textInputEditText2 != null) {
                                        i = R$id.guild_role_subscription_tier_benefit_emoji;
                                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.guild_role_subscription_tier_benefit_emoji);
                                        if (simpleDraweeView != null) {
                                            i = R$id.guild_role_subscription_tier_benefit_emoji_name;
                                            TextView textView3 = (TextView) view.findViewById(R$id.guild_role_subscription_tier_benefit_emoji_name);
                                            if (textView3 != null) {
                                                i = R$id.guild_role_subscription_tier_benefit_name;
                                                TextView textView4 = (TextView) view.findViewById(R$id.guild_role_subscription_tier_benefit_name);
                                                if (textView4 != null) {
                                                    i = R$id.guild_role_subscription_tier_benefit_remove;
                                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.guild_role_subscription_tier_benefit_remove);
                                                    if (materialButton2 != null) {
                                                        i = R$id.guild_role_subscription_tier_benefit_save;
                                                        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.guild_role_subscription_tier_benefit_save);
                                                        if (materialButton3 != null) {
                                                            i = R$id.guild_role_subscription_tier_benefit_scroll_view;
                                                            ScrollView scrollView = (ScrollView) view.findViewById(R$id.guild_role_subscription_tier_benefit_scroll_view);
                                                            if (scrollView != null) {
                                                                i = R$id.guild_role_subscription_tier_benefit_select_emoji;
                                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.guild_role_subscription_tier_benefit_select_emoji);
                                                                if (linearLayout != null) {
                                                                    i = R$id.guild_role_subscription_tier_benefit_subtitle;
                                                                    TextView textView5 = (TextView) view.findViewById(R$id.guild_role_subscription_tier_benefit_subtitle);
                                                                    if (textView5 != null) {
                                                                        i = R$id.guild_role_subscription_tier_benefit_title;
                                                                        TextView textView6 = (TextView) view.findViewById(R$id.guild_role_subscription_tier_benefit_title);
                                                                        if (textView6 != null) {
                                                                            i = R$id.guild_role_subscription_tier_channel_benefit_warning;
                                                                            TextView textView7 = (TextView) view.findViewById(R$id.guild_role_subscription_tier_channel_benefit_warning);
                                                                            if (textView7 != null) {
                                                                                return new WidgetGuildRoleSubscriptionTierBenefitBinding((ConstraintLayout) view, textView, textInputEditText, textView2, textInputLayout, appBarLayout, materialButton, textInputLayout2, textInputEditText2, simpleDraweeView, textView3, textView4, materialButton2, materialButton3, scrollView, linearLayout, textView5, textView6, textView7);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
