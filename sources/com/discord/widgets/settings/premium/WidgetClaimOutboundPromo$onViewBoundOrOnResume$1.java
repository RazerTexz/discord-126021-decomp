package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetClaimOutboundPromo$onViewBoundOrOnResume$1 extends k implements Function1<ClaimOutboundPromoViewModel$ViewState, Unit> {
    public WidgetClaimOutboundPromo$onViewBoundOrOnResume$1(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "configureUi", "configureUi(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel$ViewState claimOutboundPromoViewModel$ViewState) {
        invoke2(claimOutboundPromoViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ClaimOutboundPromoViewModel$ViewState claimOutboundPromoViewModel$ViewState) {
        m.checkNotNullParameter(claimOutboundPromoViewModel$ViewState, "p1");
        WidgetClaimOutboundPromo.access$configureUi((WidgetClaimOutboundPromo) this.receiver, claimOutboundPromoViewModel$ViewState);
    }
}
