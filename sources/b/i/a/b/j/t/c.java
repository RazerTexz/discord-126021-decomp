package b.i.a.b.j.t;

import b.i.a.b.h;
import b.i.a.b.j.i;
import b.i.a.b.j.n;
import b.i.a.b.j.t.h.r;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements e {
    public static final Logger a = Logger.getLogger(n.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f781b;
    public final Executor c;
    public final b.i.a.b.j.q.e d;
    public final b.i.a.b.j.t.i.c e;
    public final b.i.a.b.j.u.a f;

    public c(Executor executor, b.i.a.b.j.q.e eVar, r rVar, b.i.a.b.j.t.i.c cVar, b.i.a.b.j.u.a aVar) {
        this.c = executor;
        this.d = eVar;
        this.f781b = rVar;
        this.e = cVar;
        this.f = aVar;
    }

    @Override // b.i.a.b.j.t.e
    public void a(i iVar, b.i.a.b.j.f fVar, h hVar) {
        this.c.execute(new a(this, iVar, hVar, fVar));
    }
}
