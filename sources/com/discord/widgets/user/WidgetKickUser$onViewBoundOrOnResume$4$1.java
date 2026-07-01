package com.discord.widgets.user;

import android.content.Context;
import b.a.d.m;
import b.a.k.b;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetKickUser$onViewBoundOrOnResume$4$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetKickUser$onViewBoundOrOnResume$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetKickUser$onViewBoundOrOnResume$4$1(WidgetKickUser$onViewBoundOrOnResume$4 widgetKickUser$onViewBoundOrOnResume$4) {
        super(1);
        this.this$0 = widgetKickUser$onViewBoundOrOnResume$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r7) {
        Context context = this.this$0.this$0.getContext();
        Context context2 = this.this$0.this$0.getContext();
        m.h(context, context2 != null ? b.h(context2, 2131892501, new Object[]{this.this$0.$userName}, null, 4) : null, 0, null, 12);
        this.this$0.this$0.dismiss();
    }
}
