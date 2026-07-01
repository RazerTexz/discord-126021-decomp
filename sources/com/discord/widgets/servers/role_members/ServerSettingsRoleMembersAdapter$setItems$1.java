package com.discord.widgets.servers.role_members;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersAdapter$setItems$1 extends o implements Function1<List<? extends ServerSettingsRoleMemberAdapterItem>, Unit> {
    public final /* synthetic */ ServerSettingsRoleMembersAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersAdapter$setItems$1(ServerSettingsRoleMembersAdapter serverSettingsRoleMembersAdapter) {
        super(1);
        this.this$0 = serverSettingsRoleMembersAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ServerSettingsRoleMemberAdapterItem> list) {
        invoke2((List<ServerSettingsRoleMemberAdapterItem>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ServerSettingsRoleMemberAdapterItem> list) {
        m.checkNotNullParameter(list, "items");
        ServerSettingsRoleMembersAdapter.access$setItems$p(this.this$0, list);
    }
}
