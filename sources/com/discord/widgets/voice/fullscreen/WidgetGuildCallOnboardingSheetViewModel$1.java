package com.discord.widgets.voice.fullscreen;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGuildCallOnboardingSheetViewModel$1 extends k implements Function1<WidgetGuildCallOnboardingSheetViewModel$StoreState, Unit> {
    public WidgetGuildCallOnboardingSheetViewModel$1(WidgetGuildCallOnboardingSheetViewModel widgetGuildCallOnboardingSheetViewModel) {
        super(1, widgetGuildCallOnboardingSheetViewModel, WidgetGuildCallOnboardingSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCallOnboardingSheetViewModel$StoreState widgetGuildCallOnboardingSheetViewModel$StoreState) {
        invoke2(widgetGuildCallOnboardingSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildCallOnboardingSheetViewModel$StoreState widgetGuildCallOnboardingSheetViewModel$StoreState) {
        m.checkNotNullParameter(widgetGuildCallOnboardingSheetViewModel$StoreState, "p1");
        WidgetGuildCallOnboardingSheetViewModel.access$handleStoreState((WidgetGuildCallOnboardingSheetViewModel) this.receiver, widgetGuildCallOnboardingSheetViewModel$StoreState);
    }
}
