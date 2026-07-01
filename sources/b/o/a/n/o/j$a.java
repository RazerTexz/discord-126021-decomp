package b.o.a.n.o;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: TogetherAction.java */
/* JADX INFO: loaded from: classes3.dex */
public class j$a implements b {
    public final /* synthetic */ j a;

    public j$a(j jVar) {
        this.a = jVar;
    }

    @Override // b.o.a.n.o.b
    public void a(@NonNull a aVar, int i) {
        if (i == Integer.MAX_VALUE) {
            this.a.f.remove(aVar);
        }
        if (this.a.f.isEmpty()) {
            this.a.l(Integer.MAX_VALUE);
        }
    }
}
