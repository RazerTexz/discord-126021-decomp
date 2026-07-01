package s.a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import s.a.a.Scopes2;
import s.a.a.ThreadContext;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z1<T> extends Scopes2<T> {
    public z1(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // s.a.a.Scopes2, s.a.AbstractCoroutine
    public void e0(Object obj) {
        Object objX0 = b.i.a.f.e.o.f.X0(obj, this.m);
        CoroutineContext context = this.m.getContext();
        Object objB = ThreadContext.b(context, null);
        try {
            this.m.resumeWith(objX0);
        } finally {
            ThreadContext.a(context, objB);
        }
    }
}
