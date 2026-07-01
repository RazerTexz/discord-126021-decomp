package com.discord.stores;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;
    public final /* synthetic */ List $guildRoleSubscriptionTrials;
    public final /* synthetic */ StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2$1(StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2 storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List list) {
        super(0);
        this.this$0 = storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2;
        this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
        this.$guildRoleSubscriptionTrials = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2 storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2 = this.this$0;
        StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionGroupFetch(storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2.this$0, storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2.$guildId, this.$guildRoleSubscriptionGroupListing);
        StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2 storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3 = this.this$0;
        StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionFreeTrialListFetch(storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3.this$0, storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3.$guildId, this.$guildRoleSubscriptionTrials);
    }
}
