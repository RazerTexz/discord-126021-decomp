package p507d0.p584w;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.a */
/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12174a implements CoroutineContext.Element {
    private final CoroutineContext.Key<?> key;

    public AbstractC12174a(CoroutineContext.Key<?> key) {
        C12238m.checkNotNullParameter(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        C12238m.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext.Element.C12790a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        C12238m.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.C12790a.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        C12238m.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.C12790a.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        C12238m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.Element.C12790a.plus(this, coroutineContext);
    }
}
