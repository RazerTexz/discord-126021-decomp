package com.discord.widgets.chat.input.emoji;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$configureUI$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ EmojiPickerViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetEmojiPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiPicker$configureUI$1(WidgetEmojiPicker widgetEmojiPicker, EmojiPickerViewModel$ViewState emojiPickerViewModel$ViewState) {
        super(1);
        this.this$0 = widgetEmojiPicker;
        this.$viewState = emojiPickerViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetEmojiPicker.access$handleNewEmojiRecyclerScrollPosition(this.this$0, i, ((EmojiPickerViewModel$ViewState$Results) this.$viewState).getCategoryItems());
    }
}
