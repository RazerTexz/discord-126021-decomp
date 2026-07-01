package com.discord.widgets.chat.input;

import com.discord.api.sticker.Sticker;
import com.discord.widgets.chat.input.sticker.StickerPickerListener;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1 implements StickerPickerListener {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    public WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1(WidgetChatInputAttachments widgetChatInputAttachments) {
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerPickerListener
    public void onStickerPicked(Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
        FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.hideExpressionTray();
        }
    }
}
