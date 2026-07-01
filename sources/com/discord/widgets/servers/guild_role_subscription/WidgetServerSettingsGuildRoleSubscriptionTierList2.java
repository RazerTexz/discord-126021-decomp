package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionTierListBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptionTierList2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsGuildRoleSubscriptionTierListBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptionTierList2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionTierList2();

    public WidgetServerSettingsGuildRoleSubscriptionTierList2() {
        super(1, WidgetServerSettingsGuildRoleSubscriptionTierListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionTierListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsGuildRoleSubscriptionTierListBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.server_settings_guild_role_subscription_tier_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_guild_role_subscription_tier_list);
        if (recyclerView != null) {
            i = R.id.server_settings_guild_role_subscription_tier_list_view_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_guild_role_subscription_tier_list_view_flipper);
            if (appViewFlipper != null) {
                return new WidgetServerSettingsGuildRoleSubscriptionTierListBinding((CoordinatorLayout) view, recyclerView, appViewFlipper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
