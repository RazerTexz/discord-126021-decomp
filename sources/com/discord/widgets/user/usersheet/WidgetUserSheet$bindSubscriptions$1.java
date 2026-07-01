package com.discord.widgets.user.usersheet;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSheet$bindSubscriptions$1 extends k implements Function1<WidgetUserSheetViewModel$ViewState, Unit> {
    public WidgetUserSheet$bindSubscriptions$1(WidgetUserSheet widgetUserSheet) {
        super(1, widgetUserSheet, WidgetUserSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSheetViewModel$ViewState widgetUserSheetViewModel$ViewState) {
        invoke2(widgetUserSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserSheetViewModel$ViewState widgetUserSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetUserSheetViewModel$ViewState, "p1");
        WidgetUserSheet.access$configureUI((WidgetUserSheet) this.receiver, widgetUserSheetViewModel$ViewState);
    }
}
