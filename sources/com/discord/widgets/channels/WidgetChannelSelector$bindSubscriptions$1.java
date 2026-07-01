package com.discord.widgets.channels;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$bindSubscriptions$1 extends o implements Function1<List<? extends WidgetChannelSelector$Model$Item>, Unit> {
    public final /* synthetic */ WidgetChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSelector$bindSubscriptions$1(WidgetChannelSelector widgetChannelSelector) {
        super(1);
        this.this$0 = widgetChannelSelector;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetChannelSelector$Model$Item> list) {
        invoke2((List<WidgetChannelSelector$Model$Item>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<WidgetChannelSelector$Model$Item> list) {
        m.checkNotNullParameter(list, "it");
        WidgetChannelSelector.access$getAdapter$p(this.this$0).setData(list);
    }
}
