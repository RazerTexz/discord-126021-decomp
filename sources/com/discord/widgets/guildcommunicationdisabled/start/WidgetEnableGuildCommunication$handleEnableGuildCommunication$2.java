package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import b.a.d.m;
import b.a.k.b;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication$handleEnableGuildCommunication$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetEnableGuildCommunication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableGuildCommunication$handleEnableGuildCommunication$2(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        super(1);
        this.this$0 = widgetEnableGuildCommunication;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r7) {
        this.this$0.dismiss();
        Context context = this.this$0.getContext();
        Context context2 = this.this$0.getContext();
        m.h(context, context2 != null ? b.h(context2, 2131890045, new Object[0], null, 4) : null, 0, null, 12);
    }
}
