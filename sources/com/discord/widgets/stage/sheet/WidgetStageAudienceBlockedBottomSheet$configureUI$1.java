package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.stage.StageChannelJoinHelper;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ StageAudienceBlockedBottomSheetViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetStageAudienceBlockedBottomSheet this$0;

    public WidgetStageAudienceBlockedBottomSheet$configureUI$1(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet, StageAudienceBlockedBottomSheetViewModel$ViewState stageAudienceBlockedBottomSheetViewModel$ViewState) {
        this.this$0 = widgetStageAudienceBlockedBottomSheet;
        this.$viewState = stageAudienceBlockedBottomSheetViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        StageChannelJoinHelper.connectToStage$default(stageChannelJoinHelper, contextRequireContext, parentFragmentManager, ((StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded) this.$viewState).getChannel().getId(), true, WidgetStageAudienceBlockedBottomSheet.access$getLaunchStageFullScreen$p(this.this$0), null, null, null, null, new WidgetStageAudienceBlockedBottomSheet$configureUI$1$1(this), 480, null);
    }
}
