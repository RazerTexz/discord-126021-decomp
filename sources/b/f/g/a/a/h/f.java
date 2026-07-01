package b.f.g.a.a.h;

import android.graphics.Rect;
import b.f.d.d.l;
import com.facebook.common.internal.Supplier;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ImagePerfMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements g {
    public final b.f.g.a.a.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.d.k.b f485b;
    public final h c = new h();
    public final Supplier<Boolean> d;
    public c e;
    public b f;
    public b.f.g.a.a.h.i.c g;
    public b.f.g.a.a.h.i.a h;
    public b.f.j.k.c i;
    public List<e> j;
    public boolean k;

    public f(b.f.d.k.b bVar, b.f.g.a.a.c cVar, Supplier<Boolean> supplier) {
        this.f485b = bVar;
        this.a = cVar;
        this.d = supplier;
    }

    public void a(h hVar, int i) {
        List<e> list;
        if (!this.k || (list = this.j) == null || list.isEmpty()) {
            return;
        }
        d dVarC = hVar.c();
        Iterator<e> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().b(dVarC, i);
        }
    }

    public void b(h hVar, int i) {
        List<e> list;
        b.f.g.h.a aVar;
        hVar.v = i;
        if (!this.k || (list = this.j) == null || list.isEmpty()) {
            return;
        }
        if (i == 3 && (aVar = this.a.k) != null && aVar.e() != null) {
            Rect bounds = aVar.e().getBounds();
            this.c.f487s = bounds.width();
            this.c.t = bounds.height();
        }
        d dVarC = hVar.c();
        Iterator<e> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(dVarC, i);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void c(boolean z2) {
        this.k = z2;
        if (!z2) {
            b bVar = this.f;
            if (bVar != null) {
                b.f.g.a.a.c cVar = this.a;
                synchronized (cVar) {
                    b bVar2 = cVar.G;
                    if (bVar2 instanceof a) {
                        a aVar = (a) bVar2;
                        synchronized (aVar) {
                            aVar.a.remove(bVar);
                        }
                    } else if (bVar2 == bVar) {
                        cVar.G = null;
                    }
                }
            }
            b.f.g.a.a.h.i.a aVar2 = this.h;
            if (aVar2 != null) {
                b.f.h.b.a.c<INFO> cVar2 = this.a.j;
                synchronized (cVar2) {
                    int iIndexOf = cVar2.j.indexOf(aVar2);
                    if (iIndexOf != -1) {
                        cVar2.j.remove(iIndexOf);
                    }
                }
            }
            b.f.j.k.c cVar3 = this.i;
            if (cVar3 != null) {
                this.a.L(cVar3);
                return;
            }
            return;
        }
        if (this.h == null) {
            this.h = new b.f.g.a.a.h.i.a(this.f485b, this.c, this, this.d, l.a);
        }
        if (this.g == null) {
            this.g = new b.f.g.a.a.h.i.c(this.f485b, this.c);
        }
        if (this.f == null) {
            this.f = new b.f.g.a.a.h.i.b(this.c, this);
        }
        c cVar4 = this.e;
        if (cVar4 == null) {
            this.e = new c(this.a.m, this.f);
        } else {
            cVar4.a = this.a.m;
        }
        if (this.i == null) {
            this.i = new b.f.j.k.c(this.g, this.e);
        }
        b bVar3 = this.f;
        if (bVar3 != null) {
            this.a.F(bVar3);
        }
        b.f.g.a.a.h.i.a aVar3 = this.h;
        if (aVar3 != null) {
            b.f.h.b.a.c<INFO> cVar5 = this.a.j;
            synchronized (cVar5) {
                cVar5.j.add(aVar3);
            }
        }
        b.f.j.k.c cVar6 = this.i;
        if (cVar6 != null) {
            this.a.G(cVar6);
        }
    }
}
