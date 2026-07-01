package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet$ViewState $viewState;
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    public WidgetVoiceSettingsBottomSheet$configureUI$4(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet, WidgetVoiceSettingsBottomSheet$ViewState widgetVoiceSettingsBottomSheet$ViewState) {
        this.this$0 = widgetVoiceSettingsBottomSheet;
        this.$viewState = widgetVoiceSettingsBottomSheet$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetGuildScheduledEventListBottomSheet$Companion widgetGuildScheduledEventListBottomSheet$Companion = WidgetGuildScheduledEventListBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildScheduledEventListBottomSheet$Companion.show(parentFragmentManager, this.$viewState.getChannel().getGuildId(), Long.valueOf(this.$viewState.getChannel().getId()));
    }
}
