package com.discord.widgets.guilds.join;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildWelcomeSheet$onViewCreated$1 extends k implements Function1<WidgetGuildWelcomeSheetViewModel$ViewState, Unit> {
    public WidgetGuildWelcomeSheet$onViewCreated$1(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
        super(1, widgetGuildWelcomeSheet, WidgetGuildWelcomeSheet.class, "handleViewState", "handleViewState(Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildWelcomeSheetViewModel$ViewState widgetGuildWelcomeSheetViewModel$ViewState) {
        invoke2(widgetGuildWelcomeSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildWelcomeSheetViewModel$ViewState widgetGuildWelcomeSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildWelcomeSheetViewModel$ViewState, "p1");
        WidgetGuildWelcomeSheet.access$handleViewState((WidgetGuildWelcomeSheet) this.receiver, widgetGuildWelcomeSheetViewModel$ViewState);
    }
}
