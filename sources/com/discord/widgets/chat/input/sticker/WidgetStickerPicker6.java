package com.discord.widgets.chat.input.sticker;

import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.chat.MessageManager;
import d0.z.d.Lambda;
import java.util.Locale;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$viewModelForSheet$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker6 extends Lambda implements Function0<StickerPickerSheetViewModel> {
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker6(WidgetStickerPicker widgetStickerPicker) {
        super(0);
        this.this$0 = widgetStickerPicker;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StickerPickerSheetViewModel invoke() {
        Locale primaryLocale = new LocaleManager().getPrimaryLocale(this.this$0.requireContext());
        MessageManager messageManager = new MessageManager(this.this$0.requireContext(), null, null, null, null, null, null, null, null, 510, null);
        Long initialStickerPackId = this.this$0.getInitialStickerPackId();
        return new StickerPickerSheetViewModel(primaryLocale, messageManager, initialStickerPackId != null ? initialStickerPackId.longValue() : -1L);
    }
}
