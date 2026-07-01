package d0.w;

import d0.z.d.m;
import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;

/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a {
    public static <E extends CoroutineContext$Element> E get(d dVar, CoroutineContext$Key<E> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        if (!(coroutineContext$Key instanceof b)) {
            int i = d.e;
            if (d$b.a != coroutineContext$Key) {
                return null;
            }
            Objects.requireNonNull(dVar, "null cannot be cast to non-null type E");
            return dVar;
        }
        b bVar = (b) coroutineContext$Key;
        if (!bVar.isSubKey$kotlin_stdlib(dVar.getKey())) {
            return null;
        }
        E e = (E) bVar.tryCast$kotlin_stdlib(dVar);
        if (e instanceof CoroutineContext$Element) {
            return e;
        }
        return null;
    }

    public static CoroutineContext minusKey(d dVar, CoroutineContext$Key<?> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        if (coroutineContext$Key instanceof b) {
            b bVar = (b) coroutineContext$Key;
            return (!bVar.isSubKey$kotlin_stdlib(dVar.getKey()) || bVar.tryCast$kotlin_stdlib(dVar) == null) ? dVar : f.j;
        }
        int i = d.e;
        return d$b.a == coroutineContext$Key ? f.j : dVar;
    }
}
