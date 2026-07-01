package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreEntitlements.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEntitlements$fetchMyGiftEntitlements$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $entitlements;
    public final /* synthetic */ StoreEntitlements$fetchMyGiftEntitlements$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEntitlements$fetchMyGiftEntitlements$3$1(StoreEntitlements$fetchMyGiftEntitlements$3 storeEntitlements$fetchMyGiftEntitlements$3, List list) {
        super(0);
        this.this$0 = storeEntitlements$fetchMyGiftEntitlements$3;
        this.$entitlements = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.this$0.handleFetchGiftsSuccess(this.$entitlements);
    }
}
