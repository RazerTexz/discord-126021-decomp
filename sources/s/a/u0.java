package s.a;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends d0.z.d.o implements Function1<CoroutineContext$Element, ExecutorCoroutineDispatcher> {
    public static final u0 j = new u0();

    public u0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public ExecutorCoroutineDispatcher invoke(CoroutineContext$Element coroutineContext$Element) {
        CoroutineContext$Element coroutineContext$Element2 = coroutineContext$Element;
        if (!(coroutineContext$Element2 instanceof ExecutorCoroutineDispatcher)) {
            coroutineContext$Element2 = null;
        }
        return (ExecutorCoroutineDispatcher) coroutineContext$Element2;
    }
}
