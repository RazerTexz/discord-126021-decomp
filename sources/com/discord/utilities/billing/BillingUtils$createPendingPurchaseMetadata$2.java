package com.discord.utilities.billing;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BillingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BillingUtils$createPendingPurchaseMetadata$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ Function0 $onFailure;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingUtils$createPendingPurchaseMetadata$2(Function0 function0) {
        super(1);
        this.$onFailure = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        this.$onFailure.invoke();
    }
}
