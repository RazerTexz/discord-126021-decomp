package com.discord.widgets.guild_role_subscriptions.tier.create;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionReviewViewModel$1 extends o implements Function1<GuildRoleSubscriptionReviewViewModel$StoreState, Unit> {
    public final /* synthetic */ GuildRoleSubscriptionReviewViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionReviewViewModel$1(GuildRoleSubscriptionReviewViewModel guildRoleSubscriptionReviewViewModel) {
        super(1);
        this.this$0 = guildRoleSubscriptionReviewViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionReviewViewModel$StoreState guildRoleSubscriptionReviewViewModel$StoreState) {
        invoke2(guildRoleSubscriptionReviewViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionReviewViewModel$StoreState guildRoleSubscriptionReviewViewModel$StoreState) {
        GuildRoleSubscriptionReviewViewModel guildRoleSubscriptionReviewViewModel = this.this$0;
        m.checkNotNullExpressionValue(guildRoleSubscriptionReviewViewModel$StoreState, "storeState");
        GuildRoleSubscriptionReviewViewModel.access$handleStoreState(guildRoleSubscriptionReviewViewModel, guildRoleSubscriptionReviewViewModel$StoreState);
    }
}
