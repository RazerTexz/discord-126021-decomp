package com.discord.widgets.servers.role_members;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$1 extends o implements Function1<ServerSettingsRoleMembersViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetServerSettingsRoleMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$1(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        super(1);
        this.this$0 = widgetServerSettingsRoleMembers;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsRoleMembersViewModel$ViewState serverSettingsRoleMembersViewModel$ViewState) {
        invoke2(serverSettingsRoleMembersViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsRoleMembersViewModel$ViewState serverSettingsRoleMembersViewModel$ViewState) {
        WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsRoleMembersViewModel$ViewState, "it");
        WidgetServerSettingsRoleMembers.access$configureUI(widgetServerSettingsRoleMembers, serverSettingsRoleMembersViewModel$ViewState);
    }
}
