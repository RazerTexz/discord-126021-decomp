package com.discord.widgets.guild_role_subscriptions.setup;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanSetupViewModel$submit$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanSetupViewModel$submit$2(GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel) {
        super(1);
        this.this$0 = guildRoleSubscriptionPlanSetupViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel = this.this$0;
        guildRoleSubscriptionPlanSetupViewModel.updateViewState2(GuildRoleSubscriptionPlanSetupViewModel$ViewState.copy$default(GuildRoleSubscriptionPlanSetupViewModel.access$requireViewState(guildRoleSubscriptionPlanSetupViewModel), 0, false, false, null, null, null, null, Opcodes.LUSHR, null));
        GuildRoleSubscriptionPlanSetupViewModel.access$emitEvent(this.this$0, new GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure(error));
    }
}
