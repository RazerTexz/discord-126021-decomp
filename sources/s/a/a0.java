package s.a;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends d0.z.d.o implements Function1<CoroutineContext$Element, CoroutineDispatcher> {
    public static final a0 j = new a0();

    public a0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public CoroutineDispatcher invoke(CoroutineContext$Element coroutineContext$Element) {
        CoroutineContext$Element coroutineContext$Element2 = coroutineContext$Element;
        if (!(coroutineContext$Element2 instanceof CoroutineDispatcher)) {
            coroutineContext$Element2 = null;
        }
        return (CoroutineDispatcher) coroutineContext$Element2;
    }
}
