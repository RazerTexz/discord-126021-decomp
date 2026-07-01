package com.discord.widgets.guilds.list;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$onResume$3 extends o implements Function1<WidgetGuildsList$AddGuildHint, Unit> {
    public final /* synthetic */ WidgetGuildsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsList$onResume$3(WidgetGuildsList widgetGuildsList) {
        super(1);
        this.this$0 = widgetGuildsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsList$AddGuildHint widgetGuildsList$AddGuildHint) {
        invoke2(widgetGuildsList$AddGuildHint);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildsList$AddGuildHint widgetGuildsList$AddGuildHint) {
        m.checkNotNullParameter(widgetGuildsList$AddGuildHint, "it");
        WidgetGuildsList.access$configureAddGuildHint(this.this$0, widgetGuildsList$AddGuildHint);
    }
}
