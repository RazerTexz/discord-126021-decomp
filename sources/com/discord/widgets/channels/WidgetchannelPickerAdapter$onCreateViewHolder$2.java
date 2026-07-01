package com.discord.widgets.channels;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetchannelPickerAdapter$onCreateViewHolder$2 extends k implements Function1<ChannelPickerAdapterItem$ChannelItem, Unit> {
    public WidgetchannelPickerAdapter$onCreateViewHolder$2(WidgetchannelPickerAdapter$OnItemClickListener widgetchannelPickerAdapter$OnItemClickListener) {
        super(1, widgetchannelPickerAdapter$OnItemClickListener, WidgetchannelPickerAdapter$OnItemClickListener.class, "onChannelItemClick", "onChannelItemClick(Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChannelPickerAdapterItem$ChannelItem channelPickerAdapterItem$ChannelItem) {
        invoke2(channelPickerAdapterItem$ChannelItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChannelPickerAdapterItem$ChannelItem channelPickerAdapterItem$ChannelItem) {
        m.checkNotNullParameter(channelPickerAdapterItem$ChannelItem, "p1");
        ((WidgetchannelPickerAdapter$OnItemClickListener) this.receiver).onChannelItemClick(channelPickerAdapterItem$ChannelItem);
    }
}
