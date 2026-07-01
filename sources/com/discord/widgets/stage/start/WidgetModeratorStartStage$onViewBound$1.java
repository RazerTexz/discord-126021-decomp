package com.discord.widgets.stage.start;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetModeratorStartStage$onViewBound$1 extends k implements Function1<ModeratorStartStageItem, Unit> {
    public WidgetModeratorStartStage$onViewBound$1(WidgetModeratorStartStage widgetModeratorStartStage) {
        super(1, widgetModeratorStartStage, WidgetModeratorStartStage.class, "handleListItemClick", "handleListItemClick(Lcom/discord/widgets/stage/start/ModeratorStartStageItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModeratorStartStageItem moderatorStartStageItem) {
        invoke2(moderatorStartStageItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModeratorStartStageItem moderatorStartStageItem) {
        m.checkNotNullParameter(moderatorStartStageItem, "p1");
        WidgetModeratorStartStage.access$handleListItemClick((WidgetModeratorStartStage) this.receiver, moderatorStartStageItem);
    }
}
