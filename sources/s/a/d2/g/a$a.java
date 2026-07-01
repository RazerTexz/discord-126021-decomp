package s.a.d2.g;

import d0.l;
import d0.w.i.a.k;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.objectweb.asm.Opcodes;
import s.a.c2.m;
import s.a.z;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
@d0.w.i.a.e(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {Opcodes.I2D}, m = "invokeSuspend")
public final class a$a extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ s.a.d2.e $collector;
    public Object L$0;
    public int label;
    private CoroutineScope p$;
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$a(a aVar, s.a.d2.e eVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = aVar;
        this.$collector = eVar;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        a$a a_a = new a$a(this.this$0, this.$collector, continuation);
        a_a.p$ = (CoroutineScope) obj;
        return a_a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        a$a a_a = new a$a(this.this$0, this.$collector, continuation);
        a_a.p$ = coroutineScope;
        return a_a.invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            s.a.d2.e eVar = this.$collector;
            a aVar = this.this$0;
            CoroutineContext coroutineContext = aVar.a;
            int i2 = aVar.f3837b;
            if (i2 == -3) {
                i2 = -2;
            }
            s.a.c2.e eVar2 = aVar.c;
            CoroutineStart coroutineStart = CoroutineStart.ATOMIC;
            b bVar = new b(aVar, null);
            m mVar = new m(z.a(coroutineScope, coroutineContext), b.i.a.f.e.o.f.b(i2, eVar2, null, 4));
            mVar.j0(coroutineStart, mVar, bVar);
            this.L$0 = coroutineScope;
            this.label = 1;
            Object objU = b.i.a.f.e.o.f.U(eVar, mVar, true, this);
            if (objU != d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                objU = Unit.a;
            }
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        return Unit.a;
    }
}
