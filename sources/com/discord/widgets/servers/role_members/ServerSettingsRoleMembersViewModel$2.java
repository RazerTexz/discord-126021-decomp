package com.discord.widgets.servers.role_members;

import com.discord.stores.StoreGatewayConnection;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ ServerSettingsRoleMembersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel$2(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel) {
        super(1);
        this.this$0 = serverSettingsRoleMembersViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        StoreGatewayConnection.requestGuildMembers$default(ServerSettingsRoleMembersViewModel.access$getStoreGatewayConnection$p(this.this$0), ServerSettingsRoleMembersViewModel.access$getGuildId$p(this.this$0), str, null, null, 12, null);
    }
}
