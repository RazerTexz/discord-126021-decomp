package com.discord.widgets.directories;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryCategory$onViewBoundOrOnResume$2 extends o implements Function1<WidgetDirectoriesViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetDirectoryCategory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryCategory$onViewBoundOrOnResume$2(WidgetDirectoryCategory widgetDirectoryCategory) {
        super(1);
        this.this$0 = widgetDirectoryCategory;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        invoke2(widgetDirectoriesViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        WidgetDirectoryCategory widgetDirectoryCategory = this.this$0;
        m.checkNotNullExpressionValue(widgetDirectoriesViewModel$ViewState, "it");
        WidgetDirectoryCategory.access$configureUi(widgetDirectoryCategory, widgetDirectoriesViewModel$ViewState);
    }
}
