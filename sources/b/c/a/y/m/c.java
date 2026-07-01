package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import b.c.a.j;
import b.c.a.o;
import b.c.a.w.c.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CompositionLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public final RectF A;
    public Paint B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public b.c.a.w.c.a<Float, Float> f432x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<b> f433y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f434z;

    public c(j jVar, e eVar, List<e> list, b.c.a.d dVar) {
        int i;
        b bVar;
        b cVar;
        super(jVar, eVar);
        this.f433y = new ArrayList();
        this.f434z = new RectF();
        this.A = new RectF();
        this.B = new Paint();
        b.c.a.y.k.b bVar2 = eVar.f439s;
        if (bVar2 != null) {
            b.c.a.w.c.a<Float, Float> aVarA = bVar2.a();
            this.f432x = aVarA;
            e(aVarA);
            this.f432x.a.add(this);
        } else {
            this.f432x = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.i.size());
        int size = list.size() - 1;
        b bVar3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            e eVar2 = list.get(size);
            int iOrdinal = eVar2.e.ordinal();
            if (iOrdinal == 0) {
                cVar = new c(jVar, eVar2, dVar.c.get(eVar2.g), dVar);
            } else if (iOrdinal == 1) {
                cVar = new h(jVar, eVar2);
            } else if (iOrdinal == 2) {
                cVar = new d(jVar, eVar2);
            } else if (iOrdinal == 3) {
                cVar = new f(jVar, eVar2);
            } else if (iOrdinal == 4) {
                cVar = new g(jVar, eVar2);
            } else if (iOrdinal != 5) {
                StringBuilder sbU = b.d.b.a.a.U("Unknown layer type ");
                sbU.append(eVar2.e);
                b.c.a.b0.c.b(sbU.toString());
                cVar = null;
            } else {
                cVar = new i(jVar, eVar2);
            }
            if (cVar != null) {
                longSparseArray.put(cVar.o.d, cVar);
                if (bVar3 != null) {
                    bVar3.r = cVar;
                    bVar3 = null;
                } else {
                    this.f433y.add(0, cVar);
                    int iH = b.c.a.y.b.h(eVar2.u);
                    if (iH == 1 || iH == 2) {
                        bVar3 = cVar;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            b bVar4 = (b) longSparseArray.get(longSparseArray.keyAt(i));
            if (bVar4 != null && (bVar = (b) longSparseArray.get(bVar4.o.f)) != null) {
                bVar4.f431s = bVar;
            }
        }
    }

    @Override // b.c.a.y.m.b, b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        for (int size = this.f433y.size() - 1; size >= 0; size--) {
            this.f434z.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f433y.get(size).d(this.f434z, this.m, true);
            rectF.union(this.f434z);
        }
    }

    @Override // b.c.a.y.m.b, b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        this.v.c(t, cVar);
        if (t == o.A) {
            if (cVar == null) {
                b.c.a.w.c.a<Float, Float> aVar = this.f432x;
                if (aVar != null) {
                    aVar.i(null);
                    return;
                }
                return;
            }
            p pVar = new p(cVar, null);
            this.f432x = pVar;
            pVar.a.add(this);
            e(this.f432x);
        }
    }

    @Override // b.c.a.y.m.b
    public void j(Canvas canvas, Matrix matrix, int i) {
        RectF rectF = this.A;
        e eVar = this.o;
        rectF.set(0.0f, 0.0f, eVar.o, eVar.p);
        matrix.mapRect(this.A);
        boolean z2 = this.n.A && this.f433y.size() > 1 && i != 255;
        if (z2) {
            this.B.setAlpha(i);
            b.c.a.b0.g.f(canvas, this.A, this.B, 31);
        } else {
            canvas.save();
        }
        if (z2) {
            i = 255;
        }
        for (int size = this.f433y.size() - 1; size >= 0; size--) {
            if (!this.A.isEmpty() ? canvas.clipRect(this.A) : true) {
                this.f433y.get(size).f(canvas, matrix, i);
            }
        }
        canvas.restore();
        b.c.a.c.a("CompositionLayer#draw");
    }

    @Override // b.c.a.y.m.b
    public void n(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        for (int i2 = 0; i2 < this.f433y.size(); i2++) {
            this.f433y.get(i2).c(fVar, i, list, fVar2);
        }
    }

    @Override // b.c.a.y.m.b
    public void o(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.o(f);
        if (this.f432x != null) {
            f = ((this.f432x.e().floatValue() * this.o.f438b.m) - this.o.f438b.k) / (this.n.k.c() + 0.01f);
        }
        if (this.f432x == null) {
            e eVar = this.o;
            f -= eVar.n / eVar.f438b.c();
        }
        float f2 = this.o.m;
        if (f2 != 0.0f) {
            f /= f2;
        }
        int size = this.f433y.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                this.f433y.get(size).o(f);
            }
        }
    }
}
