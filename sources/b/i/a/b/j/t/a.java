package b.i.a.b.j.t;

import b.i.a.b.h;
import b.i.a.b.j.i;
import b.i.a.b.j.q.m;
import java.util.logging.Logger;

/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final c j;
    public final i k;
    public final h l;
    public final b.i.a.b.j.f m;

    public a(c cVar, i iVar, h hVar, b.i.a.b.j.f fVar) {
        this.j = cVar;
        this.k = iVar;
        this.l = hVar;
        this.m = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.j;
        i iVar = this.k;
        h hVar = this.l;
        b.i.a.b.j.f fVar = this.m;
        Logger logger = c.a;
        try {
            m mVar = cVar.d.get(iVar.b());
            if (mVar == null) {
                String str = String.format("Transport backend '%s' is not registered", iVar.b());
                c.a.warning(str);
                hVar.a(new IllegalArgumentException(str));
            } else {
                cVar.f.a(new b(cVar, iVar, mVar.b(fVar)));
                hVar.a(null);
            }
        } catch (Exception e) {
            Logger logger2 = c.a;
            StringBuilder sbU = b.d.b.a.a.U("Error scheduling event ");
            sbU.append(e.getMessage());
            logger2.warning(sbU.toString());
            hVar.a(e);
        }
    }
}
