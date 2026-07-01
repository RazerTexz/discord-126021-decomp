package com.discord.widgets.settings.premium;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ClaimOutboundPromoViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClaimOutboundPromoViewModel$claimPromo$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ ClaimOutboundPromoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimOutboundPromoViewModel$claimPromo$2(ClaimOutboundPromoViewModel claimOutboundPromoViewModel) {
        super(1);
        this.this$0 = claimOutboundPromoViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        ClaimOutboundPromoViewModel.access$updateViewState(this.this$0, ClaimOutboundPromoViewModel$ViewState$ClaimFailed.INSTANCE);
    }
}
