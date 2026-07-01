package com.discord.stores;

import com.discord.models.domain.auth.ModelLoginResult;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$dispatchLogin$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelLoginResult $loginResult;
    public final /* synthetic */ StoreAuthentication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuthentication$dispatchLogin$1(StoreAuthentication storeAuthentication, ModelLoginResult modelLoginResult) {
        super(0);
        this.this$0 = storeAuthentication;
        this.$loginResult = modelLoginResult;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreAuthentication.access$getStoreStream$p(this.this$0).handleLoginResult(this.$loginResult);
    }
}
