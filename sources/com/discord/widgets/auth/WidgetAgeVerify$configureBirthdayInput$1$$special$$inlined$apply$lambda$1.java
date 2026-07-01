package com.discord.widgets.auth;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify$configureBirthdayInput$1$$special$$inlined$apply$lambda$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAgeVerify$configureBirthdayInput$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerify$configureBirthdayInput$1$$special$$inlined$apply$lambda$1(WidgetAgeVerify$configureBirthdayInput$1 widgetAgeVerify$configureBirthdayInput$1) {
        super(1);
        this.this$0 = widgetAgeVerify$configureBirthdayInput$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetAgeVerify.access$getViewModel$p(this.this$0.this$0).setDateOfBirth(j);
    }
}
