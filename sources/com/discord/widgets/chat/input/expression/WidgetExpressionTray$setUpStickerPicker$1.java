package com.discord.widgets.chat.input.expression;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetExpressionTray$setUpStickerPicker$1 extends k implements Function1<Boolean, Unit> {
    public WidgetExpressionTray$setUpStickerPicker$1(WidgetExpressionTray widgetExpressionTray) {
        super(1, widgetExpressionTray, WidgetExpressionTray.class, "showStickersSearchBar", "showStickersSearchBar(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetExpressionTray.access$showStickersSearchBar((WidgetExpressionTray) this.receiver, z2);
    }
}
