package b.o.a.n;

import android.util.Range;
import java.util.Comparator;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Comparator<Range<Integer>> {
    public final /* synthetic */ boolean j;

    public e(d dVar, boolean z2) {
        this.j = z2;
    }

    @Override // java.util.Comparator
    public int compare(Range<Integer> range, Range<Integer> range2) {
        Range<Integer> range3 = range;
        Range<Integer> range4 = range2;
        return this.j ? (((Integer) range3.getUpper()).intValue() - ((Integer) range3.getLower()).intValue()) - (((Integer) range4.getUpper()).intValue() - ((Integer) range4.getLower()).intValue()) : (((Integer) range4.getUpper()).intValue() - ((Integer) range4.getLower()).intValue()) - (((Integer) range3.getUpper()).intValue() - ((Integer) range3.getLower()).intValue());
    }
}
