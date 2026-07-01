package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGifPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSheet$onViewCreated$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetGifPickerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGifPickerSheet$onViewCreated$1(WidgetGifPickerSheet widgetGifPickerSheet) {
        super(0);
        this.this$0 = widgetGifPickerSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Function0 function0Access$getOnGifSelected$p = WidgetGifPickerSheet.access$getOnGifSelected$p(this.this$0);
        if (function0Access$getOnGifSelected$p != null) {
        }
        this.this$0.dismiss();
    }
}
