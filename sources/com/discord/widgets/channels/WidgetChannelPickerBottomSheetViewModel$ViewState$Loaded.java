package com.discord.widgets.channels;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded extends WidgetChannelPickerBottomSheetViewModel$ViewState {
    private final List<ChannelPickerAdapterItem> adapterItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded(List<? extends ChannelPickerAdapterItem> list) {
        super(null);
        m.checkNotNullParameter(list, "adapterItems");
        this.adapterItems = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded copy$default(WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded widgetChannelPickerBottomSheetViewModel$ViewState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetChannelPickerBottomSheetViewModel$ViewState$Loaded.adapterItems;
        }
        return widgetChannelPickerBottomSheetViewModel$ViewState$Loaded.copy(list);
    }

    public final List<ChannelPickerAdapterItem> component1() {
        return this.adapterItems;
    }

    public final WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded copy(List<? extends ChannelPickerAdapterItem> adapterItems) {
        m.checkNotNullParameter(adapterItems, "adapterItems");
        return new WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded(adapterItems);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded) && m.areEqual(this.adapterItems, ((WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded) other).adapterItems);
        }
        return true;
    }

    public final List<ChannelPickerAdapterItem> getAdapterItems() {
        return this.adapterItems;
    }

    public int hashCode() {
        List<ChannelPickerAdapterItem> list = this.adapterItems;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(adapterItems="), this.adapterItems, ")");
    }
}
