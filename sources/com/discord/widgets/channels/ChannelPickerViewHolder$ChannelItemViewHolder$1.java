package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPickerViewHolder$ChannelItemViewHolder$1 implements View$OnClickListener {
    public final /* synthetic */ Function1 $onItemClickListener;
    public final /* synthetic */ ChannelPickerViewHolder$ChannelItemViewHolder this$0;

    public ChannelPickerViewHolder$ChannelItemViewHolder$1(ChannelPickerViewHolder$ChannelItemViewHolder channelPickerViewHolder$ChannelItemViewHolder, Function1 function1) {
        this.this$0 = channelPickerViewHolder$ChannelItemViewHolder;
        this.$onItemClickListener = function1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChannelPickerAdapterItem$ChannelItem channelPickerAdapterItem$ChannelItemAccess$getItem$p = ChannelPickerViewHolder$ChannelItemViewHolder.access$getItem$p(this.this$0);
        if (channelPickerAdapterItem$ChannelItemAccess$getItem$p != null) {
            this.$onItemClickListener.invoke(channelPickerAdapterItem$ChannelItemAccess$getItem$p);
        }
    }
}
