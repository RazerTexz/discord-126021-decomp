package com.discord.widgets.voice.fullscreen;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$onViewBound$2 extends o implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$onViewBound$2(WidgetCallFullscreen widgetCallFullscreen) {
        super(2);
        this.this$0 = widgetCallFullscreen;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.a;
    }

    public final void invoke(int i, int i2) {
        WidgetCallFullscreen.access$setVoiceControlsSheetPeekHeight(this.this$0);
    }
}
