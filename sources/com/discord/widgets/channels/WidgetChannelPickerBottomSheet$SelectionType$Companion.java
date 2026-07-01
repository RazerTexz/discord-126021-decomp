package com.discord.widgets.channels;

import d0.t.k;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet$SelectionType$Companion {
    private WidgetChannelPickerBottomSheet$SelectionType$Companion() {
    }

    public final WidgetChannelPickerBottomSheet$SelectionType fromInt(int value) {
        WidgetChannelPickerBottomSheet$SelectionType widgetChannelPickerBottomSheet$SelectionType = (WidgetChannelPickerBottomSheet$SelectionType) k.getOrNull(WidgetChannelPickerBottomSheet$SelectionType.values(), value);
        return widgetChannelPickerBottomSheet$SelectionType != null ? widgetChannelPickerBottomSheet$SelectionType : WidgetChannelPickerBottomSheet$SelectionType.UNKNOWN;
    }

    public /* synthetic */ WidgetChannelPickerBottomSheet$SelectionType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
