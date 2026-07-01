package com.discord.widgets.servers;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerDeleteDialog$onViewBoundOrOnResume$1 extends o implements Function1<WidgetServerDeleteDialog$Model, Unit> {
    public final /* synthetic */ WidgetServerDeleteDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerDeleteDialog$onViewBoundOrOnResume$1(WidgetServerDeleteDialog widgetServerDeleteDialog) {
        super(1);
        this.this$0 = widgetServerDeleteDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerDeleteDialog$Model widgetServerDeleteDialog$Model) {
        invoke2(widgetServerDeleteDialog$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerDeleteDialog$Model widgetServerDeleteDialog$Model) {
        WidgetServerDeleteDialog widgetServerDeleteDialog = this.this$0;
        m.checkNotNullExpressionValue(widgetServerDeleteDialog$Model, "it");
        WidgetServerDeleteDialog.access$configureUI(widgetServerDeleteDialog, widgetServerDeleteDialog$Model);
    }
}
