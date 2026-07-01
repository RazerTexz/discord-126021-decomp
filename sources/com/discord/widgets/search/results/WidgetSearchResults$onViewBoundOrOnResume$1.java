package com.discord.widgets.search.results;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchResults$onViewBoundOrOnResume$1 extends k implements Function1<WidgetSearchResults$Model, Unit> {
    public WidgetSearchResults$onViewBoundOrOnResume$1(WidgetSearchResults widgetSearchResults) {
        super(1, widgetSearchResults, WidgetSearchResults.class, "configureUI", "configureUI(Lcom/discord/widgets/search/results/WidgetSearchResults$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSearchResults$Model widgetSearchResults$Model) {
        invoke2(widgetSearchResults$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSearchResults$Model widgetSearchResults$Model) {
        m.checkNotNullParameter(widgetSearchResults$Model, "p1");
        WidgetSearchResults.access$configureUI((WidgetSearchResults) this.receiver, widgetSearchResults$Model);
    }
}
