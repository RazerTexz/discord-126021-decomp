package b.i.a.f.h.i;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends g {
    public final f a = new f();

    @Override // b.i.a.f.h.i.g
    public final void a(Throwable th, Throwable th2) {
        List<Throwable> listPutIfAbsent;
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
        f fVar = this.a;
        for (Reference<? extends Throwable> referencePoll = fVar.f1408b.poll(); referencePoll != null; referencePoll = fVar.f1408b.poll()) {
            fVar.a.remove(referencePoll);
        }
        List<Throwable> vector = fVar.a.get(new i(th, null));
        if (vector == null && (listPutIfAbsent = fVar.a.putIfAbsent(new i(th, fVar.f1408b), (vector = new Vector<>(2)))) != null) {
            vector = listPutIfAbsent;
        }
        vector.add(th2);
    }
}
