package com.discord.widgets.guilds.create;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreate$onResume$1 extends o implements Function1<WidgetGuildCreateViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildCreate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreate$onResume$1(WidgetGuildCreate widgetGuildCreate) {
        super(1);
        this.this$0 = widgetGuildCreate;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel$ViewState widgetGuildCreateViewModel$ViewState) {
        invoke2(widgetGuildCreateViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildCreateViewModel$ViewState widgetGuildCreateViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildCreateViewModel$ViewState, "it");
        this.this$0.configureUI(widgetGuildCreateViewModel$ViewState);
    }
}
