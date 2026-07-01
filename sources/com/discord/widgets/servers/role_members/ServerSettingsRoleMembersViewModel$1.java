package com.discord.widgets.servers.role_members;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel$1 extends o implements Function1<ServerSettingsRoleMembersViewModel$StoreState, Unit> {
    public final /* synthetic */ ServerSettingsRoleMembersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel$1(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel) {
        super(1);
        this.this$0 = serverSettingsRoleMembersViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsRoleMembersViewModel$StoreState serverSettingsRoleMembersViewModel$StoreState) {
        invoke2(serverSettingsRoleMembersViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsRoleMembersViewModel$StoreState serverSettingsRoleMembersViewModel$StoreState) {
        ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsRoleMembersViewModel$StoreState, "storeState");
        ServerSettingsRoleMembersViewModel.access$handleStoreState(serverSettingsRoleMembersViewModel, serverSettingsRoleMembersViewModel$StoreState);
    }
}
