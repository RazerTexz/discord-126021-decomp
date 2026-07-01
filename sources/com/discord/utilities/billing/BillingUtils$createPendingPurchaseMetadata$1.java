package com.discord.utilities.billing;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BillingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BillingUtils$createPendingPurchaseMetadata$1 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ Function0 $onSuccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingUtils$createPendingPurchaseMetadata$1(Function0 function0) {
        super(1);
        this.$onSuccess = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        this.$onSuccess.invoke();
    }
}
