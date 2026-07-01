package com.discord.widgets.guild_role_subscriptions;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeePurchaseFeedbackLoopSystemMessages$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ GuildRoleSubscriptionsFeatureFlag this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeePurchaseFeedbackLoopSystemMessages$1(GuildRoleSubscriptionsFeatureFlag guildRoleSubscriptionsFeatureFlag, Long l) {
        super(0);
        this.this$0 = guildRoleSubscriptionsFeatureFlag;
        this.$guildId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.canGuildSeePurchaseFeedbackLoopMessages(this.$guildId.longValue());
    }
}
