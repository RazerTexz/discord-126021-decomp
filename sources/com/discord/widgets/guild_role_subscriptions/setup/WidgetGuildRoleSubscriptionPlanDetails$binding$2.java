package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanDetailsBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionPlanDetails$binding$2 extends k implements Function1<View, WidgetGuildRoleSubscriptionPlanDetailsBinding> {
    public static final WidgetGuildRoleSubscriptionPlanDetails$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionPlanDetails$binding$2();

    public WidgetGuildRoleSubscriptionPlanDetails$binding$2() {
        super(1, WidgetGuildRoleSubscriptionPlanDetailsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanDetailsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionPlanDetailsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionPlanDetailsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_role_subscription_plan_cover_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.guild_role_subscription_plan_cover_image);
        if (simpleDraweeView != null) {
            i = R$id.guild_role_subscription_plan_cover_image_info;
            TextView textView = (TextView) view.findViewById(R$id.guild_role_subscription_plan_cover_image_info);
            if (textView != null) {
                i = R$id.guild_role_subscription_plan_cover_image_label;
                TextView textView2 = (TextView) view.findViewById(R$id.guild_role_subscription_plan_cover_image_label);
                if (textView2 != null) {
                    i = R$id.guild_role_subscription_plan_description;
                    TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R$id.guild_role_subscription_plan_description);
                    if (textInputEditText != null) {
                        i = R$id.guild_role_subscription_plan_description_label;
                        TextView textView3 = (TextView) view.findViewById(R$id.guild_role_subscription_plan_description_label);
                        if (textView3 != null) {
                            i = R$id.guild_role_subscription_plan_description_layout;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.guild_role_subscription_plan_description_layout);
                            if (textInputLayout != null) {
                                i = R$id.guild_role_subscription_plan_details_divider;
                                View viewFindViewById = view.findViewById(R$id.guild_role_subscription_plan_details_divider);
                                if (viewFindViewById != null) {
                                    i = R$id.guild_role_subscription_plan_details_header_group;
                                    Group group = (Group) view.findViewById(R$id.guild_role_subscription_plan_details_header_group);
                                    if (group != null) {
                                        i = R$id.guild_role_subscription_plan_details_subtitle;
                                        TextView textView4 = (TextView) view.findViewById(R$id.guild_role_subscription_plan_details_subtitle);
                                        if (textView4 != null) {
                                            i = R$id.guild_role_subscription_plan_details_title;
                                            TextView textView5 = (TextView) view.findViewById(R$id.guild_role_subscription_plan_details_title);
                                            if (textView5 != null) {
                                                i = R$id.guild_subscription_plan_details_edit_cover_image;
                                                ImageView imageView = (ImageView) view.findViewById(R$id.guild_subscription_plan_details_edit_cover_image);
                                                if (imageView != null) {
                                                    ScrollView scrollView = (ScrollView) view;
                                                    return new WidgetGuildRoleSubscriptionPlanDetailsBinding(scrollView, simpleDraweeView, textView, textView2, textInputEditText, textView3, textInputLayout, viewFindViewById, group, textView4, textView5, imageView, scrollView);
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
