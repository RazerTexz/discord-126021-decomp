package b.c.a.w.b;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path$Op;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: MergePathsContent.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class l implements m, j {
    public final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f385b = new Path();
    public final Path c = new Path();
    public final List<m> d = new ArrayList();
    public final b.c.a.y.l.g e;

    public l(b.c.a.y.l.g gVar) {
        this.e = gVar;
    }

    @TargetApi(19)
    public final void a(Path$Op path$Op) {
        Matrix matrixE;
        Matrix matrixE2;
        this.f385b.reset();
        this.a.reset();
        for (int size = this.d.size() - 1; size >= 1; size--) {
            m mVar = this.d.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> listE = dVar.e();
                for (int size2 = listE.size() - 1; size2 >= 0; size2--) {
                    Path path = listE.get(size2).getPath();
                    b.c.a.w.c.o oVar = dVar.k;
                    if (oVar != null) {
                        matrixE2 = oVar.e();
                    } else {
                        dVar.c.reset();
                        matrixE2 = dVar.c;
                    }
                    path.transform(matrixE2);
                    this.f385b.addPath(path);
                }
            } else {
                this.f385b.addPath(mVar.getPath());
            }
        }
        m mVar2 = this.d.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> listE2 = dVar2.e();
            for (int i = 0; i < listE2.size(); i++) {
                Path path2 = listE2.get(i).getPath();
                b.c.a.w.c.o oVar2 = dVar2.k;
                if (oVar2 != null) {
                    matrixE = oVar2.e();
                } else {
                    dVar2.c.reset();
                    matrixE = dVar2.c;
                }
                path2.transform(matrixE);
                this.a.addPath(path2);
            }
        } else {
            this.a.set(mVar2.getPath());
        }
        this.c.op(this.a, this.f385b, path$Op);
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < this.d.size(); i++) {
            this.d.get(i).b(list, list2);
        }
    }

    @Override // b.c.a.w.b.j
    public void e(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVarPrevious = listIterator.previous();
            if (cVarPrevious instanceof m) {
                this.d.add((m) cVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // b.c.a.w.b.m
    public Path getPath() {
        this.c.reset();
        b.c.a.y.l.g gVar = this.e;
        if (gVar.c) {
            return this.c;
        }
        int iOrdinal = gVar.f420b.ordinal();
        if (iOrdinal == 0) {
            for (int i = 0; i < this.d.size(); i++) {
                this.c.addPath(this.d.get(i).getPath());
            }
        } else if (iOrdinal == 1) {
            a(Path$Op.UNION);
        } else if (iOrdinal == 2) {
            a(Path$Op.REVERSE_DIFFERENCE);
        } else if (iOrdinal == 3) {
            a(Path$Op.INTERSECT);
        } else if (iOrdinal == 4) {
            a(Path$Op.XOR);
        }
        return this.c;
    }
}
