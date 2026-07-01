package com.discord.widgets.status;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$Companion;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$FeatureContext;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator$setupContainerClicks$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing $viewState;
    public final /* synthetic */ WidgetGlobalStatusIndicator this$0;

    public WidgetGlobalStatusIndicator$setupContainerClicks$1(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing) {
        this.this$0 = widgetGlobalStatusIndicator;
        this.$viewState = widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ModelApplicationStream stream;
        ModelApplicationStream stream2;
        StreamContext streamContext;
        if (ChannelUtils.B(this.$viewState.getSelectedVoiceChannel())) {
            WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, this.this$0.requireContext(), this.$viewState.getSelectedVoiceChannel().getId(), false, null, null, 28, null);
            return;
        }
        TextInVoiceFeatureFlag instance = TextInVoiceFeatureFlag.Companion.getINSTANCE();
        Channel selectedTextChannel = this.$viewState.getSelectedTextChannel();
        String encodedStreamKey = null;
        if (!instance.isEnabled(selectedTextChannel != null ? Long.valueOf(selectedTextChannel.getGuildId()) : null) && ((streamContext = this.$viewState.getStreamContext()) == null || !streamContext.isCurrentUserParticipating())) {
            WidgetVoiceBottomSheet$Companion widgetVoiceBottomSheet$Companion = WidgetVoiceBottomSheet.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetVoiceBottomSheet$Companion.show(parentFragmentManager, this.$viewState.getSelectedVoiceChannel().getId(), true, WidgetVoiceBottomSheet$FeatureContext.HOME);
            return;
        }
        Channel selectedTextChannel2 = this.$viewState.getSelectedTextChannel();
        AppTransitionActivity$Transition appTransitionActivity$Transition = (selectedTextChannel2 == null || !ChannelUtils.J(selectedTextChannel2)) ? AppTransitionActivity$Transition.TYPE_SLIDE_VERTICAL_WITH_FADE : AppTransitionActivity$Transition.TYPE_SLIDE_HORIZONTAL_REVERSE;
        WidgetCallFullscreen$Companion widgetCallFullscreen$Companion = WidgetCallFullscreen.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        StreamContext streamContext2 = this.$viewState.getStreamContext();
        long id2 = (streamContext2 == null || (stream2 = streamContext2.getStream()) == null) ? this.$viewState.getSelectedVoiceChannel().getId() : stream2.getChannelId();
        StreamContext streamContext3 = this.$viewState.getStreamContext();
        if (streamContext3 != null && (stream = streamContext3.getStream()) != null) {
            encodedStreamKey = stream.getEncodedStreamKey();
        }
        WidgetCallFullscreen$Companion.launch$default(widgetCallFullscreen$Companion, contextRequireContext, id2, false, encodedStreamKey, appTransitionActivity$Transition, 4, null);
    }
}
