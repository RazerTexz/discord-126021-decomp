package kotlin.coroutines;

import d0.w.f;
import d0.z.d.m;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineContext$a {
    public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        m.checkNotNullParameter(coroutineContext2, "context");
        return coroutineContext2 == f.j ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, CoroutineContext$a$a.j);
    }
}
