package com.discord.widgets.channels;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetChannelPickerBottomSheetViewModel> {
    public final /* synthetic */ WidgetChannelPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheet$viewModel$2(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        super(0);
        this.this$0 = widgetChannelPickerBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelPickerBottomSheetViewModel invoke() {
        return new WidgetChannelPickerBottomSheetViewModel(this.this$0.getGuildId(), this.this$0.getSelectedChannelId(), this.this$0.getHideAnnouncementChannels(), null, null, null, 56, null);
    }
}
