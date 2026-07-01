package com.discord.widgets.user.usersheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$onViewCreated$6 extends o implements Function2<Float, Boolean, Unit> {
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$onViewCreated$6(WidgetUserSheet widgetUserSheet) {
        super(2);
        this.this$0 = widgetUserSheet;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Float f, Boolean bool) {
        invoke(f.floatValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(float f, boolean z2) {
        if (z2) {
            WidgetUserSheet.access$getViewModel$p(this.this$0).setUserOutputVolume(f);
        }
    }
}
