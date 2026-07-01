package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierDesignBinding;
import com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionTierDesign2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionTierDesignBinding> {
    public static final WidgetGuildRoleSubscriptionTierDesign2 INSTANCE = new WidgetGuildRoleSubscriptionTierDesign2();

    public WidgetGuildRoleSubscriptionTierDesign2() {
        super(1, WidgetGuildRoleSubscriptionTierDesignBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierDesignBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionTierDesignBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_tier_appearance_color;
        View viewFindViewById = view.findViewById(R.id.guild_role_subscription_tier_appearance_color);
        if (viewFindViewById != null) {
            i = R.id.guild_role_subscription_tier_appearance_color_layout;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.guild_role_subscription_tier_appearance_color_layout);
            if (linearLayout != null) {
                i = R.id.guild_role_subscription_tier_appearance_color_text;
                TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_tier_appearance_color_text);
                if (textView != null) {
                    i = R.id.guild_role_subscription_tier_appearance_subtitle;
                    TextView textView2 = (TextView) view.findViewById(R.id.guild_role_subscription_tier_appearance_subtitle);
                    if (textView2 != null) {
                        i = R.id.guild_role_subscription_tier_appearance_title;
                        TextView textView3 = (TextView) view.findViewById(R.id.guild_role_subscription_tier_appearance_title);
                        if (textView3 != null) {
                            i = R.id.guild_role_subscription_tier_member_icon;
                            GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView = (GuildSubscriptionRoleImageUploadView) view.findViewById(R.id.guild_role_subscription_tier_member_icon);
                            if (guildSubscriptionRoleImageUploadView != null) {
                                i = R.id.guild_role_subscription_tier_member_preview_dark;
                                GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview = (GuildRoleSubscriptionMemberPreview) view.findViewById(R.id.guild_role_subscription_tier_member_preview_dark);
                                if (guildRoleSubscriptionMemberPreview != null) {
                                    i = R.id.guild_role_subscription_tier_member_preview_light;
                                    GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview2 = (GuildRoleSubscriptionMemberPreview) view.findViewById(R.id.guild_role_subscription_tier_member_preview_light);
                                    if (guildRoleSubscriptionMemberPreview2 != null) {
                                        return new WidgetGuildRoleSubscriptionTierDesignBinding((LinearLayout) view, viewFindViewById, linearLayout, textView, textView2, textView3, guildSubscriptionRoleImageUploadView, guildRoleSubscriptionMemberPreview, guildRoleSubscriptionMemberPreview2);
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
