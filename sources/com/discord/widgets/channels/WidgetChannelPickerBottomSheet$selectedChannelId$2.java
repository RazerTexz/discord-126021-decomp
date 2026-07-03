package com.discord.widgets.channels;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet$selectedChannelId$2 extends AbstractC12240o implements Function0<Long> {
    public final /* synthetic */ WidgetChannelPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheet$selectedChannelId$2(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        super(0);
        this.this$0 = widgetChannelPickerBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getArgumentsOrDefault().getLong("ARG_SELECTED_CHANNEL_ID", -1L);
    }
}
