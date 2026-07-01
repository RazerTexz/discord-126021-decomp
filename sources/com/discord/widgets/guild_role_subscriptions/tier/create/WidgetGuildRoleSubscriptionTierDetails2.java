package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionDetailsBinding;
import com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionTierDetails2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionDetailsBinding> {
    public static final WidgetGuildRoleSubscriptionTierDetails2 INSTANCE = new WidgetGuildRoleSubscriptionTierDetails2();

    public WidgetGuildRoleSubscriptionTierDetails2() {
        super(1, WidgetGuildRoleSubscriptionDetailsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionDetailsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.create_subscription_tier_description;
        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.create_subscription_tier_description);
        if (textInputEditText != null) {
            i = R.id.create_subscription_tier_description_layout;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.create_subscription_tier_description_layout);
            if (textInputLayout != null) {
                i = R.id.create_subscription_tier_details_layout;
                ScrollView scrollView = (ScrollView) view.findViewById(R.id.create_subscription_tier_details_layout);
                if (scrollView != null) {
                    i = R.id.create_subscription_tier_image_upload_view;
                    GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView = (GuildSubscriptionRoleImageUploadView) view.findViewById(R.id.create_subscription_tier_image_upload_view);
                    if (guildSubscriptionRoleImageUploadView != null) {
                        i = R.id.create_subscription_tier_name;
                        TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(R.id.create_subscription_tier_name);
                        if (textInputEditText2 != null) {
                            i = R.id.create_subscription_tier_name_layout;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.create_subscription_tier_name_layout);
                            if (textInputLayout2 != null) {
                                i = R.id.create_subscription_tier_price;
                                TextView textView = (TextView) view.findViewById(R.id.create_subscription_tier_price);
                                if (textView != null) {
                                    i = R.id.create_subscription_tier_subtitle;
                                    TextView textView2 = (TextView) view.findViewById(R.id.create_subscription_tier_subtitle);
                                    if (textView2 != null) {
                                        i = R.id.create_subscription_tier_title;
                                        TextView textView3 = (TextView) view.findViewById(R.id.create_subscription_tier_title);
                                        if (textView3 != null) {
                                            i = R.id.guild_role_subscription_tier_detail_divider;
                                            View viewFindViewById = view.findViewById(R.id.guild_role_subscription_tier_detail_divider);
                                            if (viewFindViewById != null) {
                                                return new WidgetGuildRoleSubscriptionDetailsBinding((ConstraintLayout) view, textInputEditText, textInputLayout, scrollView, guildSubscriptionRoleImageUploadView, textInputEditText2, textInputLayout2, textView, textView2, textView3, viewFindViewById);
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
