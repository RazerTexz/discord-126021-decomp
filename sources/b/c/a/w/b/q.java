package b.c.a.w.b;

import android.graphics.Path;
import android.graphics.Path$FillType;
import java.util.List;

/* JADX INFO: compiled from: ShapeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class q implements m, b.c.a.w.c.a$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f389b;
    public final b.c.a.j c;
    public final b.c.a.w.c.a<?, Path> d;
    public boolean e;
    public final Path a = new Path();
    public b f = new b();

    public q(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.n nVar) {
        this.f389b = nVar.d;
        this.c = jVar;
        b.c.a.w.c.a<b.c.a.y.l.k, Path> aVarA = nVar.c.a();
        this.d = aVarA;
        bVar.e(aVarA);
        aVarA.a.add(this);
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        this.e = false;
        this.c.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c == 1) {
                    this.f.a.add(sVar);
                    sVar.f391b.add(this);
                }
            }
        }
    }

    @Override // b.c.a.w.b.m
    public Path getPath() {
        if (this.e) {
            return this.a;
        }
        this.a.reset();
        if (this.f389b) {
            this.e = true;
            return this.a;
        }
        this.a.set(this.d.e());
        this.a.setFillType(Path$FillType.EVEN_ODD);
        this.f.a(this.a);
        this.e = true;
        return this.a;
    }
}
