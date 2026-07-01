package d0.g0;

import java.util.Iterator;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$b extends d0.t.a<e> implements f {
    public final /* synthetic */ g j;

    public g$b(g gVar) {
        this.j = gVar;
    }

    @Override // d0.t.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj != null ? obj instanceof e : true) {
            return contains((e) obj);
        }
        return false;
    }

    public e get(int i) {
        IntRange intRangeAccess$range = h.access$range(g.access$getMatchResult$p(this.j), i);
        if (intRangeAccess$range.getStart().intValue() < 0) {
            return null;
        }
        String strGroup = g.access$getMatchResult$p(this.j).group(i);
        d0.z.d.m.checkNotNullExpressionValue(strGroup, "matchResult.group(index)");
        return new e(strGroup, intRangeAccess$range);
    }

    @Override // d0.t.a
    public int getSize() {
        return g.access$getMatchResult$p(this.j).groupCount() + 1;
    }

    @Override // d0.t.a, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<e> iterator() {
        return d0.f0.q.map(d0.t.u.asSequence(d0.t.n.getIndices(this)), new g$b$a(this)).iterator();
    }

    public /* bridge */ boolean contains(e eVar) {
        return super.contains((Object) eVar);
    }
}
