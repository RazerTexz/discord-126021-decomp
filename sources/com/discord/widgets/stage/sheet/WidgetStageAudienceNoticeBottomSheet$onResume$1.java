package com.discord.widgets.stage.sheet;

import com.discord.api.stageinstance.StageInstance;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceNoticeBottomSheet$onResume$1 extends o implements Function1<StageInstance, Unit> {
    public final /* synthetic */ WidgetStageAudienceNoticeBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageAudienceNoticeBottomSheet$onResume$1(WidgetStageAudienceNoticeBottomSheet widgetStageAudienceNoticeBottomSheet) {
        super(1);
        this.this$0 = widgetStageAudienceNoticeBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
        invoke2(stageInstance);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StageInstance stageInstance) {
        WidgetStageAudienceNoticeBottomSheet.access$configureUI(this.this$0, stageInstance);
    }
}
