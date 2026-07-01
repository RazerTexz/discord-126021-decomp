package d0.w.i.a;

import d0.w.d$b;
import d0.z.d.m;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends a {
    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;

    public d(Continuation<Object> continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        m.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    public final Continuation<Object> intercepted() {
        Continuation<Object> continuationInterceptContinuation = this.intercepted;
        if (continuationInterceptContinuation == null) {
            CoroutineContext context = getContext();
            int i = d0.w.d.e;
            d0.w.d dVar = (d0.w.d) context.get(d$b.a);
            if (dVar == null || (continuationInterceptContinuation = dVar.interceptContinuation(this)) == null) {
                continuationInterceptContinuation = this;
            }
            this.intercepted = continuationInterceptContinuation;
        }
        return continuationInterceptContinuation;
    }

    @Override // d0.w.i.a.a
    public void releaseIntercepted() {
        Continuation<?> continuation = this.intercepted;
        if (continuation != null && continuation != this) {
            CoroutineContext context = getContext();
            int i = d0.w.d.e;
            CoroutineContext$Element coroutineContext$Element = context.get(d$b.a);
            m.checkNotNull(coroutineContext$Element);
            ((d0.w.d) coroutineContext$Element).releaseInterceptedContinuation(continuation);
        }
        this.intercepted = c.j;
    }

    public d(Continuation<Object> continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
