package com.discord.widgets.guilds;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector$bindSubscriptions$1 extends o implements Function1<List<? extends WidgetGuildSelector$Item>, Unit> {
    public final /* synthetic */ WidgetGuildSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildSelector$bindSubscriptions$1(WidgetGuildSelector widgetGuildSelector) {
        super(1);
        this.this$0 = widgetGuildSelector;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetGuildSelector$Item> list) {
        invoke2((List<WidgetGuildSelector$Item>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<WidgetGuildSelector$Item> list) {
        m.checkNotNullParameter(list, "it");
        WidgetGuildSelector.access$getAdapter$p(this.this$0).setData(list);
    }
}
