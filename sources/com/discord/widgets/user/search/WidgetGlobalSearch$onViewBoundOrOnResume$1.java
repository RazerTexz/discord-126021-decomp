package com.discord.widgets.user.search;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearch$onViewBoundOrOnResume$1 extends k implements Function1<WidgetGlobalSearchModel, Unit> {
    public WidgetGlobalSearch$onViewBoundOrOnResume$1(WidgetGlobalSearch widgetGlobalSearch) {
        super(1, widgetGlobalSearch, WidgetGlobalSearch.class, "configureUI", "configureUI(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalSearchModel widgetGlobalSearchModel) {
        invoke2(widgetGlobalSearchModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGlobalSearchModel widgetGlobalSearchModel) {
        m.checkNotNullParameter(widgetGlobalSearchModel, "p1");
        WidgetGlobalSearch.access$configureUI((WidgetGlobalSearch) this.receiver, widgetGlobalSearchModel);
    }
}
