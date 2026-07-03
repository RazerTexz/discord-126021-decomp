package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptionEditTier$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsGuildRoleSubscriptionEditTierBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptionEditTier$binding$2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionEditTier$binding$2();

    public WidgetServerSettingsGuildRoleSubscriptionEditTier$binding$2() {
        super(1, WidgetServerSettingsGuildRoleSubscriptionEditTierBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsGuildRoleSubscriptionEditTierBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_role_subscription_edit_tier_publish;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.guild_role_subscription_edit_tier_publish);
        if (materialButton != null) {
            i = C5419R.id.guild_role_subscription_edit_tier_publish_description;
            TextView textView = (TextView) view.findViewById(C5419R.id.guild_role_subscription_edit_tier_publish_description);
            if (textView != null) {
                i = C5419R.id.guild_role_subscription_edit_tier_publish_group;
                Group group = (Group) view.findViewById(C5419R.id.guild_role_subscription_edit_tier_publish_group);
                if (group != null) {
                    i = C5419R.id.guild_role_subscription_edit_tier_tabs;
                    TabLayout tabLayout = (TabLayout) view.findViewById(C5419R.id.guild_role_subscription_edit_tier_tabs);
                    if (tabLayout != null) {
                        i = C5419R.id.guild_role_subscription_edit_tier_view_pager;
                        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(C5419R.id.guild_role_subscription_edit_tier_view_pager);
                        if (viewPager2 != null) {
                            i = C5419R.id.guild_role_subscription_edit_tier_view_pager_top_barrier;
                            Barrier barrier = (Barrier) view.findViewById(C5419R.id.guild_role_subscription_edit_tier_view_pager_top_barrier);
                            if (barrier != null) {
                                i = C5419R.id.server_settings_guild_role_subscription_edit_tier_app_bar;
                                AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.server_settings_guild_role_subscription_edit_tier_app_bar);
                                if (appBarLayout != null) {
                                    i = C5419R.id.server_settings_guild_role_subscription_edit_tier_delete;
                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.server_settings_guild_role_subscription_edit_tier_delete);
                                    if (materialButton2 != null) {
                                        i = C5419R.id.server_settings_guild_role_subscription_edit_tier_save;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.server_settings_guild_role_subscription_edit_tier_save);
                                        if (floatingActionButton != null) {
                                            i = C5419R.id.server_settings_guild_role_subscription_edit_tier_view_flipper;
                                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.server_settings_guild_role_subscription_edit_tier_view_flipper);
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
