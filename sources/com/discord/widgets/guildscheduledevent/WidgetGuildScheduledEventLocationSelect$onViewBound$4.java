package com.discord.widgets.guildscheduledevent;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect$onViewBound$4 extends o implements Function2<Long, String, Unit> {
    public final /* synthetic */ WidgetGuildScheduledEventLocationSelect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelect$onViewBound$4(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        super(2);
        this.this$0 = widgetGuildScheduledEventLocationSelect;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
        invoke(l.longValue(), str);
        return Unit.a;
    }

    public final void invoke(long j, String str) {
        m.checkNotNullParameter(str, "<anonymous parameter 1>");
        WidgetGuildScheduledEventLocationSelect.access$getViewModel$p(this.this$0).selectChannel(j);
    }
}
