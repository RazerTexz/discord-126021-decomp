package com.discord.widgets.stage.sheet;

import com.discord.api.stageinstance.StageInstance;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheetViewModel$openStage$2 extends o implements Function1<StageInstance, Unit> {
    public final /* synthetic */ boolean $microphonePermissionGranted;
    public final /* synthetic */ WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetStageStartEventBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheetViewModel$openStage$2(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel, boolean z2, WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded widgetStageStartEventBottomSheetViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetStageStartEventBottomSheetViewModel;
        this.$microphonePermissionGranted = z2;
        this.$viewState = widgetStageStartEventBottomSheetViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
        invoke2(stageInstance);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StageInstance stageInstance) {
        m.checkNotNullParameter(stageInstance, "it");
        if (this.$microphonePermissionGranted) {
            WidgetStageStartEventBottomSheetViewModel.access$setSelfSpeaker(this.this$0);
        }
        WidgetStageStartEventBottomSheetViewModel.access$emitSetStatusSuccessEvent(this.this$0, this.$viewState.getChannel());
    }
}
