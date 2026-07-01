package com.discord.widgets.chat.input.sticker;

import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.chat.MessageManager;
import d0.z.d.o;
import java.util.Locale;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$viewModelForInline$2 extends o implements Function0<StickerPickerInlineViewModel> {
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker$viewModelForInline$2(WidgetStickerPicker widgetStickerPicker) {
        super(0);
        this.this$0 = widgetStickerPicker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StickerPickerInlineViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StickerPickerInlineViewModel invoke() {
        Locale primaryLocale = new LocaleManager().getPrimaryLocale(this.this$0.requireContext());
        MessageManager messageManager = new MessageManager(this.this$0.requireContext(), null, null, null, null, null, null, null, null, 510, null);
        Long lAccess$getInitialStickerPackId$p = WidgetStickerPicker.access$getInitialStickerPackId$p(this.this$0);
        return new StickerPickerInlineViewModel(primaryLocale, messageManager, lAccess$getInitialStickerPackId$p != null ? lAccess$getInitialStickerPackId$p.longValue() : -1L);
    }
}
