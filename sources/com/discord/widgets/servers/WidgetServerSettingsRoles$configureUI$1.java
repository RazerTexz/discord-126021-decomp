package com.discord.widgets.servers;

import com.discord.api.role.GuildRole;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$configureUI$1 extends o implements Function1<GuildRole, Unit> {
    public final /* synthetic */ WidgetServerSettingsRoles$Model $data;
    public final /* synthetic */ WidgetServerSettingsRoles this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoles$configureUI$1(WidgetServerSettingsRoles widgetServerSettingsRoles, WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        super(1);
        this.this$0 = widgetServerSettingsRoles;
        this.$data = widgetServerSettingsRoles$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
        invoke2(guildRole);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRole guildRole) {
        m.checkNotNullParameter(guildRole, "<name for destructuring parameter 0>");
        WidgetServerSettingsEditRole.Companion.launch(this.$data.getGuildId(), guildRole.getId(), this.this$0.requireContext());
    }
}
