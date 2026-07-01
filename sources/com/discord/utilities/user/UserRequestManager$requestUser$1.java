package com.discord.utilities.user;

import com.discord.api.user.User;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserRequestManager$requestUser$1 extends o implements Function1<User, Unit> {
    public final /* synthetic */ UserRequestManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserRequestManager$requestUser$1(UserRequestManager userRequestManager) {
        super(1);
        this.this$0 = userRequestManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        if (user != null) {
            UserRequestManager.access$getOnFlush$p(this.this$0).invoke(user);
        }
    }
}
