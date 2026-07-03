package p659s.p660a;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12224e0;

/* JADX INFO: renamed from: s.a.h */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C13114h {

    /* JADX INFO: renamed from: s.a.h$a */
    /* JADX INFO: compiled from: Timeout.kt */
    @InterfaceC12188e(m10084c = "kotlinx.coroutines.TimeoutKt", m10085f = "Timeout.kt", m10086l = {101}, m10087m = "withTimeoutOrNull")
    public static final class a extends AbstractC12187d {
        public long J$0;
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
            return C13114h.m11283b(0L, null, this);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final <U, T extends U> Object m11282a(RunnableC13164x1<U, ? super T> runnableC13164x1, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws Throwable {
        Object c13159w;
        Object objM11295R;
        runnableC13164x1.mo10913n(false, true, new C13136o0(runnableC13164x1, C3404f.m4300i0(runnableC13164x1.f27702m.getContext()).mo11196x(runnableC13164x1.f27920n, runnableC13164x1, runnableC13164x1.f27714k)));
        runnableC13164x1.m11187f0();
        try {
            if (function2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            c13159w = ((Function2) C12224e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(runnableC13164x1, runnableC13164x1);
            if (c13159w != C12183c.getCOROUTINE_SUSPENDED() && (objM11295R = runnableC13164x1.m11295R(c13159w)) != C13119i1.f27858b) {
                if (!(objM11295R instanceof C13159w)) {
                    return C13119i1.m11314a(objM11295R);
                }
                Throwable th = ((C13159w) objM11295R).f27913b;
                if (((th instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th).coroutine == runnableC13164x1) ? false : true) {
                    throw th;
                }
                if (c13159w instanceof C13159w) {
                    throw ((C13159w) c13159w).f27913b;
                }
                return c13159w;
            }
            return C12183c.getCOROUTINE_SUSPENDED();
        } catch (Throwable th2) {
            c13159w = new C13159w(th2, false, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, s.a.x1] */
    /* JADX INFO: renamed from: b */
    public static final <T> Object m11283b(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        a aVar;
        TimeoutCancellationException e;
        Ref$ObjectRef ref$ObjectRef;
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
        if (i2 == 0) {
            C12113l.throwOnFailure(obj);
            if (j <= 0) {
                return null;
            }
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            try {
                aVar.J$0 = j;
                aVar.L$0 = function2;
                aVar.L$1 = ref$ObjectRef2;
                aVar.label = 1;
                ?? r2 = (T) new RunnableC13164x1(j, aVar);
                ref$ObjectRef2.element = r2;
                Object objM11282a = m11282a(r2, function2);
                if (objM11282a == C12183c.getCOROUTINE_SUSPENDED()) {
                    C12190g.probeCoroutineSuspended(aVar);
                }
                return objM11282a == coroutine_suspended ? coroutine_suspended : objM11282a;
            } catch (TimeoutCancellationException e2) {
                e = e2;
                ref$ObjectRef = ref$ObjectRef2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) aVar.L$1;
            try {
                C12113l.throwOnFailure(obj);
                return obj;
            } catch (TimeoutCancellationException e3) {
                e = e3;
            }
        }
        if (e.coroutine == ((RunnableC13164x1) ref$ObjectRef.element)) {
            return null;
        }
        throw e;
    }
}
