package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptionEditTier3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsGuildRoleSubscriptionEditTierBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptionEditTier3 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionEditTier3();

    public WidgetServerSettingsGuildRoleSubscriptionEditTier3() {
        super(1, WidgetServerSettingsGuildRoleSubscriptionEditTierBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsGuildRoleSubscriptionEditTierBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_edit_tier_publish;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_role_subscription_edit_tier_publish);
        if (materialButton != null) {
            i = R.id.guild_role_subscription_edit_tier_publish_description;
            TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_edit_tier_publish_description);
            if (textView != null) {
                i = R.id.guild_role_subscription_edit_tier_publish_group;
                Group group = (Group) view.findViewById(R.id.guild_role_subscription_edit_tier_publish_group);
                if (group != null) {
                    i = R.id.guild_role_subscription_edit_tier_tabs;
                    TabLayout tabLayout = (TabLayout) view.findViewById(R.id.guild_role_subscription_edit_tier_tabs);
                    if (tabLayout != null) {
                        i = R.id.guild_role_subscription_edit_tier_view_pager;
                        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.guild_role_subscription_edit_tier_view_pager);
                        if (viewPager2 != null) {
                            i = R.id.guild_role_subscription_edit_tier_view_pager_top_barrier;
                            Barrier barrier = (Barrier) view.findViewById(R.id.guild_role_subscription_edit_tier_view_pager_top_barrier);
                            if (barrier != null) {
                                i = R.id.server_settings_guild_role_subscription_edit_tier_app_bar;
                                AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.server_settings_guild_role_subscription_edit_tier_app_bar);
                                if (appBarLayout != null) {
                                    i = R.id.server_settings_guild_role_subscription_edit_tier_delete;
                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.server_settings_guild_role_subscription_edit_tier_delete);
                                    if (materialButton2 != null) {
                                        i = R.id.server_settings_guild_role_subscription_edit_tier_save;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.server_settings_guild_role_subscription_edit_tier_save);
                                        if (floatingActionButton != null) {
                                            i = R.id.server_settings_guild_role_subscription_edit_tier_view_flipper;
                                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_guild_role_subscription_edit_tier_view_flipper);
                                            if (appViewFlipper != null) {
                                                return new WidgetServerSettingsGuildRoleSubscriptionEditTierBinding((ConstraintLayout) view, materialButton, textView, group, tabLayout, viewPager2, barrier, appBarLayout, materialButton2, floatingActionButton, appViewFlipper);
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
