package com.discord.widgets.auth;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday$onViewBoundOrOnResume$1$$special$$inlined$apply$lambda$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAuthBirthday$onViewBoundOrOnResume$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthBirthday$onViewBoundOrOnResume$1$$special$$inlined$apply$lambda$1(WidgetAuthBirthday$onViewBoundOrOnResume$1 widgetAuthBirthday$onViewBoundOrOnResume$1) {
        super(1);
        this.this$0 = widgetAuthBirthday$onViewBoundOrOnResume$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetAuthBirthday.access$setBirthday(this.this$0.this$0, j);
    }
}
