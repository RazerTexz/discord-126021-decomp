package com.discord.widgets.voice.fullscreen;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheet$onResume$1 extends o implements Function1<WidgetGuildCallOnboardingSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildCallOnboardingSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheet$onResume$1(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet) {
        super(1);
        this.this$0 = widgetGuildCallOnboardingSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCallOnboardingSheetViewModel$ViewState widgetGuildCallOnboardingSheetViewModel$ViewState) {
        invoke2(widgetGuildCallOnboardingSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildCallOnboardingSheetViewModel$ViewState widgetGuildCallOnboardingSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildCallOnboardingSheetViewModel$ViewState, "viewState");
        WidgetGuildCallOnboardingSheet.access$configureUI(this.this$0, widgetGuildCallOnboardingSheetViewModel$ViewState);
    }
}
