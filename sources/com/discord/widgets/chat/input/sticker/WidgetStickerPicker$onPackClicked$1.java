package com.discord.widgets.chat.input.sticker;

import d0.z.d.o;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$onPackClicked$1 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ Pair $categoryRange;
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker$onPackClicked$1(WidgetStickerPicker widgetStickerPicker, Pair pair) {
        super(1);
        this.this$0 = widgetStickerPicker;
        this.$categoryRange = pair;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        WidgetStickerPicker.access$getStickerAdapter$p(this.this$0).scrollToPosition(((Number) this.$categoryRange.getFirst()).intValue());
    }
}
