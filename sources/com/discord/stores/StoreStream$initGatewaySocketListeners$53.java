package com.discord.stores;

import com.discord.api.requiredaction.UserRequiredActionUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$53 extends k implements Function1<UserRequiredActionUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$53(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleRequiredActionUpdate", "handleRequiredActionUpdate(Lcom/discord/api/requiredaction/UserRequiredActionUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserRequiredActionUpdate userRequiredActionUpdate) {
        invoke2(userRequiredActionUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserRequiredActionUpdate userRequiredActionUpdate) {
        m.checkNotNullParameter(userRequiredActionUpdate, "p1");
        StoreStream.access$handleRequiredActionUpdate((StoreStream) this.receiver, userRequiredActionUpdate);
    }
}
