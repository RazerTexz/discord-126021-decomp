package com.discord.widgets.servers.role_members;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel$removeRoleFromMember$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ ServerSettingsRoleMembersViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ ServerSettingsRoleMembersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel$removeRoleFromMember$1(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel, ServerSettingsRoleMembersViewModel$ViewState$Loaded serverSettingsRoleMembersViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = serverSettingsRoleMembersViewModel;
        this.$viewState = serverSettingsRoleMembersViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r7) {
        ServerSettingsRoleMembersViewModel.access$updateViewState(this.this$0, ServerSettingsRoleMembersViewModel$ViewState$Loaded.copy$default(this.$viewState, false, null, null, 6, null));
    }
}
