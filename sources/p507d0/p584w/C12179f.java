package p507d0.p584w;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.f */
/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12179f implements CoroutineContext, Serializable {

    /* JADX INFO: renamed from: j */
    public static final C12179f f25237j = new C12179f();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return f25237j;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        C12238m.checkNotNullParameter(function2, "operation");
        return r;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        C12238m.checkNotNullParameter(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        C12238m.checkNotNullParameter(key, "key");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        C12238m.checkNotNullParameter(coroutineContext, "context");
        return coroutineContext;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
