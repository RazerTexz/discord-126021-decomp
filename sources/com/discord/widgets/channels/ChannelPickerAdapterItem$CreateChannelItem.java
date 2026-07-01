package com.discord.widgets.channels;


/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPickerAdapterItem$CreateChannelItem extends ChannelPickerAdapterItem {
    public static final ChannelPickerAdapterItem$CreateChannelItem INSTANCE = new ChannelPickerAdapterItem$CreateChannelItem();
    private static final String key = "channel-picker-create-channel-item";

    private ChannelPickerAdapterItem$CreateChannelItem() {
        super(null);
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }
}
