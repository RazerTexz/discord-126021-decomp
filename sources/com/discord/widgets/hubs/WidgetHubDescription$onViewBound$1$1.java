package com.discord.widgets.hubs;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$onViewBound$1$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetHubDescription$onViewBound$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$onViewBound$1$1(WidgetHubDescription$onViewBound$1 widgetHubDescription$onViewBound$1) {
        super(1);
        this.this$0 = widgetHubDescription$onViewBound$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        this.this$0.this$0.getViewModel().setCategory(i);
    }
}
