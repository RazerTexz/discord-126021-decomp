package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2 extends o implements Function1<List<? extends Integer>, Unit> {
    public final /* synthetic */ StoreGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        super(1);
        this.this$0 = storeGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
        invoke2((List<Integer>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Integer> list) {
        m.checkNotNullParameter(list, "it");
        StoreGuildRoleSubscriptions.access$getDispatcher$p(this.this$0).schedule(new StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2$1(this, list));
    }
}
