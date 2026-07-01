package com.discord.utilities.gifting;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GiftingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftingUtils$buyGift$4 extends o implements Function0<Unit> {
    public final /* synthetic */ Function0 $dismissWarningCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftingUtils$buyGift$4(Function0 function0) {
        super(0);
        this.$dismissWarningCallback = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Function0 function0 = this.$dismissWarningCallback;
        if (function0 != null) {
        }
    }
}
