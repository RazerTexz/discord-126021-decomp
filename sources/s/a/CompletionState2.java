package s.a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: s.a.w, reason: use source file name */
/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public class CompletionState2 {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(CompletionState2.class, "_handled");
    public volatile int _handled;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f3846b;

    public CompletionState2(Throwable th, boolean z2) {
        this.f3846b = th;
        this._handled = z2 ? 1 : 0;
    }

    public String toString() {
        return getClass().getSimpleName() + '[' + this.f3846b + ']';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public CompletionState2(Throwable th, boolean z2, int i) {
        ?? r2 = (i & 2) != 0 ? 0 : z2;
        this.f3846b = th;
        this._handled = r2;
    }
}
