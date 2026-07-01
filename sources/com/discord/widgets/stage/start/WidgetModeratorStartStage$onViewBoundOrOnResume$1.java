package com.discord.widgets.stage.start;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetModeratorStartStage$onViewBoundOrOnResume$1 extends k implements Function1<ModeratorStartStageViewModel$ViewState, Unit> {
    public WidgetModeratorStartStage$onViewBoundOrOnResume$1(WidgetModeratorStartStage widgetModeratorStartStage) {
        super(1, widgetModeratorStartStage, WidgetModeratorStartStage.class, "configureUi", "configureUi(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModeratorStartStageViewModel$ViewState moderatorStartStageViewModel$ViewState) {
        invoke2(moderatorStartStageViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModeratorStartStageViewModel$ViewState moderatorStartStageViewModel$ViewState) {
        m.checkNotNullParameter(moderatorStartStageViewModel$ViewState, "p1");
        WidgetModeratorStartStage.access$configureUi((WidgetModeratorStartStage) this.receiver, moderatorStartStageViewModel$ViewState);
    }
}
