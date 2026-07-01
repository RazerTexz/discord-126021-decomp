package com.discord.widgets.channels.list;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$12 extends o implements Function0<Integer> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$12(WidgetChannelsList widgetChannelsList) {
        super(0);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return WidgetChannelsList.access$getAdapter$p(this.this$0).getPageSize();
    }
}
