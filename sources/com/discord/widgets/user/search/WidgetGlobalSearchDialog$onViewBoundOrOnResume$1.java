package com.discord.widgets.user.search;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchDialog$onViewBoundOrOnResume$1 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ WidgetGlobalSearchDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchDialog$onViewBoundOrOnResume$1(WidgetGlobalSearchDialog widgetGlobalSearchDialog) {
        super(1);
        this.this$0 = widgetGlobalSearchDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        m.checkNotNullParameter(unit, "it");
        this.this$0.dismiss();
    }
}
