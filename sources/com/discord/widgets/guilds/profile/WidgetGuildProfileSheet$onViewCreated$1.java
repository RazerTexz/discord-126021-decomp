package com.discord.widgets.guilds.profile;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildProfileSheet$onViewCreated$1 extends k implements Function1<WidgetGuildProfileSheetViewModel$ViewState, Unit> {
    public WidgetGuildProfileSheet$onViewCreated$1(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        super(1, widgetGuildProfileSheet, WidgetGuildProfileSheet.class, "handleViewState", "handleViewState(Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildProfileSheetViewModel$ViewState widgetGuildProfileSheetViewModel$ViewState) {
        invoke2(widgetGuildProfileSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildProfileSheetViewModel$ViewState widgetGuildProfileSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildProfileSheetViewModel$ViewState, "p1");
        WidgetGuildProfileSheet.access$handleViewState((WidgetGuildProfileSheet) this.receiver, widgetGuildProfileSheetViewModel$ViewState);
    }
}
