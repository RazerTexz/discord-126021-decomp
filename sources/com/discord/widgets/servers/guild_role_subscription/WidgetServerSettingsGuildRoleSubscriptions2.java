package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionsBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptions2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsGuildRoleSubscriptionsBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptions2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptions2();

    public WidgetServerSettingsGuildRoleSubscriptions2() {
        super(1, WidgetServerSettingsGuildRoleSubscriptionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsGuildRoleSubscriptionsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_plan_details;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.guild_role_subscription_plan_details);
        if (fragmentContainerView != null) {
            i = R.id.guild_role_subscription_plan_format;
            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R.id.guild_role_subscription_plan_format);
            if (fragmentContainerView2 != null) {
                i = R.id.guild_role_subscriptions_app_bar_layout;
                AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.guild_role_subscriptions_app_bar_layout);
                if (appBarLayout != null) {
                    i = R.id.server_settings_guild_role_subscription_save;
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.server_settings_guild_role_subscription_save);
                    if (floatingActionButton != null) {
                        i = R.id.server_settings_guild_role_subscription_view_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_guild_role_subscription_view_flipper);
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
