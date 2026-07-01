package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierListViewModel$1 extends o implements Function1<ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState, Unit> {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionTierListViewModel$1(ServerSettingsGuildRoleSubscriptionTierListViewModel serverSettingsGuildRoleSubscriptionTierListViewModel) {
        super(1);
        this.this$0 = serverSettingsGuildRoleSubscriptionTierListViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState) {
        invoke2(serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState) {
        m.checkNotNullParameter(serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState, "storeState");
        ServerSettingsGuildRoleSubscriptionTierListViewModel.access$handleStoreState(this.this$0, serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState);
    }
}
