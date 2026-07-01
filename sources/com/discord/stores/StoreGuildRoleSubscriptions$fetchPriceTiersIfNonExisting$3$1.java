package com.discord.stores;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $it;
    public final /* synthetic */ StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3$1(StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3 storeGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3, Error error) {
        super(0);
        this.this$0 = storeGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3;
        this.$it = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.this$0.this$0;
        Error$Response response = this.$it.getResponse();
        m.checkNotNullExpressionValue(response, "it.response");
        StoreGuildRoleSubscriptions.access$setPriceTierState$p(storeGuildRoleSubscriptions, new StoreGuildRoleSubscriptions$PriceTierState$Failed(response.getMessage()));
        this.this$0.this$0.markChanged();
    }
}
