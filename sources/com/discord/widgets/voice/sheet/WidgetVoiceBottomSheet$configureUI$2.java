package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceBottomSheetViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    public WidgetVoiceBottomSheet$configureUI$2(WidgetVoiceBottomSheet widgetVoiceBottomSheet, WidgetVoiceBottomSheetViewModel$ViewState widgetVoiceBottomSheetViewModel$ViewState) {
        this.this$0 = widgetVoiceBottomSheet;
        this.$viewState = widgetVoiceBottomSheetViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, this.this$0, this.$viewState.getChannel(), "Voice Channel Bottom Sheet", null, null, 24, null);
    }
}
