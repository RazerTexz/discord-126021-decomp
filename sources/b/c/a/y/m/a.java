package b.c.a.y.m;

import b.c.a.w.c.a$b;

/* JADX INFO: compiled from: BaseLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements a$b {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        b bVar = this.a;
        boolean z2 = bVar.q.j() == 1.0f;
        if (z2 != bVar.w) {
            bVar.w = z2;
            bVar.n.invalidateSelf();
        }
    }
}
