package com.discord.widgets.user;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserStatusSheet$onResume$1 extends k implements Function1<WidgetUserStatusSheetViewModel$ViewState, Unit> {
    public WidgetUserStatusSheet$onResume$1(WidgetUserStatusSheet widgetUserStatusSheet) {
        super(1, widgetUserStatusSheet, WidgetUserStatusSheet.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserStatusSheetViewModel$ViewState widgetUserStatusSheetViewModel$ViewState) {
        invoke2(widgetUserStatusSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserStatusSheetViewModel$ViewState widgetUserStatusSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetUserStatusSheetViewModel$ViewState, "p1");
        WidgetUserStatusSheet.access$updateView((WidgetUserStatusSheet) this.receiver, widgetUserStatusSheetViewModel$ViewState);
    }
}
