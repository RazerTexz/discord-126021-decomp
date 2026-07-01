package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$3 extends o implements Function2<Long, PermissionOverwrite$Type, Unit> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$3(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(2);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, PermissionOverwrite$Type permissionOverwrite$Type) {
        invoke(l.longValue(), permissionOverwrite$Type);
        return Unit.a;
    }

    public final void invoke(long j, PermissionOverwrite$Type permissionOverwrite$Type) {
        m.checkNotNullParameter(permissionOverwrite$Type, "type");
        WidgetChannelSettingsAddMemberFragment.access$getViewModel$p(this.this$0).toggleItem(j, permissionOverwrite$Type);
    }
}
