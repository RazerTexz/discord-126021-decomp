package com.discord.widgets.chat.input.sticker;

import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.chat.MessageManager;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$viewModelForInline$2 extends AbstractC12240o implements Function0<StickerPickerInlineViewModel> {
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker$viewModelForInline$2(WidgetStickerPicker widgetStickerPicker) {
        super(0);
        this.this$0 = widgetStickerPicker;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StickerPickerInlineViewModel invoke() {
        Locale primaryLocale = new LocaleManager().getPrimaryLocale(this.this$0.requireContext());
        MessageManager messageManager = new MessageManager(this.this$0.requireContext(), null, null, null, null, null, null, null, null, 510, null);
        Long initialStickerPackId = this.this$0.getInitialStickerPackId();
        return new StickerPickerInlineViewModel(primaryLocale, messageManager, initialStickerPackId != null ? initialStickerPackId.longValue() : -1L);
    }
}
