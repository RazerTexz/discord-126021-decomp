package p507d0.p584w;

import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.d */
/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12177d extends CoroutineContext.Element {

    /* JADX INFO: renamed from: e */
    public static final /* synthetic */ int f25235e = 0;

    /* JADX INFO: renamed from: d0.w.d$a */
    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class a {
        public static <E extends CoroutineContext.Element> E get(InterfaceC12177d interfaceC12177d, CoroutineContext.Key<E> key) {
            C12238m.checkNotNullParameter(key, "key");
            if (!(key instanceof AbstractC12175b)) {
                int i = InterfaceC12177d.f25235e;
                if (b.f25236a != key) {
                    return null;
                }
                Objects.requireNonNull(interfaceC12177d, "null cannot be cast to non-null type E");
                return interfaceC12177d;
            }
            AbstractC12175b abstractC12175b = (AbstractC12175b) key;
            if (!abstractC12175b.isSubKey$kotlin_stdlib(interfaceC12177d.getKey())) {
                return null;
            }
            E e = (E) abstractC12175b.tryCast$kotlin_stdlib(interfaceC12177d);
            if (e instanceof CoroutineContext.Element) {
                return e;
            }
            return null;
        }

        public static CoroutineContext minusKey(InterfaceC12177d interfaceC12177d, CoroutineContext.Key<?> key) {
            C12238m.checkNotNullParameter(key, "key");
            if (key instanceof AbstractC12175b) {
                AbstractC12175b abstractC12175b = (AbstractC12175b) key;
                return (!abstractC12175b.isSubKey$kotlin_stdlib(interfaceC12177d.getKey()) || abstractC12175b.tryCast$kotlin_stdlib(interfaceC12177d) == null) ? interfaceC12177d : C12179f.f25237j;
            }
            int i = InterfaceC12177d.f25235e;
            return b.f25236a == key ? C12179f.f25237j : interfaceC12177d;
        }
    }

    /* JADX INFO: renamed from: d0.w.d$b */
    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class b implements CoroutineContext.Key<InterfaceC12177d> {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ b f25236a = new b();
    }

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    void releaseInterceptedContinuation(Continuation<?> continuation);
}
