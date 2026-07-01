package com.discord.widgets.chat.input.sticker;

import com.discord.widgets.chat.MessageManager;
import d0.z.d.m;
import java.util.Locale;

/* JADX INFO: compiled from: StickerPickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPickerSheetViewModel extends StickerPickerViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerSheetViewModel(Locale locale, MessageManager messageManager, long j) {
        super(null, null, locale, messageManager, null, j, null, null, null, null, null, 2003, null);
        m.checkNotNullParameter(locale, "locale");
        m.checkNotNullParameter(messageManager, "messageManager");
    }
}
