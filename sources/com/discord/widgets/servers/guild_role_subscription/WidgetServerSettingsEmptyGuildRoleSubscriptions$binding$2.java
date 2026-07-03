package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsEmptyGuildRoleSubscriptionBinding> {
    public static final WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2 INSTANCE = new WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2();

    public WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2() {
        super(1, WidgetServerSettingsEmptyGuildRoleSubscriptionBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsEmptyGuildRoleSubscriptionBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.empty_guild_role_subscription_cta;
        Button button = (Button) view.findViewById(C5419R.id.empty_guild_role_subscription_cta);
        if (button != null) {
            i = C5419R.id.server_settings_empty_guild_role_subscriptions_view_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.server_settings_empty_guild_role_subscriptions_view_flipper);
            if (appViewFlipper != null) {
                return new WidgetServerSettingsEmptyGuildRoleSubscriptionBinding((CoordinatorLayout) view, button, appViewFlipper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
