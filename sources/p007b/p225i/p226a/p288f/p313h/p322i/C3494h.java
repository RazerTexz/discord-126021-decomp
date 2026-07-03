package p007b.p225i.p226a.p288f.p313h.p322i;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/* JADX INFO: renamed from: b.i.a.f.h.i.h */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3494h extends AbstractC3493g {

    /* JADX INFO: renamed from: a */
    public final C3492f f9659a = new C3492f();

    @Override // p007b.p225i.p226a.p288f.p313h.p322i.AbstractC3493g
    /* JADX INFO: renamed from: a */
    public final void mo4413a(Throwable th, Throwable th2) {
        List<Throwable> listPutIfAbsent;
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
        C3492f c3492f = this.f9659a;
        for (Reference<? extends Throwable> referencePoll = c3492f.f9658b.poll(); referencePoll != null; referencePoll = c3492f.f9658b.poll()) {
            c3492f.f9657a.remove(referencePoll);
        }
        List<Throwable> vector = c3492f.f9657a.get(new C3495i(th, null));
        if (vector == null && (listPutIfAbsent = c3492f.f9657a.putIfAbsent(new C3495i(th, c3492f.f9658b), (vector = new Vector<>(2)))) != null) {
            vector = listPutIfAbsent;
        }
        vector.add(th2);
    }
}
