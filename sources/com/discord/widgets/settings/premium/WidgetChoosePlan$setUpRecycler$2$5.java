package com.discord.widgets.settings.premium;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan$setUpRecycler$2$5 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetChoosePlan$setUpRecycler$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlan$setUpRecycler$2$5(WidgetChoosePlan$setUpRecycler$2 widgetChoosePlan$setUpRecycler$2) {
        super(0);
        this.this$0 = widgetChoosePlan$setUpRecycler$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AnalyticsTracker.INSTANCE.upgradePremiumYearlyClosed(this.this$0.$locationTrait);
    }
}
