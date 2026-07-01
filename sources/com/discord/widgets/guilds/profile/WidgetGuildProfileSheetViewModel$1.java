package com.discord.widgets.guilds.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel$1 extends o implements Function1<WidgetGuildProfileSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetGuildProfileSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheetViewModel$1(WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModel) {
        super(1);
        this.this$0 = widgetGuildProfileSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildProfileSheetViewModel$StoreState widgetGuildProfileSheetViewModel$StoreState) {
        invoke2(widgetGuildProfileSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildProfileSheetViewModel$StoreState widgetGuildProfileSheetViewModel$StoreState) {
        m.checkNotNullParameter(widgetGuildProfileSheetViewModel$StoreState, "storeState");
        WidgetGuildProfileSheetViewModel.access$handleStoreState(this.this$0, widgetGuildProfileSheetViewModel$StoreState);
    }
}
