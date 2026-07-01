package com.discord.utilities.auth;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GoogleSmartLockRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockRepo$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ GoogleSmartLockRepo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleSmartLockRepo$1(GoogleSmartLockRepo googleSmartLockRepo) {
        super(1);
        this.this$0 = googleSmartLockRepo;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        if (z2) {
            return;
        }
        this.this$0.setDisableAutoLogin(true);
    }
}
