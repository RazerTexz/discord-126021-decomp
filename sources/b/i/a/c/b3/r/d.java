package b.i.a.c.b3.r;

import b.i.a.c.b3.g;
import b.i.a.c.f3.e0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SsaSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements g {
    public final List<List<b.i.a.c.b3.b>> j;
    public final List<Long> k;

    public d(List<List<b.i.a.c.b3.b>> list, List<Long> list2) {
        this.j = list;
        this.k = list2;
    }

    @Override // b.i.a.c.b3.g
    public int f(long j) {
        int i;
        List<Long> list = this.k;
        Long lValueOf = Long.valueOf(j);
        int i2 = e0.a;
        int iBinarySearch = Collections.binarySearch(list, lValueOf);
        if (iBinarySearch < 0) {
            i = ~iBinarySearch;
        } else {
            int size = list.size();
            do {
                iBinarySearch++;
                if (iBinarySearch >= size) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(lValueOf) == 0);
            i = iBinarySearch;
        }
        if (i < this.k.size()) {
            return i;
        }
        return -1;
    }

    @Override // b.i.a.c.b3.g
    public long g(int i) {
        b.c.a.a0.d.j(i >= 0);
        b.c.a.a0.d.j(i < this.k.size());
        return this.k.get(i).longValue();
    }

    @Override // b.i.a.c.b3.g
    public List<b.i.a.c.b3.b> h(long j) {
        int i;
        List<Long> list = this.k;
        Long lValueOf = Long.valueOf(j);
        int i2 = e0.a;
        int iBinarySearch = Collections.binarySearch(list, lValueOf);
        if (iBinarySearch < 0) {
            i = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(lValueOf) == 0);
            i = iBinarySearch + 1;
        }
        return i == -1 ? Collections.emptyList() : this.j.get(i);
    }

    @Override // b.i.a.c.b3.g
    public int i() {
        return this.k.size();
    }
}
