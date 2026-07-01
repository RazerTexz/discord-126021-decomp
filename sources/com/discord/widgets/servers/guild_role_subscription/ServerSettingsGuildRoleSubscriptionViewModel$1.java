package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionViewModel$1 extends o implements Function1<ServerSettingsGuildRoleSubscriptionViewModel$StoreState, Unit> {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionViewModel$1(ServerSettingsGuildRoleSubscriptionViewModel serverSettingsGuildRoleSubscriptionViewModel) {
        super(1);
        this.this$0 = serverSettingsGuildRoleSubscriptionViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionViewModel$StoreState serverSettingsGuildRoleSubscriptionViewModel$StoreState) {
        invoke2(serverSettingsGuildRoleSubscriptionViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsGuildRoleSubscriptionViewModel$StoreState serverSettingsGuildRoleSubscriptionViewModel$StoreState) {
        m.checkNotNullParameter(serverSettingsGuildRoleSubscriptionViewModel$StoreState, "storeState");
        ServerSettingsGuildRoleSubscriptionViewModel.access$handleStoreState(this.this$0, serverSettingsGuildRoleSubscriptionViewModel$StoreState);
    }
}
