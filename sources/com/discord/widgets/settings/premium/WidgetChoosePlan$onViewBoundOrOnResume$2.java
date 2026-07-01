package com.discord.widgets.settings.premium;

import d0.z.d.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChoosePlan$onViewBoundOrOnResume$2 extends a implements Function1<ChoosePlanViewModel$ViewState, Unit> {
    public WidgetChoosePlan$onViewBoundOrOnResume$2(WidgetChoosePlan widgetChoosePlan) {
        super(1, widgetChoosePlan, WidgetChoosePlan.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$ViewState;)Lkotlin/Unit;", 8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChoosePlanViewModel$ViewState choosePlanViewModel$ViewState) {
        invoke2(choosePlanViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChoosePlanViewModel$ViewState choosePlanViewModel$ViewState) {
        m.checkNotNullParameter(choosePlanViewModel$ViewState, "p1");
        WidgetChoosePlan.access$configureUI((WidgetChoosePlan) this.receiver, choosePlanViewModel$ViewState);
    }
}
