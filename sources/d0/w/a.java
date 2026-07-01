package d0.w;

import d0.z.d.m;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Element$a;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements CoroutineContext$Element {
    private final CoroutineContext$Key<?> key;

    public a(CoroutineContext$Key<?> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        this.key = coroutineContext$Key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext$Element, ? extends R> function2) {
        m.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext$Element$a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext$Element> E get(CoroutineContext$Key<E> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        return (E) CoroutineContext$Element$a.get(this, coroutineContext$Key);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public CoroutineContext$Key<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext$Key<?> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        return CoroutineContext$Element$a.minusKey(this, coroutineContext$Key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext$Element$a.plus(this, coroutineContext);
    }
}
