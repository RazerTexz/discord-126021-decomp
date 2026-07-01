package com.discord.widgets.guilds.invite;

import com.discord.utilities.error.Error;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1", f = "WidgetGuildInvite.kt", l = {}, m = "invokeSuspend")
public final class WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1 extends k implements Function2<Error, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ WidgetGuildInvite$configureLoadedUI$onAcceptClick$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1(WidgetGuildInvite$configureLoadedUI$onAcceptClick$1 widgetGuildInvite$configureLoadedUI$onAcceptClick$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = widgetGuildInvite$configureLoadedUI$onAcceptClick$1;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1 widgetGuildInvite$configureLoadedUI$onAcceptClick$1$1 = new WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1(this.this$0, continuation);
        widgetGuildInvite$configureLoadedUI$onAcceptClick$1$1.L$0 = obj;
        return widgetGuildInvite$configureLoadedUI$onAcceptClick$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Error error, Continuation<? super Unit> continuation) {
        return ((WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1) create(error, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        WidgetGuildInvite.access$configureUIFailure(this.this$0.this$0, (Error) this.L$0);
        return Unit.a;
    }
}
