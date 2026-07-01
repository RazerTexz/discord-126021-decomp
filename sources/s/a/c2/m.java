package s.a.c2;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.channels.ProducerScope;
import s.a.h1;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes3.dex */
public class m<E> implements ProducerScope<E>, f {
    public final f<E> m;

    public m(CoroutineContext coroutineContext, f<E> fVar) {
        super(coroutineContext, true);
        this.m = fVar;
    }

    public boolean a() {
        return super.a();
    }

    @Override // s.a.c2.o
    public final void b(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(B(), null, this);
        }
        x(cancellationException);
    }

    public void g0(Throwable th, boolean z2) {
        if (this.m.j(th) || z2) {
            return;
        }
        b.i.a.f.e.o.f.u0(this.k, th);
    }

    public void h0(Object obj) {
        b.i.a.f.e.o.f.I(this.m, null, 1, null);
    }

    @Override // s.a.c2.o
    public g iterator() {
        return this.m.iterator();
    }

    @Override // s.a.c2.s
    public boolean j(Throwable th) {
        return this.m.j(th);
    }

    @Override // s.a.c2.s
    public void l(Function1 function1) {
        this.m.l(function1);
    }

    @Override // s.a.c2.o
    public Object m(Continuation continuation) {
        return this.m.m(continuation);
    }

    @Override // s.a.c2.s
    public Object o(Object obj, Continuation continuation) {
        return this.m.o(obj, continuation);
    }

    @Override // s.a.c2.s
    public boolean offer(Object obj) {
        return this.m.offer(obj);
    }

    @Override // s.a.c2.s
    public boolean p() {
        return this.m.p();
    }

    public void x(Throwable th) throws Throwable {
        CancellationException cancellationExceptionB0 = h1.b0(this, th, null, 1, null);
        this.m.b(cancellationExceptionB0);
        w(cancellationExceptionB0);
    }
}
