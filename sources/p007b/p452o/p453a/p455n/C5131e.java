package p007b.p452o.p453a.p455n;

import android.util.Range;
import java.util.Comparator;

/* JADX INFO: renamed from: b.o.a.n.e */
/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5131e implements Comparator<Range<Integer>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ boolean f13864j;

    public C5131e(C5130d c5130d, boolean z2) {
        this.f13864j = z2;
    }

    @Override // java.util.Comparator
    public int compare(Range<Integer> range, Range<Integer> range2) {
        Range<Integer> range3 = range;
        Range<Integer> range4 = range2;
        return this.f13864j ? (((Integer) range3.getUpper()).intValue() - ((Integer) range3.getLower()).intValue()) - (((Integer) range4.getUpper()).intValue() - ((Integer) range4.getLower()).intValue()) : (((Integer) range4.getUpper()).intValue() - ((Integer) range4.getLower()).intValue()) - (((Integer) range3.getUpper()).intValue() - ((Integer) range3.getLower()).intValue());
    }
}
