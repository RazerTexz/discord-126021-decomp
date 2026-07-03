package com.discord.widgets.settings.premium;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo$viewModel$2 extends AbstractC12240o implements Function0<ClaimOutboundPromoViewModel> {
    public final /* synthetic */ WidgetClaimOutboundPromo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetClaimOutboundPromo$viewModel$2(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        super(0);
        this.this$0 = widgetClaimOutboundPromo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ClaimOutboundPromoViewModel invoke() {
        return new ClaimOutboundPromoViewModel(this.this$0.getClaimStatus(), null, 2, null);
    }
}
