package com.discord.widgets.guild_role_subscriptions.setup;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanSetupViewModel$submit$1 extends o implements Function1<GuildRoleSubscriptionTierListing, Unit> {
    public final /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanSetupViewModel$submit$1(GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel) {
        super(1);
        this.this$0 = guildRoleSubscriptionPlanSetupViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        invoke2(guildRoleSubscriptionTierListing);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        m.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
        GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel = this.this$0;
        guildRoleSubscriptionPlanSetupViewModel.updateViewState2(GuildRoleSubscriptionPlanSetupViewModel$ViewState.copy$default(GuildRoleSubscriptionPlanSetupViewModel.access$requireViewState(guildRoleSubscriptionPlanSetupViewModel), 0, false, false, null, null, null, null, Opcodes.LUSHR, null));
        GuildRoleSubscriptionPlanSetupViewModel.access$emitEvent(this.this$0, GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitSuccess.INSTANCE);
    }
}
