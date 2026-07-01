package com.discord.widgets.servers.member_verification;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerification$onViewBound$2 extends o implements Function2<Integer, Object, Unit> {
    public final /* synthetic */ WidgetMemberVerification this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerification$onViewBound$2(WidgetMemberVerification widgetMemberVerification) {
        super(2);
        this.this$0 = widgetMemberVerification;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Object obj) {
        invoke(num.intValue(), obj);
        return Unit.a;
    }

    public final void invoke(int i, Object obj) {
        m.checkNotNullParameter(obj, "value");
        WidgetMemberVerification.access$getViewModel$p(this.this$0).updateFormValidation(i, obj);
    }
}
