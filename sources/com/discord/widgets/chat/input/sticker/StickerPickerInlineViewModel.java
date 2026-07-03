package com.discord.widgets.chat.input.sticker;

import com.discord.widgets.chat.MessageManager;
import java.util.Locale;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerPickerInlineViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPickerInlineViewModel extends StickerPickerViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerInlineViewModel(Locale locale, MessageManager messageManager, long j) {
        super(null, null, locale, messageManager, null, j, null, null, null, null, null, 2003, null);
        C12238m.checkNotNullParameter(locale, "locale");
        C12238m.checkNotNullParameter(messageManager, "messageManager");
    }
}
