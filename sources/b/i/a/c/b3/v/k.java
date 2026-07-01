package b.i.a.c.b3.v;

import b.i.a.c.b3.b$b;
import b.i.a.c.f3.e0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: WebvttSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements b.i.a.c.b3.g {
    public final List<g> j;
    public final long[] k;
    public final long[] l;

    public k(List<g> list) {
        this.j = Collections.unmodifiableList(new ArrayList(list));
        this.k = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            g gVar = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.k;
            jArr[i2] = gVar.f890b;
            jArr[i2 + 1] = gVar.c;
        }
        long[] jArr2 = this.k;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.l = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // b.i.a.c.b3.g
    public int f(long j) {
        int iB = e0.b(this.l, j, false, false);
        if (iB < this.l.length) {
            return iB;
        }
        return -1;
    }

    @Override // b.i.a.c.b3.g
    public long g(int i) {
        b.c.a.a0.d.j(i >= 0);
        b.c.a.a0.d.j(i < this.l.length);
        return this.l[i];
    }

    @Override // b.i.a.c.b3.g
    public List<b.i.a.c.b3.b> h(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.j.size(); i++) {
            long[] jArr = this.k;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                g gVar = this.j.get(i);
                b.i.a.c.b3.b bVar = gVar.a;
                if (bVar.p == -3.4028235E38f) {
                    arrayList2.add(gVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, b.j);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            b$b b_bA = ((g) arrayList2.get(i3)).a.a();
            b_bA.e = (-1) - i3;
            b_bA.f = 1;
            arrayList.add(b_bA.a());
        }
        return arrayList;
    }

    @Override // b.i.a.c.b3.g
    public int i() {
        return this.l.length;
    }
}
