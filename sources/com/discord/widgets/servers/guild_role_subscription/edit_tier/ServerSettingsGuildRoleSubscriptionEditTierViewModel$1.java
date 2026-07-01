package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel$1 extends o implements Function1<ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState, Unit> {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel$1(ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel) {
        super(1);
        this.this$0 = serverSettingsGuildRoleSubscriptionEditTierViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState) {
        invoke2(serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState) {
        ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel = this.this$0;
        m.checkNotNullExpressionValue(serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState, "storeState");
        ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$handleStoreState(serverSettingsGuildRoleSubscriptionEditTierViewModel, serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState);
    }
}
