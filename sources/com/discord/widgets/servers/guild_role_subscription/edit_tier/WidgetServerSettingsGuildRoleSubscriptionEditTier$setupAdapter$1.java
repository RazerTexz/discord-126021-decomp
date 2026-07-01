package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.tabs.TabLayout$Tab;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$setupAdapter$1 extends o implements Function2<TabLayout$Tab, Integer, Unit> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier$setupAdapter$1(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        super(2);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TabLayout$Tab tabLayout$Tab, Integer num) {
        invoke(tabLayout$Tab, num.intValue());
        return Unit.a;
    }

    public final void invoke(TabLayout$Tab tabLayout$Tab, int i) {
        m.checkNotNullParameter(tabLayout$Tab, "tab");
        tabLayout$Tab.setText(WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getAdapter$p(this.this$0).getTabStringResId(i));
    }
}
