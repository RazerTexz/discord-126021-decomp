package com.discord.widgets.chat.input.emoji;

import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$viewModelForInline$2 extends AbstractC12240o implements Function0<EmojiPickerViewModel.Inline> {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiPicker$viewModelForInline$2(WidgetEmojiPicker widgetEmojiPicker) {
        super(0);
        this.this$0 = widgetEmojiPicker;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiPickerViewModel.Inline invoke() {
        return new EmojiPickerViewModel.Inline(this.this$0.getEmojiPickerContextType(), new LocaleManager().getPrimaryLocale(this.this$0.getContext()));
    }
}
