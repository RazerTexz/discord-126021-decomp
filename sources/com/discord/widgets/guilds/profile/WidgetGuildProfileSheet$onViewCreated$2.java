package com.discord.widgets.guilds.profile;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildProfileSheet$onViewCreated$2 extends k implements Function1<WidgetGuildProfileSheetViewModel$Event, Unit> {
    public WidgetGuildProfileSheet$onViewCreated$2(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        super(1, widgetGuildProfileSheet, WidgetGuildProfileSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildProfileSheetViewModel$Event widgetGuildProfileSheetViewModel$Event) {
        invoke2(widgetGuildProfileSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildProfileSheetViewModel$Event widgetGuildProfileSheetViewModel$Event) {
        m.checkNotNullParameter(widgetGuildProfileSheetViewModel$Event, "p1");
        WidgetGuildProfileSheet.access$handleEvent((WidgetGuildProfileSheet) this.receiver, widgetGuildProfileSheetViewModel$Event);
    }
}
