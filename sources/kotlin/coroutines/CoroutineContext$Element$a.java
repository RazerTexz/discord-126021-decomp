package kotlin.coroutines;

import d0.w.f;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineContext$Element$a {
    public static <R> R fold(CoroutineContext$Element coroutineContext$Element, R r, Function2<? super R, ? super CoroutineContext$Element, ? extends R> function2) {
        m.checkNotNullParameter(function2, "operation");
        return function2.invoke(r, coroutineContext$Element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E extends CoroutineContext$Element> E get(CoroutineContext$Element coroutineContext$Element, CoroutineContext$Key<E> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        if (m.areEqual(coroutineContext$Element.getKey(), coroutineContext$Key)) {
            return coroutineContext$Element;
        }
        return null;
    }

    public static CoroutineContext minusKey(CoroutineContext$Element coroutineContext$Element, CoroutineContext$Key<?> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        return m.areEqual(coroutineContext$Element.getKey(), coroutineContext$Key) ? f.j : coroutineContext$Element;
    }

    public static CoroutineContext plus(CoroutineContext$Element coroutineContext$Element, CoroutineContext coroutineContext) {
        m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext$a.plus(coroutineContext$Element, coroutineContext);
    }
}
