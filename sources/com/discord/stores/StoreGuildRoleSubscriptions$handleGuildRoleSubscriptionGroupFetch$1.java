package com.discord.stores;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupFetch$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;
    public final /* synthetic */ StoreGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupFetch$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, long j) {
        super(0);
        this.this$0 = storeGuildRoleSubscriptions;
        this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$guildRoleSubscriptionGroupListing == null) {
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(this.this$0).put(Long.valueOf(this.$guildId), new StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded(this.$guildRoleSubscriptionGroupListing));
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(this.this$0).remove(Long.valueOf(this.$guildId));
        } else {
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(this.this$0).put(Long.valueOf(this.$guildId), new StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded(GuildRoleSubscriptionGroupListing.a(this.$guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, null, false, Opcodes.ATHROW)));
            List<Long> listI = this.$guildRoleSubscriptionGroupListing.i();
            if (listI == null || listI.isEmpty()) {
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(this.this$0).remove(Long.valueOf(this.$guildId));
            } else {
                Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(this.this$0).get(Long.valueOf(this.$guildId));
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                List<GuildRoleSubscriptionTierListing> listH = this.$guildRoleSubscriptionGroupListing.h();
                if (listH != null) {
                    for (GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing : listH) {
                        linkedHashMap.put(Long.valueOf(guildRoleSubscriptionTierListing.getId()), guildRoleSubscriptionTierListing);
                    }
                }
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(this.this$0).put(Long.valueOf(this.$guildId), linkedHashMap);
            }
        }
        this.this$0.markChanged();
    }
}
