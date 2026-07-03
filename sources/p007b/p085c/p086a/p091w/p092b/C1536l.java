package p007b.p085c.p086a.p091w.p092b;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import p007b.p085c.p086a.p091w.p093c.C1558o;
import p007b.p085c.p086a.p095y.p097l.C1592g;

/* JADX INFO: renamed from: b.c.a.w.b.l */
/* JADX INFO: compiled from: MergePathsContent.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class C1536l implements InterfaceC1537m, InterfaceC1534j {

    /* JADX INFO: renamed from: a */
    public final Path f2540a = new Path();

    /* JADX INFO: renamed from: b */
    public final Path f2541b = new Path();

    /* JADX INFO: renamed from: c */
    public final Path f2542c = new Path();

    /* JADX INFO: renamed from: d */
    public final List<InterfaceC1537m> f2543d = new ArrayList();

    /* JADX INFO: renamed from: e */
    public final C1592g f2544e;

    public C1536l(C1592g c1592g) {
        this.f2544e = c1592g;
    }

    @TargetApi(19)
    /* JADX INFO: renamed from: a */
    public final void m722a(Path.Op op) {
        Matrix matrixM747e;
        Matrix matrixM747e2;
        this.f2541b.reset();
        this.f2540a.reset();
        for (int size = this.f2543d.size() - 1; size >= 1; size--) {
            InterfaceC1537m interfaceC1537m = this.f2543d.get(size);
            if (interfaceC1537m instanceof C1528d) {
                C1528d c1528d = (C1528d) interfaceC1537m;
                List<InterfaceC1537m> listM716e = c1528d.m716e();
                for (int size2 = listM716e.size() - 1; size2 >= 0; size2--) {
                    Path path = listM716e.get(size2).getPath();
                    C1558o c1558o = c1528d.f2492k;
                    if (c1558o != null) {
                        matrixM747e2 = c1558o.m747e();
                    } else {
                        c1528d.f2484c.reset();
                        matrixM747e2 = c1528d.f2484c;
                    }
                    path.transform(matrixM747e2);
                    this.f2541b.addPath(path);
                }
            } else {
                this.f2541b.addPath(interfaceC1537m.getPath());
            }
        }
        InterfaceC1537m interfaceC1537m2 = this.f2543d.get(0);
        if (interfaceC1537m2 instanceof C1528d) {
            C1528d c1528d2 = (C1528d) interfaceC1537m2;
            List<InterfaceC1537m> listM716e2 = c1528d2.m716e();
            for (int i = 0; i < listM716e2.size(); i++) {
                Path path2 = listM716e2.get(i).getPath();
                C1558o c1558o2 = c1528d2.f2492k;
                if (c1558o2 != null) {
                    matrixM747e = c1558o2.m747e();
                } else {
                    c1528d2.f2484c.reset();
                    matrixM747e = c1528d2.f2484c;
                }
                path2.transform(matrixM747e);
                this.f2540a.addPath(path2);
            }
        } else {
            this.f2540a.set(interfaceC1537m2.getPath());
        }
        this.f2542c.op(this.f2540a, this.f2541b, op);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        for (int i = 0; i < this.f2543d.size(); i++) {
            this.f2543d.get(i).mo710b(list, list2);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1534j
    /* JADX INFO: renamed from: e */
    public void mo721e(ListIterator<InterfaceC1527c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            InterfaceC1527c interfaceC1527cPrevious = listIterator.previous();
            if (interfaceC1527cPrevious instanceof InterfaceC1537m) {
                this.f2543d.add((InterfaceC1537m) interfaceC1527cPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1537m
    public Path getPath() {
        this.f2542c.reset();
        C1592g c1592g = this.f2544e;
        if (c1592g.f2773c) {
            return this.f2542c;
        }
        int iOrdinal = c1592g.f2772b.ordinal();
        if (iOrdinal == 0) {
            for (int i = 0; i < this.f2543d.size(); i++) {
                this.f2542c.addPath(this.f2543d.get(i).getPath());
            }
        } else if (iOrdinal == 1) {
            m722a(Path.Op.UNION);
        } else if (iOrdinal == 2) {
            m722a(Path.Op.REVERSE_DIFFERENCE);
        } else if (iOrdinal == 3) {
            m722a(Path.Op.INTERSECT);
        } else if (iOrdinal == 4) {
            m722a(Path.Op.XOR);
        }
        return this.f2542c;
    }
}
