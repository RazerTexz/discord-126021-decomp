package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet$ViewState $viewState;
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    public WidgetVoiceSettingsBottomSheet$configureUI$1(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet, WidgetVoiceSettingsBottomSheet$ViewState widgetVoiceSettingsBottomSheet$ViewState) {
        this.this$0 = widgetVoiceSettingsBottomSheet;
        this.$viewState = widgetVoiceSettingsBottomSheet$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, this.this$0, this.$viewState.getChannel(), "Voice Call", null, null, 24, null);
    }
}
