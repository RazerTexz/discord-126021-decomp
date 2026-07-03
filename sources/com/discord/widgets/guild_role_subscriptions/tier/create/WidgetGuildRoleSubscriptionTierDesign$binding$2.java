package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierDesignBinding;
import com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionTierDesign$binding$2 extends C12236k implements Function1<View, WidgetGuildRoleSubscriptionTierDesignBinding> {
    public static final WidgetGuildRoleSubscriptionTierDesign$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionTierDesign$binding$2();

    public WidgetGuildRoleSubscriptionTierDesign$binding$2() {
        super(1, WidgetGuildRoleSubscriptionTierDesignBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierDesignBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionTierDesignBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_role_subscription_tier_appearance_color;
        View viewFindViewById = view.findViewById(C5419R.id.guild_role_subscription_tier_appearance_color);
        if (viewFindViewById != null) {
            i = C5419R.id.guild_role_subscription_tier_appearance_color_layout;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.guild_role_subscription_tier_appearance_color_layout);
            if (linearLayout != null) {
                i = C5419R.id.guild_role_subscription_tier_appearance_color_text;
                TextView textView = (TextView) view.findViewById(C5419R.id.guild_role_subscription_tier_appearance_color_text);
                if (textView != null) {
                    i = C5419R.id.guild_role_subscription_tier_appearance_subtitle;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_role_subscription_tier_appearance_subtitle);
                    if (textView2 != null) {
                        i = C5419R.id.guild_role_subscription_tier_appearance_title;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.guild_role_subscription_tier_appearance_title);
                        if (textView3 != null) {
                            i = C5419R.id.guild_role_subscription_tier_member_icon;
                            GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView = (GuildSubscriptionRoleImageUploadView) view.findViewById(C5419R.id.guild_role_subscription_tier_member_icon);
                            if (guildSubscriptionRoleImageUploadView != null) {
                                i = C5419R.id.guild_role_subscription_tier_member_preview_dark;
                                GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview = (GuildRoleSubscriptionMemberPreview) view.findViewById(C5419R.id.guild_role_subscription_tier_member_preview_dark);
                                if (guildRoleSubscriptionMemberPreview != null) {
                                    i = C5419R.id.guild_role_subscription_tier_member_preview_light;
                                    GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview2 = (GuildRoleSubscriptionMemberPreview) view.findViewById(C5419R.id.guild_role_subscription_tier_member_preview_light);
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
