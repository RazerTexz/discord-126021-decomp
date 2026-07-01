package com.discord.widgets.search.suggestions;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions$onViewBoundOrOnResume$1 extends o implements Function1<WidgetSearchSuggestions$Model, Unit> {
    public final /* synthetic */ WidgetSearchSuggestions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestions$onViewBoundOrOnResume$1(WidgetSearchSuggestions widgetSearchSuggestions) {
        super(1);
        this.this$0 = widgetSearchSuggestions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSearchSuggestions$Model widgetSearchSuggestions$Model) {
        invoke2(widgetSearchSuggestions$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSearchSuggestions$Model widgetSearchSuggestions$Model) {
        m.checkNotNullParameter(widgetSearchSuggestions$Model, "model");
        WidgetSearchSuggestions.access$configureUI(this.this$0, widgetSearchSuggestions$Model);
    }
}
