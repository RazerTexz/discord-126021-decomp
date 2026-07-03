package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanDetailsBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionPlanDetails$binding$2 extends C12236k implements Function1<View, WidgetGuildRoleSubscriptionPlanDetailsBinding> {
    public static final WidgetGuildRoleSubscriptionPlanDetails$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionPlanDetails$binding$2();

    public WidgetGuildRoleSubscriptionPlanDetails$binding$2() {
        super(1, WidgetGuildRoleSubscriptionPlanDetailsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanDetailsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionPlanDetailsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_role_subscription_plan_cover_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.guild_role_subscription_plan_cover_image);
        if (simpleDraweeView != null) {
            i = C5419R.id.guild_role_subscription_plan_cover_image_info;
            TextView textView = (TextView) view.findViewById(C5419R.id.guild_role_subscription_plan_cover_image_info);
            if (textView != null) {
                i = C5419R.id.guild_role_subscription_plan_cover_image_label;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_role_subscription_plan_cover_image_label);
                if (textView2 != null) {
                    i = C5419R.id.guild_role_subscription_plan_description;
                    TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C5419R.id.guild_role_subscription_plan_description);
                    if (textInputEditText != null) {
                        i = C5419R.id.guild_role_subscription_plan_description_label;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.guild_role_subscription_plan_description_label);
                        if (textView3 != null) {
                            i = C5419R.id.guild_role_subscription_plan_description_layout;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.guild_role_subscription_plan_description_layout);
                            if (textInputLayout != null) {
                                i = C5419R.id.guild_role_subscription_plan_details_divider;
                                View viewFindViewById = view.findViewById(C5419R.id.guild_role_subscription_plan_details_divider);
                                if (viewFindViewById != null) {
                                    i = C5419R.id.guild_role_subscription_plan_details_header_group;
                                    Group group = (Group) view.findViewById(C5419R.id.guild_role_subscription_plan_details_header_group);
                                    if (group != null) {
                                        i = C5419R.id.guild_role_subscription_plan_details_subtitle;
                                        TextView textView4 = (TextView) view.findViewById(C5419R.id.guild_role_subscription_plan_details_subtitle);
                                        if (textView4 != null) {
                                            i = C5419R.id.guild_role_subscription_plan_details_title;
                                            TextView textView5 = (TextView) view.findViewById(C5419R.id.guild_role_subscription_plan_details_title);
                                            if (textView5 != null) {
                                                i = C5419R.id.guild_subscription_plan_details_edit_cover_image;
                                                ImageView imageView = (ImageView) view.findViewById(C5419R.id.guild_subscription_plan_details_edit_cover_image);
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
