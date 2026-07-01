package com.discord.stores;

import com.discord.api.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$userRequestManager$1 extends o implements Function1<User, Unit> {
    public final /* synthetic */ StoreUser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUser$userRequestManager$1(StoreUser storeUser) {
        super(1);
        this.this$0 = storeUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        m.checkNotNullParameter(user, "user");
        StoreUser.access$getDispatcher$p(this.this$0).schedule(new StoreUser$userRequestManager$1$1(this, user));
    }
}
