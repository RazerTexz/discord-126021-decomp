package com.discord.widgets.chat.input.expression;

import com.discord.widgets.chat.input.sticker.WidgetStickerPickerSheet;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray$handleEvent$3 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ ExpressionTrayViewModel$Event $event;
    public final /* synthetic */ WidgetStickerPickerSheet $pickerSheet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionTray$handleEvent$3(WidgetStickerPickerSheet widgetStickerPickerSheet, ExpressionTrayViewModel$Event expressionTrayViewModel$Event) {
        super(1);
        this.$pickerSheet = widgetStickerPickerSheet;
        this.$event = expressionTrayViewModel$Event;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        this.$pickerSheet.scrollToPack(((ExpressionTrayViewModel$Event$ShowStickerPicker) this.$event).getStickerPackId());
    }
}
