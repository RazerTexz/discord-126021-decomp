package d0.w;

import d0.z.d.m;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<B extends CoroutineContext$Element, E extends B> implements CoroutineContext$Key<E> {
    public final CoroutineContext$Key<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<CoroutineContext$Element, E> f3585b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$Key<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public b(CoroutineContext$Key<B> coroutineContext$Key, Function1<? super CoroutineContext$Element, ? extends E> function1) {
        m.checkNotNullParameter(coroutineContext$Key, "baseKey");
        m.checkNotNullParameter(function1, "safeCast");
        this.f3585b = function1;
        this.a = coroutineContext$Key instanceof b ? (CoroutineContext$Key<B>) ((b) coroutineContext$Key).a : coroutineContext$Key;
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext$Key<?> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        return coroutineContext$Key == this || this.a == coroutineContext$Key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext$Element tryCast$kotlin_stdlib(CoroutineContext$Element coroutineContext$Element) {
        m.checkNotNullParameter(coroutineContext$Element, "element");
        return (CoroutineContext$Element) this.f3585b.invoke(coroutineContext$Element);
    }
}
