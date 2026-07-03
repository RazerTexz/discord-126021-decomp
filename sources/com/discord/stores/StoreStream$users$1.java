package com.discord.stores;

import com.discord.api.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$users$1 extends C12236k implements Function1<User, Unit> {
    public StoreStream$users$1(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleUserUpdated", "handleUserUpdated(Lcom/discord/api/user/User;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        C12238m.checkNotNullParameter(user, "p1");
        ((StoreStream) this.receiver).handleUserUpdated(user);
    }
}
