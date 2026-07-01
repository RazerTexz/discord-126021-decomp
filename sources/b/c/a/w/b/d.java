package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ContentGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements e, m, b.c.a.w.c.a$b, b.c.a.y.g {
    public Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f378b;
    public final Matrix c;
    public final Path d;
    public final RectF e;
    public final String f;
    public final boolean g;
    public final List<c> h;
    public final b.c.a.j i;

    @Nullable
    public List<m> j;

    @Nullable
    public b.c.a.w.c.o k;

    public d(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.m mVar) {
        b.c.a.y.k.l lVar;
        String str = mVar.a;
        boolean z2 = mVar.c;
        List<b.c.a.y.l.b> list = mVar.f426b;
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            c cVarA = list.get(i).a(jVar, bVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        List<b.c.a.y.l.b> list2 = mVar.f426b;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            b.c.a.y.l.b bVar2 = list2.get(i2);
            if (bVar2 instanceof b.c.a.y.k.l) {
                lVar = (b.c.a.y.k.l) bVar2;
                this(jVar, bVar, str, z2, arrayList, lVar);
            }
        }
        lVar = null;
        this(jVar, bVar, str, z2, arrayList, lVar);
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        this.i.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(this.h.size() + list.size());
        arrayList.addAll(list);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            c cVar = this.h.get(size);
            cVar.b(arrayList, this.h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // b.c.a.y.g
    public void c(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        if (fVar.e(this.f, i)) {
            if (!"__container".equals(this.f)) {
                fVar2 = fVar2.a(this.f);
                if (fVar.c(this.f, i)) {
                    list.add(fVar2.g(this));
                }
            }
            if (fVar.f(this.f, i)) {
                int iD = fVar.d(this.f, i) + i;
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    c cVar = this.h.get(i2);
                    if (cVar instanceof b.c.a.y.g) {
                        ((b.c.a.y.g) cVar).c(fVar, iD, list, fVar2);
                    }
                }
            }
        }
    }

    @Override // b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.c.set(matrix);
        b.c.a.w.c.o oVar = this.k;
        if (oVar != null) {
            this.c.preConcat(oVar.e());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            c cVar = this.h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).d(this.e, this.c, z2);
                rectF.union(this.e);
            }
        }
    }

    public List<m> e() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i = 0; i < this.h.size(); i++) {
                c cVar = this.h.get(i);
                if (cVar instanceof m) {
                    this.j.add((m) cVar);
                }
            }
        }
        return this.j;
    }

    @Override // b.c.a.w.b.e
    public void f(Canvas canvas, Matrix matrix, int i) {
        boolean z2;
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        b.c.a.w.c.o oVar = this.k;
        if (oVar != null) {
            this.c.preConcat(oVar.e());
            b.c.a.w.c.a<Integer, Integer> aVar = this.k.j;
            i = (int) (((((aVar == null ? 100 : aVar.e().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z3 = false;
        if (this.i.A) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= this.h.size()) {
                    z2 = false;
                    break;
                } else {
                    if ((this.h.get(i2) instanceof e) && (i3 = i3 + 1) >= 2) {
                        z2 = true;
                        break;
                    }
                    i2++;
                }
            }
            if (z2 && i != 255) {
                z3 = true;
            }
        }
        if (z3) {
            this.f378b.set(0.0f, 0.0f, 0.0f, 0.0f);
            d(this.f378b, this.c, true);
            this.a.setAlpha(i);
            b.c.a.b0.g.f(canvas, this.f378b, this.a, 31);
        }
        if (z3) {
            i = 255;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            c cVar = this.h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).f(canvas, this.c, i);
            }
        }
        if (z3) {
            canvas.restore();
        }
    }

    @Override // b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        b.c.a.w.c.o oVar = this.k;
        if (oVar != null) {
            oVar.c(t, cVar);
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.f;
    }

    @Override // b.c.a.w.b.m
    public Path getPath() {
        this.c.reset();
        b.c.a.w.c.o oVar = this.k;
        if (oVar != null) {
            this.c.set(oVar.e());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            c cVar = this.h.get(size);
            if (cVar instanceof m) {
                this.d.addPath(((m) cVar).getPath(), this.c);
            }
        }
        return this.d;
    }

    public d(b.c.a.j jVar, b.c.a.y.m.b bVar, String str, boolean z2, List<c> list, @Nullable b.c.a.y.k.l lVar) {
        this.a = new b.c.a.w.a();
        this.f378b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.i = jVar;
        this.g = z2;
        this.h = list;
        if (lVar != null) {
            b.c.a.w.c.o oVar = new b.c.a.w.c.o(lVar);
            this.k = oVar;
            oVar.a(bVar);
            this.k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        int size2 = arrayList.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                return;
            } else {
                ((j) arrayList.get(size2)).e(list.listIterator(list.size()));
            }
        }
    }
}
