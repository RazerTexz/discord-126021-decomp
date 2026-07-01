package com.discord.widgets.user.usersheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$onViewCreated$18 extends o implements Function2<Long, String, Unit> {
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$onViewCreated$18(WidgetUserSheet widgetUserSheet) {
        super(2);
        this.this$0 = widgetUserSheet;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
        invoke(l.longValue(), str);
        return Unit.a;
    }

    public final void invoke(long j, String str) {
        m.checkNotNullParameter(str, "<anonymous parameter 1>");
        WidgetUserSheet.access$getViewModel$p(this.this$0).moveUserToChannel(j);
    }
}
