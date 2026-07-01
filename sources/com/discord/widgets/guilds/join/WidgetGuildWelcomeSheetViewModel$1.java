package com.discord.widgets.guilds.join;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetViewModel$1 extends o implements Function1<WidgetGuildWelcomeSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetGuildWelcomeSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheetViewModel$1(WidgetGuildWelcomeSheetViewModel widgetGuildWelcomeSheetViewModel) {
        super(1);
        this.this$0 = widgetGuildWelcomeSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildWelcomeSheetViewModel$StoreState widgetGuildWelcomeSheetViewModel$StoreState) {
        invoke2(widgetGuildWelcomeSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildWelcomeSheetViewModel$StoreState widgetGuildWelcomeSheetViewModel$StoreState) {
        m.checkNotNullParameter(widgetGuildWelcomeSheetViewModel$StoreState, "storeState");
        WidgetGuildWelcomeSheetViewModel.access$handleStoreState(this.this$0, widgetGuildWelcomeSheetViewModel$StoreState);
    }
}
