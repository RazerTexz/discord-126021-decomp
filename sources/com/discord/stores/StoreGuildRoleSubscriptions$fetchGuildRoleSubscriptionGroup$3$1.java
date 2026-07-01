package com.discord.stores;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3$1(StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3 storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3, Error error) {
        super(0);
        this.this$0 = storeGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map mapAccess$getGuildRoleSubscriptionGroups$p = StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(this.this$0.this$0);
        Long lValueOf = Long.valueOf(this.this$0.$guildId);
        Error$Response response = this.$error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        mapAccess$getGuildRoleSubscriptionGroups$p.put(lValueOf, new StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Failed(response.getMessage()));
        this.this$0.this$0.markChanged();
    }
}
