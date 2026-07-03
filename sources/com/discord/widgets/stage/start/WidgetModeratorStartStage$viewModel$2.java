package com.discord.widgets.stage.start;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetModeratorStartStage$viewModel$2 extends AbstractC12240o implements Function0<ModeratorStartStageViewModel> {
    public final /* synthetic */ WidgetModeratorStartStage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetModeratorStartStage$viewModel$2(WidgetModeratorStartStage widgetModeratorStartStage) {
        super(0);
        this.this$0 = widgetModeratorStartStage;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ModeratorStartStageViewModel invoke() {
        return new ModeratorStartStageViewModel(this.this$0.getChannelId(), null, null, null, null, null, null, 126, null);
    }
}
