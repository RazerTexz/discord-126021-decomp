package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: compiled from: RepeaterContent.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements e, m, j, b.c.a.w.c.a$b, k {
    public final Matrix a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f388b = new Path();
    public final b.c.a.j c;
    public final b.c.a.y.m.b d;
    public final String e;
    public final boolean f;
    public final b.c.a.w.c.a<Float, Float> g;
    public final b.c.a.w.c.a<Float, Float> h;
    public final b.c.a.w.c.o i;
    public d j;

    public p(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.j jVar2) {
        this.c = jVar;
        this.d = bVar;
        this.e = jVar2.a;
        this.f = jVar2.e;
        b.c.a.w.c.a<Float, Float> aVarA = jVar2.f423b.a();
        this.g = aVarA;
        bVar.e(aVarA);
        aVarA.a.add(this);
        b.c.a.w.c.a<Float, Float> aVarA2 = jVar2.c.a();
        this.h = aVarA2;
        bVar.e(aVarA2);
        aVarA2.a.add(this);
        b.c.a.y.k.l lVar = jVar2.d;
        Objects.requireNonNull(lVar);
        b.c.a.w.c.o oVar = new b.c.a.w.c.o(lVar);
        this.i = oVar;
        oVar.a(bVar);
        oVar.b(this);
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        this.c.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        this.j.b(list, list2);
    }

    @Override // b.c.a.y.g
    public void c(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        b.c.a.b0.f.f(fVar, i, list, fVar2, this);
    }

    @Override // b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.j.d(rectF, matrix, z2);
    }

    @Override // b.c.a.w.b.j
    public void e(ListIterator<c> listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.j = new d(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // b.c.a.w.b.e
    public void f(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.g.e().floatValue();
        float fFloatValue2 = this.h.e().floatValue();
        float fFloatValue3 = this.i.m.e().floatValue() / 100.0f;
        float fFloatValue4 = this.i.n.e().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = i2;
            this.a.preConcat(this.i.f(f + fFloatValue2));
            this.j.f(canvas, this.a, (int) (b.c.a.b0.f.e(fFloatValue3, fFloatValue4, f / fFloatValue) * i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        if (this.i.c(t, cVar)) {
            return;
        }
        if (t == b.c.a.o.q) {
            b.c.a.w.c.a<Float, Float> aVar = this.g;
            b.c.a.c0.c<Float> cVar2 = aVar.e;
            aVar.e = cVar;
        } else if (t == b.c.a.o.r) {
            b.c.a.w.c.a<Float, Float> aVar2 = this.h;
            b.c.a.c0.c<Float> cVar3 = aVar2.e;
            aVar2.e = cVar;
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.e;
    }

    @Override // b.c.a.w.b.m
    public Path getPath() {
        Path path = this.j.getPath();
        this.f388b.reset();
        float fFloatValue = this.g.e().floatValue();
        float fFloatValue2 = this.h.e().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.a.set(this.i.f(i + fFloatValue2));
            this.f388b.addPath(path, this.a);
        }
        return this.f388b;
    }
}
