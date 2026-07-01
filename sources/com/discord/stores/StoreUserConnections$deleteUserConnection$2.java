package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserConnections$deleteUserConnection$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ StoreUserConnections this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserConnections$deleteUserConnection$2(StoreUserConnections storeUserConnections) {
        super(1);
        this.this$0 = storeUserConnections;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
        this.this$0.fetchConnectedAccounts();
    }
}
