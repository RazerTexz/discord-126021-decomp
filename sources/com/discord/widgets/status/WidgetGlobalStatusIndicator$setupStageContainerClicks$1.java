package com.discord.widgets.status;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator$setupStageContainerClicks$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing $viewState;
    public final /* synthetic */ WidgetGlobalStatusIndicator this$0;

    public WidgetGlobalStatusIndicator$setupStageContainerClicks$1(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing) {
        this.this$0 = widgetGlobalStatusIndicator;
        this.$viewState = widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, this.this$0.requireContext(), this.$viewState.getSelectedVoiceChannel().getId(), false, null, null, 28, null);
    }
}
