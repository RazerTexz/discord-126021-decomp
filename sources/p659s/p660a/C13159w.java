package p659s.p660a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: s.a.w */
/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13159w {

    /* JADX INFO: renamed from: a */
    public static final AtomicIntegerFieldUpdater f27912a = AtomicIntegerFieldUpdater.newUpdater(C13159w.class, "_handled");
    public volatile int _handled;

    /* JADX INFO: renamed from: b */
    public final Throwable f27913b;

    public C13159w(Throwable th, boolean z2) {
        this.f27913b = th;
        this._handled = z2 ? 1 : 0;
    }

    public String toString() {
        return getClass().getSimpleName() + '[' + this.f27913b + ']';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public C13159w(Throwable th, boolean z2, int i) {
        ?? r2 = (i & 2) != 0 ? 0 : z2;
        this.f27913b = th;
        this._handled = r2;
    }
}
