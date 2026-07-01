package com.discord.stores;

import com.discord.api.user.User;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$userRequestManager$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ User $user;
    public final /* synthetic */ StoreUser$userRequestManager$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUser$userRequestManager$1$1(StoreUser$userRequestManager$1 storeUser$userRequestManager$1, User user) {
        super(0);
        this.this$0 = storeUser$userRequestManager$1;
        this.$user = user;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUser.access$getNotifyUserUpdated$p(this.this$0.this$0).invoke(this.$user);
    }
}
