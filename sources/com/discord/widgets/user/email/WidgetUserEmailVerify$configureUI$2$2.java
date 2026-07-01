package com.discord.widgets.user.email;

import b.a.d.m;
import b.a.k.b;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify$configureUI$2$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetUserEmailVerify$configureUI$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserEmailVerify$configureUI$2$2(WidgetUserEmailVerify$configureUI$2 widgetUserEmailVerify$configureUI$2) {
        super(1);
        this.this$0 = widgetUserEmailVerify$configureUI$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r6) {
        WidgetUserEmailVerify$configureUI$2 widgetUserEmailVerify$configureUI$2 = this.this$0;
        WidgetUserEmailVerify widgetUserEmailVerify = widgetUserEmailVerify$configureUI$2.this$0;
        m.j(widgetUserEmailVerify, b.k(widgetUserEmailVerify, 2131897034, new Object[]{widgetUserEmailVerify$configureUI$2.$model.getEmail()}, null, 4), 0, 4);
    }
}
