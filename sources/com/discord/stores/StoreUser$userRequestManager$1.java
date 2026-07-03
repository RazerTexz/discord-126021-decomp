package com.discord.stores;

import com.discord.api.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$userRequestManager$1 extends AbstractC12240o implements Function1<User, Unit> {
    public final /* synthetic */ StoreUser this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$userRequestManager$1$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65571 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ User $user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65571(User user) {
            super(0);
            this.$user = user;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUser$userRequestManager$1.this.this$0.notifyUserUpdated.invoke(this.$user);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUser$userRequestManager$1(StoreUser storeUser) {
        super(1);
        this.this$0 = storeUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        C12238m.checkNotNullParameter(user, "user");
        this.this$0.dispatcher.schedule(new C65571(user));
    }
}
