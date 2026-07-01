package com.discord.widgets.guilds.list;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$onResume$1 extends o implements Function1<WidgetGuildsListViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsList$onResume$1(WidgetGuildsList widgetGuildsList) {
        super(1);
        this.this$0 = widgetGuildsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsListViewModel$ViewState widgetGuildsListViewModel$ViewState) {
        invoke2(widgetGuildsListViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildsListViewModel$ViewState widgetGuildsListViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildsListViewModel$ViewState, "it");
        WidgetGuildsList.access$configureUI(this.this$0, widgetGuildsListViewModel$ViewState);
    }
}
