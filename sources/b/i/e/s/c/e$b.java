package b.i.e.s.c;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: FinderPatternFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b implements Serializable, Comparator<d> {
    private final float average;

    public e$b(float f, e$a e_a) {
        this.average = f;
    }

    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        d dVar3 = dVar;
        d dVar4 = dVar2;
        int iCompare = Integer.compare(dVar4.d, dVar3.d);
        return iCompare == 0 ? Float.compare(Math.abs(dVar3.c - this.average), Math.abs(dVar4.c - this.average)) : iCompare;
    }
}
