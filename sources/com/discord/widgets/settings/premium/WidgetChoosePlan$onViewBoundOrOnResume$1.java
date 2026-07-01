package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChoosePlan$onViewBoundOrOnResume$1 extends k implements Function1<ChoosePlanViewModel$Event, Unit> {
    public WidgetChoosePlan$onViewBoundOrOnResume$1(WidgetChoosePlan widgetChoosePlan) {
        super(1, widgetChoosePlan, WidgetChoosePlan.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChoosePlanViewModel$Event choosePlanViewModel$Event) {
        invoke2(choosePlanViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChoosePlanViewModel$Event choosePlanViewModel$Event) {
        m.checkNotNullParameter(choosePlanViewModel$Event, "p1");
        WidgetChoosePlan.access$handleEvent((WidgetChoosePlan) this.receiver, choosePlanViewModel$Event);
    }
}
