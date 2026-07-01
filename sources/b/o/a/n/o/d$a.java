package b.o.a.n.o;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: ActionWrapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a implements b {
    public final /* synthetic */ d a;

    public d$a(d dVar) {
        this.a = dVar;
    }

    @Override // b.o.a.n.o.b
    public void a(@NonNull a aVar, int i) {
        this.a.l(i);
        if (i == Integer.MAX_VALUE) {
            ((e) aVar).a.remove(this);
        }
    }
}
