package androidx.view;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CloseableCoroutineScope implements Closeable, CoroutineScope {
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(CoroutineContext coroutineContext) {
        C12238m.checkNotNullParameter(coroutineContext, "context");
        this.coroutineContext = coroutineContext;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C3404f.m4339s(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
