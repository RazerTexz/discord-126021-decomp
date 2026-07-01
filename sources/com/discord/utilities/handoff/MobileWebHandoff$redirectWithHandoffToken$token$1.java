package com.discord.utilities.handoff;

import b.i.a.f.e.o.f;
import com.discord.api.handoff.HandoffToken;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.k0;

/* JADX INFO: compiled from: MobileWebHandoff.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1", f = "MobileWebHandoff.kt", l = {45}, m = "invokeSuspend")
public final class MobileWebHandoff$redirectWithHandoffToken$token$1 extends k implements Function1<Continuation<? super HandoffToken>, Object> {
    public final /* synthetic */ Ref$ObjectRef $nonce;
    public int label;
    public final /* synthetic */ MobileWebHandoff this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileWebHandoff$redirectWithHandoffToken$token$1(MobileWebHandoff mobileWebHandoff, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(1, continuation);
        this.this$0 = mobileWebHandoff;
        this.$nonce = ref$ObjectRef;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new MobileWebHandoff$redirectWithHandoffToken$token$1(this.this$0, this.$nonce, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super HandoffToken> continuation) {
        return ((MobileWebHandoff$redirectWithHandoffToken$token$1) create(continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = k0.f3842b;
            MobileWebHandoff$redirectWithHandoffToken$token$1$1 mobileWebHandoff$redirectWithHandoffToken$token$1$1 = new MobileWebHandoff$redirectWithHandoffToken$token$1$1(this, null);
            this.label = 1;
            obj = f.C1(coroutineDispatcher, mobileWebHandoff$redirectWithHandoffToken$token$1$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        return obj;
    }
}
