package s.a.d2.g;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Element$a;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements CoroutineContext$Element {
    public static final c$a j = new c$a(null);
    public final Throwable k;

    public c(Throwable th) {
        this.k = th;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext$Element, ? extends R> function2) {
        return (R) CoroutineContext$Element$a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext$Element> E get(CoroutineContext$Key<E> coroutineContext$Key) {
        return (E) CoroutineContext$Element$a.get(this, coroutineContext$Key);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public CoroutineContext$Key<?> getKey() {
        return j;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext$Key<?> coroutineContext$Key) {
        return CoroutineContext$Element$a.minusKey(this, coroutineContext$Key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext$Element$a.plus(this, coroutineContext);
    }
}
