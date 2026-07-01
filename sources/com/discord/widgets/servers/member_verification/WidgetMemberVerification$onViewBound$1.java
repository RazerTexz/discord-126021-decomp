package com.discord.widgets.servers.member_verification;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerification$onViewBound$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetMemberVerification this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerification$onViewBound$1(WidgetMemberVerification widgetMemberVerification) {
        super(1);
        this.this$0 = widgetMemberVerification;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetMemberVerification.access$getViewModel$p(this.this$0).updateTermsApproval(z2);
    }
}
