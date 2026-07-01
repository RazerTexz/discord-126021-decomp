package com.discord.widgets.guild_role_subscriptions.tier.create;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateGuildRoleSubscriptionTierViewModel$1 extends o implements Function1<CreateGuildRoleSubscriptionTierViewModel$StoreState, Unit> {
    public final /* synthetic */ CreateGuildRoleSubscriptionTierViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGuildRoleSubscriptionTierViewModel$1(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel) {
        super(1);
        this.this$0 = createGuildRoleSubscriptionTierViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel$StoreState createGuildRoleSubscriptionTierViewModel$StoreState) {
        invoke2(createGuildRoleSubscriptionTierViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CreateGuildRoleSubscriptionTierViewModel$StoreState createGuildRoleSubscriptionTierViewModel$StoreState) {
        CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel = this.this$0;
        m.checkNotNullExpressionValue(createGuildRoleSubscriptionTierViewModel$StoreState, "storeState");
        CreateGuildRoleSubscriptionTierViewModel.access$handleStoreState(createGuildRoleSubscriptionTierViewModel, createGuildRoleSubscriptionTierViewModel$StoreState);
    }
}
