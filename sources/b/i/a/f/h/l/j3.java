package b.i.a.f.h.l;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j3 extends f3 {
    public final i3 a = new i3();

    @Override // b.i.a.f.h.l.f3
    public final void a(Throwable th, Throwable th2) {
        List<Throwable> listPutIfAbsent;
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
        i3 i3Var = this.a;
        for (Reference<? extends Throwable> referencePoll = i3Var.f1450b.poll(); referencePoll != null; referencePoll = i3Var.f1450b.poll()) {
            i3Var.a.remove(referencePoll);
        }
        List<Throwable> vector = i3Var.a.get(new h3(th, null));
        if (vector == null && (listPutIfAbsent = i3Var.a.putIfAbsent(new h3(th, i3Var.f1450b), (vector = new Vector<>(2)))) != null) {
            vector = listPutIfAbsent;
        }
        vector.add(th2);
    }
}
