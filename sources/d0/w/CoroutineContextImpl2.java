package d0.w;

import d0.z.d.Intrinsics3;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.w.b, reason: use source file name */
/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CoroutineContextImpl2<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {
    public final CoroutineContext.Key<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<CoroutineContext.Element, E> f3585b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$Key<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public CoroutineContextImpl2(CoroutineContext.Key<B> key, Function1<? super CoroutineContext.Element, ? extends E> function1) {
        Intrinsics3.checkNotNullParameter(key, "baseKey");
        Intrinsics3.checkNotNullParameter(function1, "safeCast");
        this.f3585b = function1;
        this.a = key instanceof CoroutineContextImpl2 ? (CoroutineContext.Key<B>) ((CoroutineContextImpl2) key).a : key;
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext.Key<?> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        return key == this || this.a == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext.Element tryCast$kotlin_stdlib(CoroutineContext.Element element) {
        Intrinsics3.checkNotNullParameter(element, "element");
        return (CoroutineContext.Element) this.f3585b.invoke(element);
    }
}
