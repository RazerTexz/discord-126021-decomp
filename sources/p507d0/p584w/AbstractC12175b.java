package p507d0.p584w;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.b */
/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12175b<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {

    /* JADX INFO: renamed from: a */
    public final CoroutineContext.Key<?> f25232a;

    /* JADX INFO: renamed from: b */
    public final Function1<CoroutineContext.Element, E> f25233b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$Key<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public AbstractC12175b(CoroutineContext.Key<B> key, Function1<? super CoroutineContext.Element, ? extends E> function1) {
        C12238m.checkNotNullParameter(key, "baseKey");
        C12238m.checkNotNullParameter(function1, "safeCast");
        this.f25233b = function1;
        this.f25232a = key instanceof AbstractC12175b ? (CoroutineContext.Key<B>) ((AbstractC12175b) key).f25232a : key;
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext.Key<?> key) {
        C12238m.checkNotNullParameter(key, "key");
        return key == this || this.f25232a == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext.Element tryCast$kotlin_stdlib(CoroutineContext.Element element) {
        C12238m.checkNotNullParameter(element, "element");
        return (CoroutineContext.Element) this.f25233b.invoke(element);
    }
}
