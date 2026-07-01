package com.discord.widgets.search;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$onViewBoundOrOnResume$1 extends o implements Function1<WidgetSearch$Model, Unit> {
    public final /* synthetic */ WidgetSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearch$onViewBoundOrOnResume$1(WidgetSearch widgetSearch) {
        super(1);
        this.this$0 = widgetSearch;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSearch$Model widgetSearch$Model) {
        invoke2(widgetSearch$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSearch$Model widgetSearch$Model) {
        WidgetSearch.access$configureUI(this.this$0, widgetSearch$Model);
    }
}
