package p659s.p660a;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: s.a.n */
/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13132n extends C13159w {

    /* JADX INFO: renamed from: c */
    public static final AtomicIntegerFieldUpdater f27875c = AtomicIntegerFieldUpdater.newUpdater(C13132n.class, "_resumed");
    public volatile int _resumed;

    public C13132n(Continuation<?> continuation, Throwable th, boolean z2) {
        if (th == null) {
            th = new CancellationException("Continuation " + continuation + " was cancelled normally");
        }
        super(th, z2);
        this._resumed = 0;
    }
}
