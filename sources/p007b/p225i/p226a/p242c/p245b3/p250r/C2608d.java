package p007b.p225i.p226a.p242c.p245b3.p250r;

import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.b3.r.d */
/* JADX INFO: compiled from: SsaSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2608d implements InterfaceC2583g {

    /* JADX INFO: renamed from: j */
    public final List<List<C2578b>> f6018j;

    /* JADX INFO: renamed from: k */
    public final List<Long> f6019k;

    public C2608d(List<List<C2578b>> list, List<Long> list2) {
        this.f6018j = list;
        this.f6019k = list2;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        int i;
        List<Long> list = this.f6019k;
        Long lValueOf = Long.valueOf(j);
        int i2 = C2738e0.f6708a;
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
        if (i < this.f6019k.size()) {
            return i;
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        C1460d.m531j(i >= 0);
        C1460d.m531j(i < this.f6019k.size());
        return this.f6019k.get(i).longValue();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: h */
    public List<C2578b> mo2614h(long j) {
        int i;
        List<Long> list = this.f6019k;
        Long lValueOf = Long.valueOf(j);
        int i2 = C2738e0.f6708a;
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
        return i == -1 ? Collections.emptyList() : this.f6018j.get(i);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        return this.f6019k.size();
    }
}
