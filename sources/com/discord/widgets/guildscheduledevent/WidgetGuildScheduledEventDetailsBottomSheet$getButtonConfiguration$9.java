package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.widgets.voice.VoiceUtils;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$9 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEventDetailsViewModel$ViewState$Initialized $this_getButtonConfiguration;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$9(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet, GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized) {
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet;
        this.$this_getButtonConfiguration = guildScheduledEventDetailsViewModel$ViewState$Initialized;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        Channel channel = this.$this_getButtonConfiguration.getChannel();
        if (channel != null) {
            VoiceUtils.handleCallChannel(channel, this.this$0);
        }
    }
}
