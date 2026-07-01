package com.discord.stores;

import com.discord.models.authentication.AuthState;
import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$deferredInit$1$2 extends k implements Function1<AuthState, Unit> {
    public StoreStream$deferredInit$1$2(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleAuthState", "handleAuthState(Lcom/discord/models/authentication/AuthState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
        invoke2(authState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AuthState authState) {
        StoreStream.access$handleAuthState((StoreStream) this.receiver, authState);
    }
}
