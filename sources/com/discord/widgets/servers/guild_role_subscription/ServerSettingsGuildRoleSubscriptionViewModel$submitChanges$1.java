package com.discord.widgets.servers.guild_role_subscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$1 extends o implements Function1<GuildRoleSubscriptionGroupListing, Unit> {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$1(ServerSettingsGuildRoleSubscriptionViewModel serverSettingsGuildRoleSubscriptionViewModel, ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = serverSettingsGuildRoleSubscriptionViewModel;
        this.$viewState = serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        invoke2(guildRoleSubscriptionGroupListing);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        m.checkNotNullParameter(guildRoleSubscriptionGroupListing, "it");
        ServerSettingsGuildRoleSubscriptionViewModel.access$updateViewState(this.this$0, ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.copy$default(this.$viewState, false, false, 0L, 4, null));
        ServerSettingsGuildRoleSubscriptionViewModel.access$emitEvent(this.this$0, ServerSettingsGuildRoleSubscriptionViewModel$Event$SubmitSuccess.INSTANCE);
    }
}
