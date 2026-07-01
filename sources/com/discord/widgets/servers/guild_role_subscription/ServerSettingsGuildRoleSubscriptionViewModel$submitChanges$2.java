package com.discord.widgets.servers.guild_role_subscription;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$2(ServerSettingsGuildRoleSubscriptionViewModel serverSettingsGuildRoleSubscriptionViewModel, ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = serverSettingsGuildRoleSubscriptionViewModel;
        this.$viewState = serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        ServerSettingsGuildRoleSubscriptionViewModel.access$updateViewState(this.this$0, ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.copy$default(this.$viewState, false, false, 0L, 5, null));
        ServerSettingsGuildRoleSubscriptionViewModel.access$emitEvent(this.this$0, new ServerSettingsGuildRoleSubscriptionViewModel$Event$SubmitFailure(error));
    }
}
