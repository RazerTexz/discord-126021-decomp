package com.discord.widgets.auth;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$configureBirthdayInput$1$$special$$inlined$apply$lambda$1 */
/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7154xf355b2f8 extends AbstractC12240o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAgeVerify.C71531 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7154xf355b2f8(WidgetAgeVerify.C71531 c71531) {
        super(1);
        this.this$0 = c71531;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.f27425a;
    }

    public final void invoke(long j) {
        WidgetAgeVerify.this.getViewModel().setDateOfBirth(j);
    }
}
