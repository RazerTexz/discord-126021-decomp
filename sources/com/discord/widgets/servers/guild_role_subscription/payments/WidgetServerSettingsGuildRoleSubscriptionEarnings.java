package com.discord.widgets.servers.guild_role_subscription.payments;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEarnings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEarnings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsGuildRoleSubscriptionEarnings.class, "binding", "getBinding()Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEarnings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetServerSettingsGuildRoleSubscriptionEarnings.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetServerSettingsGuildRoleSubscriptionEarnings() {
        super(C5419R.layout.view_server_settings_guild_role_subscription_unavailable_notice);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2.INSTANCE, null, 2, null);
    }

    private final ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding getBinding() {
        return (ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        getBinding().f15567c.setText(C5419R.string.f14681x170dabe1);
        getBinding().f15566b.setText(C5419R.string.f14680x2fda02c5);
    }
}
