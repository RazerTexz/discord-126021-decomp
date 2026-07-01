package com.discord.widgets.servers.role_members;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$2 extends o implements Function1<ServerSettingsRoleMembersViewModel$Event, Unit> {
    public final /* synthetic */ WidgetServerSettingsRoleMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$2(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        super(1);
        this.this$0 = widgetServerSettingsRoleMembers;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsRoleMembersViewModel$Event serverSettingsRoleMembersViewModel$Event) {
        invoke2(serverSettingsRoleMembersViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsRoleMembersViewModel$Event serverSettingsRoleMembersViewModel$Event) {
        m.checkNotNullParameter(serverSettingsRoleMembersViewModel$Event, "it");
        WidgetServerSettingsRoleMembers.access$handleEvents(this.this$0, serverSettingsRoleMembersViewModel$Event);
    }
}
