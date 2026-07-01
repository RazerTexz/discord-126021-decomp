package b.i.a.c.b3.r;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.f3.Util2;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.b3.r.d, reason: use source file name */
/* JADX INFO: compiled from: SsaSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SsaSubtitle implements Subtitle {
    public final List<List<Cue>> j;
    public final List<Long> k;

    public SsaSubtitle(List<List<Cue>> list, List<Long> list2) {
        this.j = list;
        this.k = list2;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int f(long j) {
        int i;
        List<Long> list = this.k;
        Long lValueOf = Long.valueOf(j);
        int i2 = Util2.a;
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

    @Override // b.i.a.c.b3.Subtitle
    public long g(int i) {
        AnimatableValueParser.j(i >= 0);
        AnimatableValueParser.j(i < this.k.size());
        return this.k.get(i).longValue();
    }

    @Override // b.i.a.c.b3.Subtitle
    public List<Cue> h(long j) {
        int i;
        List<Long> list = this.k;
        Long lValueOf = Long.valueOf(j);
        int i2 = Util2.a;
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

    @Override // b.i.a.c.b3.Subtitle
    public int i() {
        return this.k.size();
    }
}
