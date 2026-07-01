package com.discord.widgets.servers;

import com.discord.api.role.GuildRole;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$createRole$2 extends o implements Function1<GuildRole, Unit> {
    public final /* synthetic */ WidgetServerSettingsRoles$Model $dataSnapshot;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetServerSettingsRoles this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoles$createRole$2(WidgetServerSettingsRoles widgetServerSettingsRoles, long j, WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        super(1);
        this.this$0 = widgetServerSettingsRoles;
        this.$guildId = j;
        this.$dataSnapshot = widgetServerSettingsRoles$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
        invoke2(guildRole);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRole guildRole) {
        if (guildRole != null) {
            WidgetServerSettingsEditRole.Companion.launch(this.$guildId, guildRole.getId(), this.this$0.requireContext());
        } else {
            WidgetServerSettingsRoles.access$configureUI(this.this$0, this.$dataSnapshot);
        }
    }
}
