package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p507d0.p584w.InterfaceC12177d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.i.a.d */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12187d extends AbstractC12184a {
    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;

    public AbstractC12187d(Continuation<Object> continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        C12238m.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    public final Continuation<Object> intercepted() {
        Continuation<Object> continuationInterceptContinuation = this.intercepted;
        if (continuationInterceptContinuation == null) {
            CoroutineContext context = getContext();
            int i = InterfaceC12177d.f25235e;
            InterfaceC12177d interfaceC12177d = (InterfaceC12177d) context.get(InterfaceC12177d.b.f25236a);
            if (interfaceC12177d == null || (continuationInterceptContinuation = interfaceC12177d.interceptContinuation(this)) == null) {
                continuationInterceptContinuation = this;
            }
            this.intercepted = continuationInterceptContinuation;
        }
        return continuationInterceptContinuation;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public void releaseIntercepted() {
        Continuation<?> continuation = this.intercepted;
        if (continuation != null && continuation != this) {
            CoroutineContext context = getContext();
            int i = InterfaceC12177d.f25235e;
            CoroutineContext.Element element = context.get(InterfaceC12177d.b.f25236a);
            C12238m.checkNotNull(element);
            ((InterfaceC12177d) element).releaseInterceptedContinuation(continuation);
        }
        this.intercepted = C12186c.f25244j;
    }

    public AbstractC12187d(Continuation<Object> continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
