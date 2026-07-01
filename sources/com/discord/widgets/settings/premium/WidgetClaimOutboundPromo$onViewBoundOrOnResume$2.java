package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetClaimOutboundPromo$onViewBoundOrOnResume$2 extends k implements Function1<ClaimOutboundPromoViewModel$Event, Unit> {
    public WidgetClaimOutboundPromo$onViewBoundOrOnResume$2(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel$Event claimOutboundPromoViewModel$Event) {
        invoke2(claimOutboundPromoViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ClaimOutboundPromoViewModel$Event claimOutboundPromoViewModel$Event) {
        m.checkNotNullParameter(claimOutboundPromoViewModel$Event, "p1");
        WidgetClaimOutboundPromo.access$handleEvent((WidgetClaimOutboundPromo) this.receiver, claimOutboundPromoViewModel$Event);
    }
}
