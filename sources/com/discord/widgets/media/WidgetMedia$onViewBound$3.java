package com.discord.widgets.media;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$onViewBound$3 extends o implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ WidgetMedia this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMedia$onViewBound$3(WidgetMedia widgetMedia) {
        super(2);
        this.this$0 = widgetMedia;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.a;
    }

    public final void invoke(int i, int i2) {
        WidgetMedia.access$setToolbarHeight$p(this.this$0, i);
    }
}
