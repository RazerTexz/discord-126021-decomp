package com.discord.widgets.stage.sheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheet this$0;

    public WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet, WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded) {
        this.this$0 = widgetStageRaisedHandsBottomSheet;
        this.$viewState = widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        boolean zIsSpeaker = this.$viewState.isSpeaker();
        if (zIsSpeaker) {
            WidgetStageRaisedHandsBottomSheet.access$getViewModel$p(this.this$0).setSpeakingState(true);
        } else {
            if (zIsSpeaker) {
                return;
            }
            this.this$0.requestMicrophone(new WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$1(this), new WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$2(this));
        }
    }
}
