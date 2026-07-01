package com.discord.widgets.guilds.list;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$onResume$2 extends o implements Function1<WidgetGuildsListViewModel$Event, Unit> {
    public final /* synthetic */ WidgetGuildsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsList$onResume$2(WidgetGuildsList widgetGuildsList) {
        super(1);
        this.this$0 = widgetGuildsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsListViewModel$Event widgetGuildsListViewModel$Event) {
        invoke2(widgetGuildsListViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildsListViewModel$Event widgetGuildsListViewModel$Event) {
        m.checkNotNullParameter(widgetGuildsListViewModel$Event, "it");
        WidgetGuildsList.access$handleEvent(this.this$0, widgetGuildsListViewModel$Event);
    }
}
