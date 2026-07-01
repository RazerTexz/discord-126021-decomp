package com.discord.widgets.guilds.list;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$onViewBound$1 extends o implements Function0<Integer> {
    public final /* synthetic */ WidgetGuildsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsList$onViewBound$1(WidgetGuildsList widgetGuildsList) {
        super(0);
        this.this$0 = widgetGuildsList;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return WidgetGuildsList.access$getAdapter$p(this.this$0).getPageSize();
    }
}
