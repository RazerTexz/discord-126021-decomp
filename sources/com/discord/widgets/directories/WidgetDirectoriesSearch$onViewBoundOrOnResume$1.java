package com.discord.widgets.directories;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$onViewBoundOrOnResume$1 extends o implements Function1<WidgetDirectoriesSearchViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetDirectoriesSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearch$onViewBoundOrOnResume$1(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        super(1);
        this.this$0 = widgetDirectoriesSearch;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState) {
        invoke2(widgetDirectoriesSearchViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState) {
        m.checkNotNullParameter(widgetDirectoriesSearchViewModel$ViewState, "it");
        WidgetDirectoriesSearch.access$configureUI(this.this$0, widgetDirectoriesSearchViewModel$ViewState);
    }
}
