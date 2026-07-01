package com.discord.widgets.chat.input.sticker;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$configureUI$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ StickerPickerViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker$configureUI$1(WidgetStickerPicker widgetStickerPicker, StickerPickerViewModel$ViewState stickerPickerViewModel$ViewState) {
        super(1);
        this.this$0 = widgetStickerPicker;
        this.$viewState = stickerPickerViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetStickerPicker.access$handleNewStickerRecyclerScrollPosition(this.this$0, i, ((StickerPickerViewModel$ViewState$Stickers) this.$viewState).getCategoryItems());
    }
}
