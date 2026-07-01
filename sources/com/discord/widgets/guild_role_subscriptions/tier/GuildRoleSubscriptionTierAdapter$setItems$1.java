package com.discord.widgets.guild_role_subscriptions.tier;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierAdapter$setItems$1 extends o implements Function1<List<? extends GuildRoleSubscriptionTierAdapterItem>, Unit> {
    public final /* synthetic */ GuildRoleSubscriptionTierAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierAdapter$setItems$1(GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter) {
        super(1);
        this.this$0 = guildRoleSubscriptionTierAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildRoleSubscriptionTierAdapterItem> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends GuildRoleSubscriptionTierAdapterItem> list) {
        m.checkNotNullParameter(list, "items");
        GuildRoleSubscriptionTierAdapter.access$setItems$p(this.this$0, list);
    }
}
