package com.discord.widgets.quickmentions;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQuickMentionsDialog$onViewBoundOrOnResume$1 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ WidgetQuickMentionsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetQuickMentionsDialog$onViewBoundOrOnResume$1(WidgetQuickMentionsDialog widgetQuickMentionsDialog) {
        super(1);
        this.this$0 = widgetQuickMentionsDialog;
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
