package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel$deleteTier$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel$deleteTier$1(ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel, ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = serverSettingsGuildRoleSubscriptionEditTierViewModel;
        this.$viewState = serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r8) {
        ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$updateViewState(this.this$0, ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
        ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$emitEvent(this.this$0, ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteSuccess.INSTANCE);
    }
}
