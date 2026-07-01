package com.discord.stores;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $guildRoleSubscriptionFreeTrials;
    public final /* synthetic */ List $guildRoleSubscriptionGroupListings;
    public final /* synthetic */ StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2$1(StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2 storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2, List list, List list2) {
        super(0);
        this.this$0 = storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2;
        this.$guildRoleSubscriptionGroupListings = list;
        this.$guildRoleSubscriptionFreeTrials = list2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2 storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2 = this.this$0;
        StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2.this$0;
        long j = storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2.$guildId;
        List list = this.$guildRoleSubscriptionGroupListings;
        m.checkNotNullExpressionValue(list, "guildRoleSubscriptionGroupListings");
        StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionGroupFetch(storeGuildRoleSubscriptions, j, (GuildRoleSubscriptionGroupListing) u.getOrNull(list, 0));
        StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2 storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3 = this.this$0;
        StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionFreeTrialListFetch(storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3.this$0, storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3.$guildId, this.$guildRoleSubscriptionFreeTrials);
    }
}
