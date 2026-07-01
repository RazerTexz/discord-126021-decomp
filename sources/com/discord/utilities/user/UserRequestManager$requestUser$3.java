package com.discord.utilities.user;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: UserRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserRequestManager$requestUser$3 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ UserRequestManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserRequestManager$requestUser$3(UserRequestManager userRequestManager, long j) {
        super(1);
        this.this$0 = userRequestManager;
        this.$userId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, "it");
        UserRequestManager.access$onRequestStarted(this.this$0, this.$userId, subscription);
    }
}
