package b.i.e.s.c;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: FinderPatternFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c implements Serializable, Comparator<d> {
    private final float average;

    public e$c(float f, e$a e_a) {
        this.average = f;
    }

    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        return Float.compare(Math.abs(dVar2.c - this.average), Math.abs(dVar.c - this.average));
    }
}
