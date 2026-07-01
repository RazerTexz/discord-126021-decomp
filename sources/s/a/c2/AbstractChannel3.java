package s.a.c2;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.Exceptions;
import d0.Result2;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import s.a.CancellableContinuation3;
import s.a.CancellableContinuationImpl5;
import s.a.CancellableContinuationImpl6;
import s.a.a.LockFreeLinkedList;
import s.a.a.LockFreeLinkedList2;
import s.a.a.LockFreeLinkedList3;
import s.a.a.LockFreeLinkedList4;
import s.a.a.StackTraceRecovery;
import s.a.a.Symbol3;

/* JADX INFO: renamed from: s.a.c2.c, reason: use source file name */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractChannel3<E> implements Channel7<E> {
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(AbstractChannel3.class, Object.class, "onCloseHandler");
    public final Function1<E, Unit> l;
    public final LockFreeLinkedList k = new LockFreeLinkedList();
    public volatile Object onCloseHandler = null;

    /* JADX INFO: renamed from: s.a.c2.c$a */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static final class a<E> extends AbstractChannel7 {
        public final E m;

        public a(E e) {
            this.m = e;
        }

        @Override // s.a.c2.AbstractChannel7
        public void q() {
        }

        @Override // s.a.c2.AbstractChannel7
        public Object r() {
            return this.m;
        }

        @Override // s.a.c2.AbstractChannel7
        public void s(AbstractChannel4<?> abstractChannel4) {
        }

        @Override // s.a.c2.AbstractChannel7
        public Symbol3 t(LockFreeLinkedList3.b bVar) {
            return CancellableContinuationImpl6.a;
        }

        @Override // s.a.a.LockFreeLinkedList3
        public String toString() {
            StringBuilder sbU = outline.U("SendBuffered@");
            sbU.append(b.i.a.f.e.o.f.l0(this));
            sbU.append('(');
            sbU.append(this.m);
            sbU.append(')');
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.c2.c$b */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class b extends LockFreeLinkedList3.a {
        public final /* synthetic */ AbstractChannel3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LockFreeLinkedList3 lockFreeLinkedList3, LockFreeLinkedList3 lockFreeLinkedList4, AbstractChannel3 abstractChannel3) {
            super(lockFreeLinkedList4);
            this.d = abstractChannel3;
        }

        @Override // s.a.a.Atomic2
        public Object c(LockFreeLinkedList3 lockFreeLinkedList3) {
            if (this.d.i()) {
                return null;
            }
            return LockFreeLinkedList2.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractChannel3(Function1<? super E, Unit> function1) {
        this.l = function1;
    }

    public static final void a(AbstractChannel3 abstractChannel3, Continuation continuation, Object obj, AbstractChannel4 abstractChannel4) {
        OnUndeliveredElement onUndeliveredElementQ;
        abstractChannel3.f(abstractChannel4);
        Throwable thW = abstractChannel4.w();
        Function1<E, Unit> function1 = abstractChannel3.l;
        if (function1 == null || (onUndeliveredElementQ = b.i.a.f.e.o.f.q(function1, obj, null, 2)) == null) {
            Result2.a aVar = Result2.j;
            ((CancellableContinuationImpl5) continuation).resumeWith(Result2.m97constructorimpl(Result3.createFailure(thW)));
        } else {
            Exceptions.addSuppressed(onUndeliveredElementQ, thW);
            Result2.a aVar2 = Result2.j;
            ((CancellableContinuationImpl5) continuation).resumeWith(Result2.m97constructorimpl(Result3.createFailure(onUndeliveredElementQ)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0036  */
    /* JADX WARN: Code duplicated, block: B:24:0x0039 A[ORIG_RETURN, RETURN] */
    public Object c(AbstractChannel7 abstractChannel7) {
        int iP;
        boolean z2;
        LockFreeLinkedList3 lockFreeLinkedList3K;
        if (h()) {
            LockFreeLinkedList3 lockFreeLinkedList3 = this.k;
            do {
                lockFreeLinkedList3K = lockFreeLinkedList3.k();
                if (lockFreeLinkedList3K instanceof AbstractChannel6) {
                    return lockFreeLinkedList3K;
                }
            } while (!lockFreeLinkedList3K.e(abstractChannel7, lockFreeLinkedList3));
            return null;
        }
        LockFreeLinkedList3 lockFreeLinkedList4 = this.k;
        b bVar = new b(abstractChannel7, abstractChannel7, this);
        do {
            LockFreeLinkedList3 lockFreeLinkedList3K2 = lockFreeLinkedList4.k();
            if (lockFreeLinkedList3K2 instanceof AbstractChannel6) {
                return lockFreeLinkedList3K2;
            }
            iP = lockFreeLinkedList3K2.p(abstractChannel7, lockFreeLinkedList4, bVar);
            z2 = true;
            if (iP != 1) {
            }
            if (z2) {
                return null;
            }
            return AbstractChannel2.e;
        } while (iP != 2);
        z2 = false;
        if (z2) {
            return AbstractChannel2.e;
        }
        return null;
    }

    public String d() {
        return "";
    }

    public final AbstractChannel4<?> e() {
        LockFreeLinkedList3 lockFreeLinkedList3K = this.k.k();
        if (!(lockFreeLinkedList3K instanceof AbstractChannel4)) {
            lockFreeLinkedList3K = null;
        }
        AbstractChannel4<?> abstractChannel4 = (AbstractChannel4) lockFreeLinkedList3K;
        if (abstractChannel4 == null) {
            return null;
        }
        f(abstractChannel4);
        return abstractChannel4;
    }

    public final void f(AbstractChannel4<?> abstractChannel4) {
        Object objT0 = null;
        while (true) {
            LockFreeLinkedList3 lockFreeLinkedList3K = abstractChannel4.k();
            if (!(lockFreeLinkedList3K instanceof AbstractChannel5)) {
                lockFreeLinkedList3K = null;
            }
            AbstractChannel5 abstractChannel5 = (AbstractChannel5) lockFreeLinkedList3K;
            if (abstractChannel5 == null) {
                break;
            }
            if (abstractChannel5.n()) {
                objT0 = b.i.a.f.e.o.f.T0(objT0, abstractChannel5);
            } else {
                Object objI = abstractChannel5.i();
                Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
                ((LockFreeLinkedList4) objI).a.f(null);
            }
        }
        if (objT0 == null) {
            return;
        }
        if (!(objT0 instanceof ArrayList)) {
            ((AbstractChannel5) objT0).r(abstractChannel4);
            return;
        }
        ArrayList arrayList = (ArrayList) objT0;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((AbstractChannel5) arrayList.get(size)).r(abstractChannel4);
            }
        }
    }

    public final Throwable g(E e, AbstractChannel4<?> abstractChannel4) {
        OnUndeliveredElement onUndeliveredElementQ;
        f(abstractChannel4);
        Function1<E, Unit> function1 = this.l;
        if (function1 == null || (onUndeliveredElementQ = b.i.a.f.e.o.f.q(function1, e, null, 2)) == null) {
            return abstractChannel4.w();
        }
        Exceptions.addSuppressed(onUndeliveredElementQ, abstractChannel4.w());
        throw onUndeliveredElementQ;
    }

    public abstract boolean h();

    public abstract boolean i();

    @Override // s.a.c2.Channel7
    public boolean j(Throwable th) {
        boolean z2;
        Object obj;
        Symbol3 symbol3;
        AbstractChannel4<?> abstractChannel4 = new AbstractChannel4<>(th);
        LockFreeLinkedList3 lockFreeLinkedList3 = this.k;
        while (true) {
            LockFreeLinkedList3 lockFreeLinkedList3K = lockFreeLinkedList3.k();
            if (!(!(lockFreeLinkedList3K instanceof AbstractChannel4))) {
                z2 = false;
                break;
            }
            if (lockFreeLinkedList3K.e(abstractChannel4, lockFreeLinkedList3)) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            abstractChannel4 = (AbstractChannel4) this.k.k();
        }
        f(abstractChannel4);
        if (z2 && (obj = this.onCloseHandler) != null && obj != (symbol3 = AbstractChannel2.f) && j.compareAndSet(this, obj, symbol3)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th);
        }
        return z2;
    }

    public Object k(E e) {
        AbstractChannel6<E> abstractChannel6N;
        do {
            abstractChannel6N = n();
            if (abstractChannel6N == null) {
                return AbstractChannel2.c;
            }
        } while (abstractChannel6N.d(e, null) == null);
        abstractChannel6N.c(e);
        return abstractChannel6N.b();
    }

    @Override // s.a.c2.Channel7
    public void l(Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj != AbstractChannel2.f) {
                throw new IllegalStateException(outline.v("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        AbstractChannel4<?> abstractChannel4E = e();
        if (abstractChannel4E == null || !atomicReferenceFieldUpdater.compareAndSet(this, function1, AbstractChannel2.f)) {
            return;
        }
        function1.invoke(abstractChannel4E.m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [s.a.a.k] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public AbstractChannel6<E> n() {
        ?? r1;
        LockFreeLinkedList3 lockFreeLinkedList3O;
        LockFreeLinkedList lockFreeLinkedList = this.k;
        while (true) {
            Object objI = lockFreeLinkedList.i();
            Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            r1 = (LockFreeLinkedList3) objI;
            if (r1 == lockFreeLinkedList || !(r1 instanceof AbstractChannel6)) {
                break;
            }
            if ((!(((AbstractChannel6) r1) instanceof AbstractChannel4) || r1.m()) && (lockFreeLinkedList3O = r1.o()) != null) {
                lockFreeLinkedList3O.l();
            }
            return (AbstractChannel6) r1;
        }
        r1 = 0;
        return (AbstractChannel6) r1;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0080  */
    /* JADX WARN: Code duplicated, block: B:40:0x0089 A[EDGE_INSN: B:40:0x0089->B:41:0x008e BREAK  A[LOOP:0: B:7:0x0013->B:56:?]] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:51:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:? A[LOOP:0: B:7:0x0013->B:56:?, LOOP_END, SYNTHETIC] */
    @Override // s.a.c2.Channel7
    public final Object o(E e, Continuation<? super Unit> continuation) {
        Object objK;
        if (k(e) == AbstractChannel2.f3834b) {
            return Unit.a;
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5O0 = b.i.a.f.e.o.f.o0(IntrinsicsJvm.intercepted(continuation));
        while (true) {
            if (!(this.k.j() instanceof AbstractChannel6) && i()) {
                AbstractChannel7 abstractChannel8 = this.l == null ? new AbstractChannel8(e, cancellableContinuationImpl5O0) : new AbstractChannel9(e, cancellableContinuationImpl5O0, this.l);
                Object objC = c(abstractChannel8);
                if (objC == null) {
                    cancellableContinuationImpl5O0.f(new CancellableContinuation3(abstractChannel8));
                    break;
                }
                if (objC instanceof AbstractChannel4) {
                    a(this, cancellableContinuationImpl5O0, e, (AbstractChannel4) objC);
                    break;
                }
                if (objC != AbstractChannel2.e && !(objC instanceof AbstractChannel5)) {
                    throw new IllegalStateException(outline.v("enqueueSend returned ", objC).toString());
                }
                objK = k(e);
                if (objK == AbstractChannel2.f3834b) {
                    Unit unit = Unit.a;
                    Result2.a aVar = Result2.j;
                    cancellableContinuationImpl5O0.resumeWith(Result2.m97constructorimpl(unit));
                    break;
                }
                if (objK == AbstractChannel2.c) {
                    if (objK instanceof AbstractChannel4) {
                        throw new IllegalStateException(outline.v("offerInternal returned ", objK).toString());
                    }
                    a(this, cancellableContinuationImpl5O0, e, (AbstractChannel4) objK);
                    break;
                }
            } else {
                objK = k(e);
                if (objK == AbstractChannel2.f3834b) {
                    Unit unit2 = Unit.a;
                    Result2.a aVar2 = Result2.j;
                    cancellableContinuationImpl5O0.resumeWith(Result2.m97constructorimpl(unit2));
                    break;
                }
                if (objK == AbstractChannel2.c) {
                    if (objK instanceof AbstractChannel4) {
                        throw new IllegalStateException(outline.v("offerInternal returned ", objK).toString());
                    }
                    a(this, cancellableContinuationImpl5O0, e, (AbstractChannel4) objK);
                    break;
                }
            }
        }
        Object objU = cancellableContinuationImpl5O0.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU == Intrinsics2.getCOROUTINE_SUSPENDED() ? objU : Unit.a;
    }

    @Override // s.a.c2.Channel7
    public final boolean offer(E e) throws Throwable {
        Object objK = k(e);
        if (objK == AbstractChannel2.f3834b) {
            return true;
        }
        if (objK != AbstractChannel2.c) {
            if (!(objK instanceof AbstractChannel4)) {
                throw new IllegalStateException(outline.v("offerInternal returned ", objK).toString());
            }
            Throwable thG = g(e, (AbstractChannel4) objK);
            String str = StackTraceRecovery.a;
            throw thG;
        }
        AbstractChannel4<?> abstractChannel4E = e();
        if (abstractChannel4E == null) {
            return false;
        }
        Throwable thG2 = g(e, abstractChannel4E);
        String str2 = StackTraceRecovery.a;
        throw thG2;
    }

    @Override // s.a.c2.Channel7
    public final boolean p() {
        return e() != null;
    }

    public final AbstractChannel7 q() {
        LockFreeLinkedList3 lockFreeLinkedList3;
        LockFreeLinkedList3 lockFreeLinkedList3O;
        LockFreeLinkedList lockFreeLinkedList = this.k;
        while (true) {
            Object objI = lockFreeLinkedList.i();
            Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            lockFreeLinkedList3 = (LockFreeLinkedList3) objI;
            if (lockFreeLinkedList3 == lockFreeLinkedList || !(lockFreeLinkedList3 instanceof AbstractChannel7)) {
                break;
            }
            if ((!(((AbstractChannel7) lockFreeLinkedList3) instanceof AbstractChannel4) || lockFreeLinkedList3.m()) && (lockFreeLinkedList3O = lockFreeLinkedList3.o()) != null) {
                lockFreeLinkedList3O.l();
            }
            return (AbstractChannel7) lockFreeLinkedList3;
        }
        lockFreeLinkedList3 = null;
        return (AbstractChannel7) lockFreeLinkedList3;
    }

    public String toString() {
        String string;
        String string2;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(MentionUtils.MENTIONS_CHAR);
        sb.append(b.i.a.f.e.o.f.l0(this));
        sb.append('{');
        LockFreeLinkedList3 lockFreeLinkedList3J = this.k.j();
        if (lockFreeLinkedList3J == this.k) {
            string2 = "EmptyQueue";
        } else {
            if (lockFreeLinkedList3J instanceof AbstractChannel4) {
                string = lockFreeLinkedList3J.toString();
            } else if (lockFreeLinkedList3J instanceof AbstractChannel5) {
                string = "ReceiveQueued";
            } else if (lockFreeLinkedList3J instanceof AbstractChannel7) {
                string = "SendQueued";
            } else {
                string = "UNEXPECTED:" + lockFreeLinkedList3J;
            }
            LockFreeLinkedList3 lockFreeLinkedList3K = this.k.k();
            if (lockFreeLinkedList3K != lockFreeLinkedList3J) {
                StringBuilder sbX = outline.X(string, ",queueSize=");
                LockFreeLinkedList lockFreeLinkedList = this.k;
                Object objI = lockFreeLinkedList.i();
                Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                int i = 0;
                for (LockFreeLinkedList3 lockFreeLinkedList3J2 = (LockFreeLinkedList3) objI; !Intrinsics3.areEqual(lockFreeLinkedList3J2, lockFreeLinkedList); lockFreeLinkedList3J2 = lockFreeLinkedList3J2.j()) {
                    i++;
                }
                sbX.append(i);
                string2 = sbX.toString();
                if (lockFreeLinkedList3K instanceof AbstractChannel4) {
                    string2 = string2 + ",closedForSend=" + lockFreeLinkedList3K;
                }
            } else {
                string2 = string;
            }
        }
        sb.append(string2);
        sb.append('}');
        sb.append(d());
        return sb.toString();
    }
}
