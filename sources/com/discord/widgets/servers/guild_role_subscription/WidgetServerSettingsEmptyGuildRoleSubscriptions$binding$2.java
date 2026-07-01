package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2 extends k implements Function1<View, WidgetServerSettingsEmptyGuildRoleSubscriptionBinding> {
    public static final WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2 INSTANCE = new WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2();

    public WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2() {
        super(1, WidgetServerSettingsEmptyGuildRoleSubscriptionBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptionBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEmptyGuildRoleSubscriptionBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.empty_guild_role_subscription_cta;
        Button button = (Button) view.findViewById(R$id.empty_guild_role_subscription_cta);
        if (button != null) {
            i = R$id.server_settings_empty_guild_role_subscriptions_view_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.server_settings_empty_guild_role_subscriptions_view_flipper);
            if (appViewFlipper != null) {
                return new WidgetServerSettingsEmptyGuildRoleSubscriptionBinding((CoordinatorLayout) view, button, appViewFlipper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
