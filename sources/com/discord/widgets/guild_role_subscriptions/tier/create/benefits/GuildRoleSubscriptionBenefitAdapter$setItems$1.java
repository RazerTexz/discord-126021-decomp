package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitAdapter$setItems$1 extends o implements Function1<List<? extends GuildRoleSubscriptionBenefitAdapterItem>, Unit> {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitAdapter$setItems$1(GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter) {
        super(1);
        this.this$0 = guildRoleSubscriptionBenefitAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildRoleSubscriptionBenefitAdapterItem> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends GuildRoleSubscriptionBenefitAdapterItem> list) {
        m.checkNotNullParameter(list, "itemsToDispatch");
        GuildRoleSubscriptionBenefitAdapter.access$setItems$p(this.this$0, list);
    }
}
