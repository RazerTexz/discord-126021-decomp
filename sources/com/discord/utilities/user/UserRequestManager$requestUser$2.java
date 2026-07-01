package com.discord.utilities.user;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserRequestManager$requestUser$2 extends o implements Function0<Unit> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ UserRequestManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserRequestManager$requestUser$2(UserRequestManager userRequestManager, long j) {
        super(0);
        this.this$0 = userRequestManager;
        this.$userId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        UserRequestManager.access$onRequestEnded(this.this$0, this.$userId);
    }
}
