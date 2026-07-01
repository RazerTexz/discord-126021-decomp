package com.discord.widgets.user.usersheet;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSheet$bindSubscriptions$2 extends k implements Function1<WidgetUserSheetViewModel$Event, Unit> {
    public WidgetUserSheet$bindSubscriptions$2(WidgetUserSheet widgetUserSheet) {
        super(1, widgetUserSheet, WidgetUserSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSheetViewModel$Event widgetUserSheetViewModel$Event) {
        invoke2(widgetUserSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserSheetViewModel$Event widgetUserSheetViewModel$Event) {
        m.checkNotNullParameter(widgetUserSheetViewModel$Event, "p1");
        WidgetUserSheet.access$handleEvent((WidgetUserSheet) this.receiver, widgetUserSheetViewModel$Event);
    }
}
