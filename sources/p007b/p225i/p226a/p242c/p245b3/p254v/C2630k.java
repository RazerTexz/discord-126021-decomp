package p007b.p225i.p226a.p242c.p245b3.p254v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.b3.v.k */
/* JADX INFO: compiled from: WebvttSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2630k implements InterfaceC2583g {

    /* JADX INFO: renamed from: j */
    public final List<C2626g> f6160j;

    /* JADX INFO: renamed from: k */
    public final long[] f6161k;

    /* JADX INFO: renamed from: l */
    public final long[] f6162l;

    public C2630k(List<C2626g> list) {
        this.f6160j = Collections.unmodifiableList(new ArrayList(list));
        this.f6161k = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            C2626g c2626g = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.f6161k;
            jArr[i2] = c2626g.f6132b;
            jArr[i2 + 1] = c2626g.f6133c;
        }
        long[] jArr2 = this.f6161k;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f6162l = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        int iM2994b = C2738e0.m2994b(this.f6162l, j, false, false);
        if (iM2994b < this.f6162l.length) {
            return iM2994b;
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        C1460d.m531j(i >= 0);
        C1460d.m531j(i < this.f6162l.length);
        return this.f6162l[i];
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: h */
    public List<C2578b> mo2614h(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.f6160j.size(); i++) {
            long[] jArr = this.f6161k;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                C2626g c2626g = this.f6160j.get(i);
                C2578b c2578b = c2626g.f6131a;
                if (c2578b.f5762p == -3.4028235E38f) {
                    arrayList2.add(c2626g);
                } else {
                    arrayList.add(c2578b);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: b.i.a.c.b3.v.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((C2626g) obj).f6132b, ((C2626g) obj2).f6132b);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            C2578b.b bVarM2605a = ((C2626g) arrayList2.get(i3)).f6131a.m2605a();
            bVarM2605a.f5777e = (-1) - i3;
            bVarM2605a.f5778f = 1;
            arrayList.add(bVarM2605a.m2606a());
        }
        return arrayList;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        return this.f6162l.length;
    }
}
