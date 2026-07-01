package com.discord.stores;

import com.discord.models.domain.ModelEntitlement;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreEntitlements.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEntitlements$fetchMyGiftEntitlements$3 extends o implements Function1<List<? extends ModelEntitlement>, Unit> {
    public final /* synthetic */ StoreEntitlements this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEntitlements$fetchMyGiftEntitlements$3(StoreEntitlements storeEntitlements) {
        super(1);
        this.this$0 = storeEntitlements;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEntitlement> list) {
        invoke2((List<ModelEntitlement>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelEntitlement> list) {
        m.checkNotNullParameter(list, "entitlements");
        StoreEntitlements.access$getDispatcher$p(this.this$0).schedule(new StoreEntitlements$fetchMyGiftEntitlements$3$1(this, list));
    }
}
