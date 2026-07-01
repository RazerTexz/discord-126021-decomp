package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateGuildRoleSubscriptionTierViewModel$submit$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ CreateGuildRoleSubscriptionTierViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGuildRoleSubscriptionTierViewModel$submit$2(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel) {
        super(1);
        this.this$0 = createGuildRoleSubscriptionTierViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel = this.this$0;
        createGuildRoleSubscriptionTierViewModel.updateViewState2(CreateGuildRoleSubscriptionTierViewModel$ViewState.copy$default(CreateGuildRoleSubscriptionTierViewModel.access$requireViewState(createGuildRoleSubscriptionTierViewModel), 0, false, false, null, 11, null));
        CreateGuildRoleSubscriptionTierViewModel.access$emitEvent(this.this$0, new CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure(error));
    }
}
