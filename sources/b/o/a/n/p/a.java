package b.o.a.n.p;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: BaseLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class a extends b.o.a.n.o.e {
    @Override // b.o.a.n.o.e
    public final void j(@NonNull b.o.a.n.o.c cVar) {
        this.c = cVar;
        boolean zN = n(cVar);
        if (!m(cVar) || zN) {
            l(Integer.MAX_VALUE);
        } else {
            o(cVar);
        }
    }

    public abstract boolean m(@NonNull b.o.a.n.o.c cVar);

    public abstract boolean n(@NonNull b.o.a.n.o.c cVar);

    public abstract void o(@NonNull b.o.a.n.o.c cVar);
}
