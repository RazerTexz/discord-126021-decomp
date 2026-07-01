package s.a.a;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;
import s.a.v1;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final t a = new t("ZERO");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function2<Object, CoroutineContext$Element, Object> f3825b = a$b.j;
    public static final Function2<v1<?>, CoroutineContext$Element, v1<?>> c = a$c.j;
    public static final Function2<x, CoroutineContext$Element, x> d = a$a.k;
    public static final Function2<x, CoroutineContext$Element, x> e = a$a.j;

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof x) {
            ((x) obj).f3832b = 0;
            coroutineContext.fold(obj, e);
        } else {
            Object objFold = coroutineContext.fold(null, c);
            Objects.requireNonNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((v1) objFold).y(coroutineContext, obj);
        }
    }

    public static final Object b(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = coroutineContext.fold(0, f3825b);
            d0.z.d.m.checkNotNull(obj);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new x(coroutineContext, ((Number) obj).intValue()), d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((v1) obj).C(coroutineContext);
    }
}
