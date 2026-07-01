package com.discord.stores;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionFreeTrialListFetch$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ List $guildRoleSubscriptionFreeTrialList;
    public final /* synthetic */ StoreGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionFreeTrialListFetch$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, List list, long j) {
        super(0);
        this.this$0 = storeGuildRoleSubscriptions;
        this.$guildRoleSubscriptionFreeTrialList = list;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List list = this.$guildRoleSubscriptionFreeTrialList;
        if (list == null) {
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(this.this$0).remove(Long.valueOf(this.$guildId));
            this.this$0.markChanged();
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Long.valueOf(((GuildRoleSubscriptionTierFreeTrial) obj).getId()), obj);
        }
        StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(this.this$0).put(Long.valueOf(this.$guildId), h0.toMutableMap(linkedHashMap));
        this.this$0.markChanged();
    }
}
