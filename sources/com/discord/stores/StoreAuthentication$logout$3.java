package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$logout$3 extends o implements Function1<String, Unit> {
    public final /* synthetic */ StoreAuthentication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuthentication$logout$3(StoreAuthentication storeAuthentication) {
        super(1);
        this.this$0 = storeAuthentication;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        StoreStream.Companion.getNux().clearNux();
        StoreAuthentication.access$publishAuthState(this.this$0, null);
    }
}
