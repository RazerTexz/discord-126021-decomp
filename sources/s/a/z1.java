package s.a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import s.a.a.a;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z1<T> extends s.a.a.r<T> {
    public z1(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // s.a.a.r, s.a.b
    public void e0(Object obj) {
        Object objX0 = b.i.a.f.e.o.f.X0(obj, this.m);
        CoroutineContext context = this.m.getContext();
        Object objB = a.b(context, null);
        try {
            this.m.resumeWith(objX0);
        } finally {
            a.a(context, objB);
        }
    }
}
