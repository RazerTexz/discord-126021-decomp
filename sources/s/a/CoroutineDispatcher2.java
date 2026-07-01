package s.a;

import d0.z.d.Lambda;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: renamed from: s.a.a0, reason: use source file name */
/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineDispatcher2 extends Lambda implements Function1<CoroutineContext.Element, CoroutineDispatcher> {
    public static final CoroutineDispatcher2 j = new CoroutineDispatcher2();

    public CoroutineDispatcher2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public CoroutineDispatcher invoke(CoroutineContext.Element element) {
        CoroutineContext.Element element2 = element;
        if (!(element2 instanceof CoroutineDispatcher)) {
            element2 = null;
        }
        return (CoroutineDispatcher) element2;
    }
}
