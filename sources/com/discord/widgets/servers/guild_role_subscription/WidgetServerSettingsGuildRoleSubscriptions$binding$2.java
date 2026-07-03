package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionsBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptions$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsGuildRoleSubscriptionsBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptions$binding$2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptions$binding$2();

    public WidgetServerSettingsGuildRoleSubscriptions$binding$2() {
        super(1, WidgetServerSettingsGuildRoleSubscriptionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsGuildRoleSubscriptionsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_role_subscription_plan_details;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(C5419R.id.guild_role_subscription_plan_details);
        if (fragmentContainerView != null) {
            i = C5419R.id.guild_role_subscription_plan_format;
            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(C5419R.id.guild_role_subscription_plan_format);
            if (fragmentContainerView2 != null) {
                i = C5419R.id.guild_role_subscriptions_app_bar_layout;
                AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.guild_role_subscriptions_app_bar_layout);
                if (appBarLayout != null) {
                    i = C5419R.id.server_settings_guild_role_subscription_save;
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.server_settings_guild_role_subscription_save);
                    if (floatingActionButton != null) {
                        i = C5419R.id.server_settings_guild_role_subscription_view_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.server_settings_guild_role_subscription_view_flipper);
                        if (appViewFlipper != null) {
                            return new WidgetServerSettingsGuildRoleSubscriptionsBinding((ConstraintLayout) view, fragmentContainerView, fragmentContainerView2, appBarLayout, floatingActionButton, appViewFlipper);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
