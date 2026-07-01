package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        super(0);
        this.this$0 = storeGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildRoleSubscriptions.access$setPriceTierState$p(this.this$0, StoreGuildRoleSubscriptions$PriceTierState$Loading.INSTANCE);
        this.this$0.markChanged();
    }
}
