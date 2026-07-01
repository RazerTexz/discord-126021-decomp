package com.discord.widgets.guilds.join;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ ChannelItem $data;

    public ChannelViewHolder$bind$1(ChannelItem channelItem) {
        this.$data = channelItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ((ChannelItem$ChannelData) this.$data).getGoToChannel().invoke(Long.valueOf(((ChannelItem$ChannelData) this.$data).getWelcomeChannel().getChannelId()), Integer.valueOf(((ChannelItem$ChannelData) this.$data).getIndex()));
        ((ChannelItem$ChannelData) this.$data).getDismissSheet().invoke();
    }
}
