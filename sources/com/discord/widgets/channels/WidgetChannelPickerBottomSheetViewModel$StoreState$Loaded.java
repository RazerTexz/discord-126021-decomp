package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded extends WidgetChannelPickerBottomSheetViewModel$StoreState {
    private final List<Channel> channels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded(List<Channel> list) {
        super(null);
        m.checkNotNullParameter(list, "channels");
        this.channels = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded copy$default(WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded widgetChannelPickerBottomSheetViewModel$StoreState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetChannelPickerBottomSheetViewModel$StoreState$Loaded.channels;
        }
        return widgetChannelPickerBottomSheetViewModel$StoreState$Loaded.copy(list);
    }

    public final List<Channel> component1() {
        return this.channels;
    }

    public final WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded copy(List<Channel> channels) {
        m.checkNotNullParameter(channels, "channels");
        return new WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded(channels);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded) && m.areEqual(this.channels, ((WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded) other).channels);
        }
        return true;
    }

    public final List<Channel> getChannels() {
        return this.channels;
    }

    public int hashCode() {
        List<Channel> list = this.channels;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(channels="), this.channels, ")");
    }
}
