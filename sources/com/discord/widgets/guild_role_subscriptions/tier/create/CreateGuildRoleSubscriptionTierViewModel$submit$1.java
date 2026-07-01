package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateGuildRoleSubscriptionTierViewModel$submit$1 extends o implements Function1<GuildRoleSubscriptionTierListing, Unit> {
    public final /* synthetic */ CreateGuildRoleSubscriptionTierViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGuildRoleSubscriptionTierViewModel$submit$1(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel) {
        super(1);
        this.this$0 = createGuildRoleSubscriptionTierViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        invoke2(guildRoleSubscriptionTierListing);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        m.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
        CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel = this.this$0;
        createGuildRoleSubscriptionTierViewModel.updateViewState2(CreateGuildRoleSubscriptionTierViewModel$ViewState.copy$default(CreateGuildRoleSubscriptionTierViewModel.access$requireViewState(createGuildRoleSubscriptionTierViewModel), 0, false, false, null, 11, null));
        CreateGuildRoleSubscriptionTierViewModel.access$emitEvent(this.this$0, CreateGuildRoleSubscriptionTierViewModel$Event$SubmitSuccess.INSTANCE);
    }
}
