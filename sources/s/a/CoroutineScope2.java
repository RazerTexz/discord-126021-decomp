package s.a;

import d0.w.CoroutineContextImpl4;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: s.a.x0, reason: use source file name */
/* JADX INFO: compiled from: CoroutineScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineScope2 implements CoroutineScope {
    public static final CoroutineScope2 j = new CoroutineScope2();

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return CoroutineContextImpl4.j;
    }
}
