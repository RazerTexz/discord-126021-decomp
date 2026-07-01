package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InviteJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$3", f = "InviteJoinHelper.kt", l = {}, m = "invokeSuspend")
public final class InviteJoinHelper$joinViaInvite$3 extends k implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
    public int label;

    public InviteJoinHelper$joinViaInvite$3(Continuation continuation) {
        super(2, continuation);
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new InviteJoinHelper$joinViaInvite$3(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
        return ((InviteJoinHelper$joinViaInvite$3) create(modelInvite, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        return Unit.a;
    }
}
