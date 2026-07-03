package p007b.p225i.p226a.p288f.p313h.p325l;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/* JADX INFO: renamed from: b.i.a.f.h.l.j3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3707j3 extends AbstractC3651f3 {

    /* JADX INFO: renamed from: a */
    public final C3693i3 f10031a = new C3693i3();

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3651f3
    /* JADX INFO: renamed from: a */
    public final void mo4876a(Throwable th, Throwable th2) {
        List<Throwable> listPutIfAbsent;
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
        C3693i3 c3693i3 = this.f10031a;
        for (Reference<? extends Throwable> referencePoll = c3693i3.f10008b.poll(); referencePoll != null; referencePoll = c3693i3.f10008b.poll()) {
            c3693i3.f10007a.remove(referencePoll);
        }
        List<Throwable> vector = c3693i3.f10007a.get(new C3679h3(th, null));
        if (vector == null && (listPutIfAbsent = c3693i3.f10007a.putIfAbsent(new C3679h3(th, c3693i3.f10008b), (vector = new Vector<>(2)))) != null) {
            vector = listPutIfAbsent;
        }
        vector.add(th2);
    }
}
