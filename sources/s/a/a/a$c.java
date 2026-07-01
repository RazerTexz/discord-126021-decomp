package s.a.a;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;
import s.a.v1;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c extends d0.z.d.o implements Function2<v1<?>, CoroutineContext$Element, v1<?>> {
    public static final a$c j = new a$c();

    public a$c() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public v1<?> invoke(v1<?> v1Var, CoroutineContext$Element coroutineContext$Element) {
        v1<?> v1Var2 = v1Var;
        CoroutineContext$Element coroutineContext$Element2 = coroutineContext$Element;
        if (v1Var2 != null) {
            return v1Var2;
        }
        if (!(coroutineContext$Element2 instanceof v1)) {
            coroutineContext$Element2 = null;
        }
        return (v1) coroutineContext$Element2;
    }
}
