package com.discord.widgets.settings.account.mfa;

import com.discord.utilities.dimmer.DimmerView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFASteps$onViewBoundOrOnResume$1 extends o implements Function1<WidgetEnableMFAViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetEnableMFASteps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableMFASteps$onViewBoundOrOnResume$1(WidgetEnableMFASteps widgetEnableMFASteps) {
        super(1);
        this.this$0 = widgetEnableMFASteps;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetEnableMFAViewModel$ViewState widgetEnableMFAViewModel$ViewState) {
        invoke2(widgetEnableMFAViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetEnableMFAViewModel$ViewState widgetEnableMFAViewModel$ViewState) {
        m.checkNotNullParameter(widgetEnableMFAViewModel$ViewState, "it");
        DimmerView.setDimmed$default(WidgetEnableMFASteps.access$getBinding$p(this.this$0).f2380b, widgetEnableMFAViewModel$ViewState.isLoading(), false, 2, null);
        Integer screenIndex = widgetEnableMFAViewModel$ViewState.getScreenIndex();
        if (screenIndex != null) {
            WidgetEnableMFASteps.access$getBinding$p(this.this$0).c.b(screenIndex.intValue());
        }
    }
}
