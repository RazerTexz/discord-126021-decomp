package com.discord.widgets.servers.guild_role_subscription.payments;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEarnings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEarnings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsGuildRoleSubscriptionEarnings.class, "binding", "getBinding()Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;", 0)};
    public static final WidgetServerSettingsGuildRoleSubscriptionEarnings$Companion Companion = new WidgetServerSettingsGuildRoleSubscriptionEarnings$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetServerSettingsGuildRoleSubscriptionEarnings() {
        super(R$layout.view_server_settings_guild_role_subscription_unavailable_notice);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2.INSTANCE, null, 2, null);
    }

    private final ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding getBinding() {
        return (ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        getBinding().c.setText(2131890519);
        getBinding().f2211b.setText(2131890518);
    }
}
