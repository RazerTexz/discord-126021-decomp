package com.discord.stores;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingUpdate$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;
    public final /* synthetic */ StoreGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingUpdate$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        super(0);
        this.this$0 = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(this.this$0).get(Long.valueOf(this.$guildId));
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
        }
        linkedHashMap.put(Long.valueOf(this.$guildRoleSubscriptionTierListing.getId()), this.$guildRoleSubscriptionTierListing);
        StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(this.this$0).put(Long.valueOf(this.$guildId), linkedHashMap);
        this.this$0.markChanged();
    }
}
