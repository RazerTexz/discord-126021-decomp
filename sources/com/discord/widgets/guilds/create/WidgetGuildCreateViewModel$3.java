package com.discord.widgets.guilds.create;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreateViewModel$3 extends o implements Function1<WidgetGuildCreateViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetGuildCreateViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreateViewModel$3(WidgetGuildCreateViewModel widgetGuildCreateViewModel) {
        super(1);
        this.this$0 = widgetGuildCreateViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel$StoreState widgetGuildCreateViewModel$StoreState) {
        invoke2(widgetGuildCreateViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildCreateViewModel$StoreState widgetGuildCreateViewModel$StoreState) {
        m.checkNotNullParameter(widgetGuildCreateViewModel$StoreState, "it");
        this.this$0.handleStoreState(widgetGuildCreateViewModel$StoreState);
    }
}
