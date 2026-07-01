package d0.f0;

import d0.k$a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j<T> extends k<T> implements Iterator<T>, Continuation<Unit>, d0.z.d.g0.a {
    public int j;
    public T k;
    public Iterator<? extends T> l;
    public Continuation<? super Unit> m;

    public final Throwable b() {
        int i = this.j;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        StringBuilder sbU = b.d.b.a.a.U("Unexpected state of the iterator: ");
        sbU.append(this.j);
        return new IllegalStateException(sbU.toString());
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return d0.w.f.j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i = this.j;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator<? extends T> it = this.l;
                d0.z.d.m.checkNotNull(it);
                if (it.hasNext()) {
                    this.j = 2;
                    return true;
                }
                this.l = null;
            }
            this.j = 5;
            Continuation<? super Unit> continuation = this.m;
            d0.z.d.m.checkNotNull(continuation);
            this.m = null;
            Unit unit = Unit.a;
            k$a k_a = d0.k.j;
            continuation.resumeWith(d0.k.m97constructorimpl(unit));
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i = this.j;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.j = 1;
            Iterator<? extends T> it = this.l;
            d0.z.d.m.checkNotNull(it);
            return it.next();
        }
        if (i != 3) {
            throw b();
        }
        this.j = 0;
        T t = this.k;
        this.k = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        d0.l.throwOnFailure(obj);
        this.j = 4;
    }

    public final void setNextStep(Continuation<? super Unit> continuation) {
        this.m = continuation;
    }

    @Override // d0.f0.k
    public Object yield(T t, Continuation<? super Unit> continuation) {
        this.k = t;
        this.j = 3;
        this.m = continuation;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
            d0.w.i.a.g.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == d0.w.h.c.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.a;
    }

    @Override // d0.f0.k
    public Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> continuation) {
        if (!it.hasNext()) {
            return Unit.a;
        }
        this.l = it;
        this.j = 2;
        this.m = continuation;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
            d0.w.i.a.g.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == d0.w.h.c.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.a;
    }
}
