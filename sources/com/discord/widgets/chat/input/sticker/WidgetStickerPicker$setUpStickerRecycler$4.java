package com.discord.widgets.chat.input.sticker;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$setUpStickerRecycler$4 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker$setUpStickerRecycler$4(WidgetStickerPicker widgetStickerPicker) {
        super(1);
        this.this$0 = widgetStickerPicker;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetStickerPicker.access$getRecyclerScrollingWithinThresholdSubject$p(this.this$0).onNext(Boolean.valueOf(z2));
    }
}
