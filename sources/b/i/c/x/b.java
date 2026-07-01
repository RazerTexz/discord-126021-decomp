package b.i.c.x;

import java.util.Set;

/* JADX INFO: compiled from: DefaultUserAgentPublisher.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements b.i.c.l.f {
    public static final b a = new b();

    @Override // b.i.c.l.f
    public Object a(b.i.c.l.e eVar) {
        Set setD = eVar.d(e.class);
        d dVar = d.a;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = d.a;
                if (dVar == null) {
                    dVar = new d();
                    d.a = dVar;
                }
            }
        }
        return new c(setD, dVar);
    }
}
