package com.discord.stores;

import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreUser$userRequestManager$1, reason: use source file name */
/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser4 extends Lambda implements Function1<User, Unit> {
    public final /* synthetic */ StoreUser this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$userRequestManager$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ User $user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(User user) {
            super(0);
            this.$user = user;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUser4.this.this$0.notifyUserUpdated.invoke(this.$user);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUser4(StoreUser storeUser) {
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
        Intrinsics3.checkNotNullParameter(user, "user");
        this.this$0.dispatcher.schedule(new AnonymousClass1(user));
    }
}
