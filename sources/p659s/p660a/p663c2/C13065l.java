package p659s.p660a.p663c2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p659s.p660a.C13126l;

/* JADX INFO: renamed from: s.a.c2.l */
/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13065l {

    /* JADX INFO: renamed from: s.a.c2.l$a */
    /* JADX INFO: compiled from: Produce.kt */
    @InterfaceC12188e(m10084c = "kotlinx.coroutines.channels.ProduceKt", m10085f = "Produce.kt", m10086l = {157}, m10087m = "awaitClose")
    public static final class a extends AbstractC12187d {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return C13065l.m11236a(null, null, this);
        }
    }

    /* JADX INFO: renamed from: s.a.c2.l$b */
    /* JADX INFO: compiled from: Produce.kt */
    public static final class b extends AbstractC12240o implements Function1<Throwable, Unit> {
        public final /* synthetic */ CancellableContinuation $cont;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CancellableContinuation cancellableContinuation) {
            super(1);
            this.$cont = cancellableContinuation;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            CancellableContinuation cancellableContinuation = this.$cont;
            Unit unit = Unit.f27425a;
            C12112k.a aVar = C12112k.f25169j;
            cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(unit));
            return unit;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    public static final Object m11236a(ProducerScope<?> producerScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.label = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = aVar.label;
        try {
            if (i2 == 0) {
                C12113l.throwOnFailure(obj);
                if (!(((Job) aVar.getContext().get(Job.INSTANCE)) == producerScope)) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                }
                aVar.L$0 = producerScope;
                aVar.L$1 = function0;
                aVar.label = 1;
                C13126l c13126l = new C13126l(C12182b.intercepted(aVar), 1);
                c13126l.m11318A();
                producerScope.mo11223l(new b(c13126l));
                Object objM11326u = c13126l.m11326u();
                if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
                    C12190g.probeCoroutineSuspended(aVar);
                }
                if (objM11326u == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function0 = (Function0) aVar.L$1;
                C12113l.throwOnFailure(obj);
            }
            function0.invoke();
            return Unit.f27425a;
        } catch (Throwable th) {
            function0.invoke();
            throw th;
        }
    }
}
